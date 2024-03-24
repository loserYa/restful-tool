package com.loser.core.support.aop;

import com.loser.core.annotation.RequestLimit;
import com.loser.core.annotation.RequestRetry;
import com.loser.core.annotation.RequestRollBack;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.jdk.JdkProxyHandler;
import com.loser.core.support.bean.RestFulPluginHandler;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import com.loser.entity.TimeOut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 接口代理器处理类
 * 扫描带有 RestFulClient 的接口 生成代理类
 *
 * @author loser
 */
public class RestFulJdkProxyHandler implements JdkProxyHandler<RestFulClient>, ApplicationContextAware {

    /**
     * 插件管理代理类
     */
    private RestFulPluginHandler restFulPluginHandler;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        restFulPluginHandler = applicationContext.getBean(RestFulPluginHandler.class);
    }

    @Override
    public Object invoke(RestFulClient annotation, Object proxy, Method method, Object[] args) {

        // 01  请求限流
        RequestLimit requestLimit = method.isAnnotationPresent(RequestLimit.class) ? method.getAnnotation(RequestLimit.class) : method.getDeclaringClass().getAnnotation(RequestLimit.class);
        if (Objects.nonNull(requestLimit)) {
            restFulPluginHandler.doLimit(annotation, requestLimit, proxy, method, args);
        }
        try {
            // 02 执行或者重试执行
            RequestRetry requestRetry = method.isAnnotationPresent(RequestRetry.class) ? method.getAnnotation(RequestRetry.class) : method.getDeclaringClass().getAnnotation(RequestRetry.class);
            if (method.isAnnotationPresent(RequestRetry.class)) {
                return restFulPluginHandler.doRetry(annotation, requestRetry, () -> doInvoke(annotation, proxy, method, args));
            } else {
                return doInvoke(annotation, proxy, method, args);
            }
        } catch (Exception e) {
            // 异常降级
            RequestRollBack requestRollBack = method.isAnnotationPresent(RequestRollBack.class) ? method.getAnnotation(RequestRollBack.class) : method.getDeclaringClass().getAnnotation(RequestRollBack.class);
            if (Objects.nonNull(requestRollBack)) {
                return restFulPluginHandler.doRollBack(annotation, requestRollBack, proxy, method, args);
            }
            throw new RuntimeException(e);
        }

    }

    private Object doInvoke(RestFulClient annotation, Object proxy, Method method, Object[] args) {

        // 01 构建请求方式
        ReqMethod reqMethod = restFulPluginHandler.buildRequestMethod(annotation, method);

        // 02 构建请求地址
        RequestUrl requestUrl = restFulPluginHandler.buildRequestUrl(annotation, reqMethod, method, args);

        // 03 构建请求头
        ReqHead reqHead = restFulPluginHandler.buildRequestHead(annotation, reqMethod, method, args);

        // 04 构建请求体
        ReqBody reqBody = restFulPluginHandler.buildRequestBody(annotation, reqMethod, method, args);

        // 05 构建超时参数
        TimeOut timeOut = restFulPluginHandler.buildRequestTimeOut(annotation, reqMethod, method);

        // 06 执行请求
        String res = restFulPluginHandler.executor(reqMethod, requestUrl, timeOut, reqHead, reqBody);

        // 07 返回值转换
        return restFulPluginHandler.converter(method, res);

    }

}
