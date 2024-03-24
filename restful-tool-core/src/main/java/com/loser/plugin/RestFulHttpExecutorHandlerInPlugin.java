package com.loser.plugin;

import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RestFulHttpExecutorHandler;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import com.loser.entity.TimeOut;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 构建请求执行器插件
 *
 * @author loser
 */
public interface RestFulHttpExecutorHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return executor((ReqMethod) arguments[0], (RequestUrl) arguments[1], (TimeOut) arguments[2], (ReqHead) arguments[3], (ReqBody) arguments[4], methodInvocation);
    }

    default Class<? extends BaseRequestFunction> getTargetType() {
        return RestFulHttpExecutorHandler.class;
    }

    String executor(ReqMethod reqMethod, RequestUrl requestUrl, TimeOut timeOut, ReqHead reqHead, ReqBody reqBody, MethodInvocation methodInvocation) throws Throwable;

}
