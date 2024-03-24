package com.loser.core.support.aop;

import com.loser.core.cglib.CglibProxyHandler;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.base.RestFulPlugin;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 基于 cglib 实现 代理 进行插件替换
 *
 * @author loser
 */
public class RestFulCglibPluginReplaceHandler implements CglibProxyHandler<RestFulPlugin>, ApplicationContextAware {

    private static final Map<Class<?>, RestFulInPlugin> PLUGIN_HASH_MAP = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        initPlugin(applicationContext);
    }

    /**
     * 初始化插件,同类型最多允许存在一个,不自定义则使用内置默认插件
     */
    private static void initPlugin(ApplicationContext applicationContext) {

        Map<String, RestFulInPlugin> beans = applicationContext.getBeansOfType(RestFulInPlugin.class);
        if (CollectionUtils.isEmpty(beans)) {
            return;
        }
        Collection<RestFulInPlugin> plugins = beans.values();
        Map<? extends Class<? extends BaseRequestFunction>, List<RestFulInPlugin>> maps = plugins.stream().collect(Collectors.groupingBy(RestFulInPlugin::getTargetType));
        for (List<RestFulInPlugin> list : maps.values()) {
            RestFulInPlugin interceptor = list.get(0);
            if (list.size() != 1) {
                Class<?> superclass = interceptor.getClass().getInterfaces()[0];
                throw new RuntimeException("type " + superclass.getName() + " implement class must only one but find " + list.size());
            }
            PLUGIN_HASH_MAP.put(interceptor.getTargetType(), interceptor);
        }

    }

    /**
     * 拦截方法 并判断是否需要切换到自定义插件进行逻辑处理
     */
    @Override
    public Object invoke(RestFulPlugin annotation, MethodInvocation methodInvocation) throws Throwable {

        Class<? extends BaseRequestFunction> type = annotation.value();
        RestFulInPlugin fulInterceptor = PLUGIN_HASH_MAP.get(type);
        if (Objects.isNull(fulInterceptor)) {
            return methodInvocation.proceed();
        }
        return fulInterceptor.invoke(methodInvocation);

    }

}
