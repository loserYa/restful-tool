package com.loser.plugin;

import com.loser.core.annotation.RequestRetry;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RequestRetryHandler;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

import java.util.concurrent.Callable;

/**
 * 自定请求拦截器
 *
 * @author loser
 */
public interface RequestRetryHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return doRetry((RestFulClient) arguments[0], (RequestRetry) arguments[1], (Callable<Object>) arguments[2], methodInvocation);
    }

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RequestRetryHandler.class;
    }


    Object doRetry(RestFulClient annotation, RequestRetry requestRetry, Callable<Object> callable, MethodInvocation methodInvocation);


}
