package com.loser.plugin;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RequestHeadBuildHandler;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 构建请求头插件
 *
 * @author loser
 */
public interface RequestHeadBuildHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return buildRequestHead((RestFulClient) arguments[0], (ReqMethod) arguments[1], (Method) arguments[2], (Object[]) arguments[3], methodInvocation);
    }

    ReqHead buildRequestHead(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args, MethodInvocation methodInvocation) throws Throwable;

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RequestHeadBuildHandler.class;
    }

}
