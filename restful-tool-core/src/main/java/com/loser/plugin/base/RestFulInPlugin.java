package com.loser.plugin.base;

import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.bean.RestFulHandlerFactory;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 声明插件
 *
 * @author loser
 * @see RestFulHandlerFactory 一次性替换全部插件
 */
public interface RestFulInPlugin {

    /**
     * 插件执行逻辑
     */
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return methodInvocation.proceed();
    }

    /**
     * 使用插件的对象
     */
    Class<? extends BaseRequestFunction> getTargetType();

}
