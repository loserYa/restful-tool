package com.loser.plugin;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RequestBodyBuildHandler;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqMethod;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 构建请求体插件
 *
 * @author loser
 */
public interface RequestBodyBuildHandlerInPlugin extends RestFulInPlugin {

    ReqBody buildRequestBody(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args, MethodInvocation methodInvocation) throws Throwable;

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return buildRequestBody((RestFulClient) arguments[0], (ReqMethod) arguments[1], (Method) arguments[2], (Object[]) arguments[3], methodInvocation);
    }

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RequestBodyBuildHandler.class;
    }

}
