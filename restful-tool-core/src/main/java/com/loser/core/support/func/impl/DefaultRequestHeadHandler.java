package com.loser.core.support.func.impl;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestHeadHandler;
import com.loser.entity.ReqMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DefaultRequestHeadHandler implements RequestHeadHandler {

    @Override
    public Map<String, String> doHead(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args) {
        return new HashMap<>();
    }

}
