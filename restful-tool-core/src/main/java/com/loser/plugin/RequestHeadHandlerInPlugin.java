package com.loser.plugin;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RequestHeadBuildHandler;
import com.loser.entity.ReqMethod;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 使用自定义类额外添加请求头信息（动态信息:比如token、sign）
 *
 * @author loser
 */
public interface RequestHeadHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return doHead((RestFulClient) arguments[0], (ReqMethod) arguments[1], (Method) arguments[2], (Object[]) arguments[3], methodInvocation);
    }

    Map<String, String> doHead(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args, MethodInvocation methodInvocation) throws Throwable;

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RequestHeadBuildHandler.class;
    }

}
