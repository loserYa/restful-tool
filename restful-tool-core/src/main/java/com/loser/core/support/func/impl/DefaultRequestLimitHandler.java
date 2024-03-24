package com.loser.core.support.func.impl;

import com.loser.core.annotation.RequestLimit;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestLimitHandler;

import java.lang.reflect.Method;

public class DefaultRequestLimitHandler implements RequestLimitHandler {

    @Override
    public void doLimit(RestFulClient annotation, RequestLimit requestLimit, Object proxy, Method method, Object[] args) {

    }

}
