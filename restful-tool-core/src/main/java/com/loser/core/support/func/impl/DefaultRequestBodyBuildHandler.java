package com.loser.core.support.func.impl;

import com.loser.core.annotation.DeleteMapping;
import com.loser.core.annotation.GetMapping;
import com.loser.core.annotation.PostMapping;
import com.loser.core.annotation.PutMapping;
import com.loser.core.annotation.RequestBody;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestBodyBuildHandler;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqBodyType;
import com.loser.entity.ReqMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultRequestBodyBuildHandler implements RequestBodyBuildHandler {

    @Override
    public ReqBody buildRequestBody(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args) {

        ReqBodyType bodyType = buildBodyType(reqMethod, method);
        if (bodyType == ReqBodyType.NONE) {
            return new ReqBody();
        }
        Map<String, Object> body = buildBody(method, args);
        ReqBody reqBody = new ReqBody();
        reqBody.setType(bodyType);
        reqBody.setBody(body);
        return reqBody;

    }

    private Map<String, Object> buildBody(Method method, Object[] args) {

        Map<String, Object> body = new HashMap<>();
        int index = 0;
        for (Parameter parameter : method.getParameters()) {
            if (parameter.isAnnotationPresent(RequestBody.class)) {
                Object arg = args[index];
                if (arg instanceof Map) {
                    Set<? extends Map.Entry<?, ?>> entries = ((Map<?, ?>) arg).entrySet();
                    for (Map.Entry<?, ?> entry : entries) {
                        body.put(entry.getKey().toString(), entry.getValue());
                    }
                } else {
                    for (Field field : arg.getClass().getDeclaredFields()) {
                        try {
                            body.put(field.getName(), field.get(arg));
                        } catch (Exception e) {
                            throw new RuntimeException("build body getField value throw a e", e);
                        }
                    }
                }
                return body;
            }
            index++;
        }
        return body;

    }

    private ReqBodyType buildBodyType(ReqMethod reqMethod, Method method) {

        if (reqMethod == ReqMethod.POST) {
            return method.getAnnotation(PostMapping.class).bodyType();
        }
        if (reqMethod == ReqMethod.PUT) {
            return method.getAnnotation(PutMapping.class).bodyType();
        }
        if (reqMethod == ReqMethod.GET) {
            return method.getAnnotation(GetMapping.class).bodyType();
        }
        if (reqMethod == ReqMethod.DELETE) {
            return method.getAnnotation(DeleteMapping.class).bodyType();
        }

        throw new RuntimeException("build body type un support by " + reqMethod);

    }

}
