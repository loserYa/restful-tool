package com.loser.core.support.bean;

import com.loser.core.annotation.RequestLimit;
import com.loser.core.annotation.RequestRetry;
import com.loser.core.annotation.RequestRollBack;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRestFulHandlerFactory;
import com.loser.core.support.base.RestFulPlugin;
import com.loser.core.support.func.RequestBodyBuildHandler;
import com.loser.core.support.func.RequestHeadBuildHandler;
import com.loser.core.support.func.RequestLimitHandler;
import com.loser.core.support.func.RequestMethodBuildHandler;
import com.loser.core.support.func.RequestRetryHandler;
import com.loser.core.support.func.RequestRollBackHandler;
import com.loser.core.support.func.RequestTimeOutBuildHandler;
import com.loser.core.support.func.RequestUrlBuildHandler;
import com.loser.core.support.func.RestConverterHandler;
import com.loser.core.support.func.RestFulHttpExecutorHandler;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import com.loser.entity.TimeOut;
import com.loser.hardcode.Constant;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * 插件管理器
 * 单独抽取一个类然后被 cglib 代理去拦截 实现自定义替换插件
 *
 * @author loser
 */
public class RestFulPluginHandler implements ApplicationContextAware {

    private BaseRestFulHandlerFactory baseRestFulHandlerFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        if (Objects.nonNull(baseRestFulHandlerFactory)) {
            return;
        }
        if (applicationContext.containsBean(Constant.BEAN.FACTORY)) {
            baseRestFulHandlerFactory = applicationContext.getBean(Constant.BEAN.FACTORY, BaseRestFulHandlerFactory.class);
        } else {
            baseRestFulHandlerFactory = new RestFulHandlerFactory();
        }

    }

    @RestFulPlugin(RequestMethodBuildHandler.class)
    public ReqMethod buildRequestMethod(RestFulClient annotation, Method method) {
        return baseRestFulHandlerFactory.getInstance().getRequestMethodBuildHandler().buildRequestMethod(annotation, method);
    }

    @RestFulPlugin(RequestUrlBuildHandler.class)
    public RequestUrl buildRequestUrl(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args) {
        return baseRestFulHandlerFactory.getInstance().getRequestUrlBuildHandler().buildRequestUrl(annotation, reqMethod, method, args);
    }

    @RestFulPlugin(RequestHeadBuildHandler.class)
    public ReqHead buildRequestHead(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args) {
        return baseRestFulHandlerFactory.getInstance().getRequestHeadBuildHandler().buildRequestHead(annotation, reqMethod, method, args);
    }

    @RestFulPlugin(RequestBodyBuildHandler.class)
    public ReqBody buildRequestBody(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args) {
        return baseRestFulHandlerFactory.getInstance().getRequestBodyBuildHandler().buildRequestBody(annotation, reqMethod, method, args);
    }

    @RestFulPlugin(RequestTimeOutBuildHandler.class)
    public TimeOut buildRequestTimeOut(RestFulClient annotation, ReqMethod reqMethod, Method method) {
        return baseRestFulHandlerFactory.getInstance().getRequestTimeOutBuildHandler().buildRequestTimeOut(annotation, reqMethod, method);
    }

    @RestFulPlugin(RestFulHttpExecutorHandler.class)
    public String executor(ReqMethod reqMethod, RequestUrl requestUrl, TimeOut timeOut, ReqHead reqHead, ReqBody reqBody) {
        return baseRestFulHandlerFactory.getInstance().getRestFulHttpExecutorHandler().executor(reqMethod, requestUrl, timeOut, reqHead, reqBody);
    }

    @RestFulPlugin(RestConverterHandler.class)
    public Object converter(Method method, String res) {
        return baseRestFulHandlerFactory.getInstance().getRestConverterHandler().converter(method, res);
    }

    @RestFulPlugin(RequestRollBackHandler.class)
    public Object doRollBack(RestFulClient annotation, RequestRollBack requestRollBack, Object proxy, Method method, Object[] args) {
        return baseRestFulHandlerFactory.getInstance().getRequestRollBackHandler().doRollBack(annotation, requestRollBack, proxy, method, args);
    }

    @RestFulPlugin(RequestRetryHandler.class)
    public Object doRetry(RestFulClient annotation, RequestRetry requestRetry, Callable<Object> callable) {
        return baseRestFulHandlerFactory.getInstance().getRequestRetryHandler().doRetry(annotation, requestRetry, callable);
    }

    @RestFulPlugin(RequestLimitHandler.class)
    public void doLimit(RestFulClient annotation, RequestLimit requestLimit, Object proxy, Method method, Object[] args) {
        baseRestFulHandlerFactory.getInstance().getRequestLimitHandler().doLimit(annotation, requestLimit, proxy, method, args);
    }

}
