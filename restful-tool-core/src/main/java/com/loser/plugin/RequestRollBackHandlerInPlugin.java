package com.loser.plugin;

import com.loser.core.annotation.RequestRollBack;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RequestRollBackHandler;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 自定请求拦截器
 *
 * @author loser
 */
public interface RequestRollBackHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return doRollBack((RestFulClient) arguments[0], (RequestRollBack) arguments[1], arguments[2], (Method) arguments[3], (Object[]) arguments[4], methodInvocation);
    }

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RequestRollBackHandler.class;
    }


    Object doRollBack(RestFulClient annotation, RequestRollBack requestRollBack, Object proxy, Method method, Object[] args, MethodInvocation methodInvocation);
}
