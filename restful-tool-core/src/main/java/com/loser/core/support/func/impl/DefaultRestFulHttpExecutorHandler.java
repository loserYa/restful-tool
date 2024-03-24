package com.loser.core.support.func.impl;

import com.loser.core.support.func.RestFulHttpExecutorHandler;
import com.loser.core.support.func.impl.executor.DeleteExecutorHandler;
import com.loser.core.support.func.impl.executor.GetExecutorHandler;
import com.loser.core.support.func.impl.executor.PostExecutorHandler;
import com.loser.core.support.func.impl.executor.PutExecutorHandler;
import com.loser.core.support.func.impl.executor.RestFulRequestMethod;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import com.loser.entity.TimeOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class DefaultRestFulHttpExecutorHandler implements RestFulHttpExecutorHandler {

    private static final Map<ReqMethod, RestFulRequestMethod> HANDLER_MAP = new HashMap<>();

    static {
        List<? extends RestFulRequestMethod> handlers = Arrays.asList(
                new PostExecutorHandler(),
                new GetExecutorHandler(),
                new DeleteExecutorHandler(),
                new PutExecutorHandler()
        );
        for (RestFulRequestMethod handler : handlers) {
            HANDLER_MAP.put(handler.getMethod(), handler);
        }
    }

    @Override
    public String executor(ReqMethod reqMethod, RequestUrl requestUrl, TimeOut timeOut, ReqHead reqHead, ReqBody reqBody) {

        RestFulRequestMethod handler = HANDLER_MAP.get(reqMethod);
        if (Objects.isNull(handler)) {
            throw new RuntimeException("not find handler by " + reqMethod);
        }
        return handler.executor(reqMethod, requestUrl, timeOut, reqHead, reqBody);

    }

}
