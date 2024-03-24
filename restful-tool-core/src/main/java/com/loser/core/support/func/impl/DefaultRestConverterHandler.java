package com.loser.core.support.func.impl;

import com.loser.core.support.func.RestConverterHandler;
import com.loser.utils.JsonUtil;

import java.lang.reflect.Method;
import java.util.Objects;

public class DefaultRestConverterHandler implements RestConverterHandler {


    @Override
    public Object converter(Method method, String res) {

        if (Objects.isNull(res) || res.length() == 0) {
            return null;
        }
        try {
            if (method.getReturnType().equals(String.class)) {
                return res;
            }
            return JsonUtil.parse(res, method.getGenericReturnType());
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }

    }

}
