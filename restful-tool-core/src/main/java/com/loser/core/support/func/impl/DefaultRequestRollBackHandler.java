package com.loser.core.support.func.impl;

import com.loser.core.annotation.RequestRollBack;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestRollBackHandler;

import java.lang.reflect.Method;

public class DefaultRequestRollBackHandler implements RequestRollBackHandler {

    @Override
    public Object doRollBack(RestFulClient annotation, RequestRollBack requestRollBack, Object proxy, Method method, Object[] args) {

        try {
            Class<?> clazz = requestRollBack.rollBack();
            Object handler = clazz.newInstance();
            Method rollBackMethod = clazz.getMethod(method.getName(), method.getParameterTypes());
            return rollBackMethod.invoke(handler, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
