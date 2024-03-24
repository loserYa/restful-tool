package com.loser.plugin;

import com.loser.core.annotation.RequestLimit;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RequestLimitHandler;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 自定请求拦截器
 *
 * @author loser
 */
public interface RequestLimitHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        doLimit((RestFulClient) arguments[0], (RequestLimit) arguments[1], arguments[2], (Method) arguments[3], (Object[]) arguments[4], methodInvocation);
        return null;
    }

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RequestLimitHandler.class;
    }

    void doLimit(RestFulClient annotation, RequestLimit requestLimit, Object proxy, Method method, Object[] args, MethodInvocation methodInvocation);

}
