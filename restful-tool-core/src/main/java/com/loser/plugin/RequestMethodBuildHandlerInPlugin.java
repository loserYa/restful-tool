package com.loser.plugin;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RequestMethodBuildHandler;
import com.loser.entity.ReqMethod;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 构建请求方式插件
 *
 * @author loser
 */
public interface RequestMethodBuildHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return buildRequestMethod((RestFulClient) arguments[0], (Method) arguments[1], methodInvocation);
    }

    ReqMethod buildRequestMethod(RestFulClient annotation, Method method, MethodInvocation methodInvocation) throws Throwable;

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RequestMethodBuildHandler.class;
    }

}
