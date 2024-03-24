package com.loser.plugin;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RequestTimeOutBuildHandler;
import com.loser.entity.ReqMethod;
import com.loser.entity.TimeOut;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 构建接口超时插件
 *
 * @author loser
 */
public interface RequestTimeOutBuildHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return buildRequestTimeOut((RestFulClient) arguments[0], (ReqMethod) arguments[1], (Method) arguments[2], methodInvocation);
    }

    TimeOut buildRequestTimeOut(RestFulClient annotation, ReqMethod reqMethod, Method method, MethodInvocation methodInvocation) throws Throwable;

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RequestTimeOutBuildHandler.class;
    }

}
