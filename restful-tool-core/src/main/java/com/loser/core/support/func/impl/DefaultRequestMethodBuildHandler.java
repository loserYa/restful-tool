package com.loser.core.support.func.impl;

import com.loser.core.annotation.DeleteMapping;
import com.loser.core.annotation.GetMapping;
import com.loser.core.annotation.PostMapping;
import com.loser.core.annotation.PutMapping;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestMethodBuildHandler;
import com.loser.entity.ReqMethod;

import java.lang.reflect.Method;

public class DefaultRequestMethodBuildHandler implements RequestMethodBuildHandler {

    @Override
    public ReqMethod buildRequestMethod(RestFulClient annotation, Method method) {

        if (method.isAnnotationPresent(PostMapping.class)) {
            return ReqMethod.POST;
        }
        if (method.isAnnotationPresent(GetMapping.class)) {
            return ReqMethod.GET;
        }
        if (method.isAnnotationPresent(PutMapping.class)) {
            return ReqMethod.PUT;
        }
        if (method.isAnnotationPresent(DeleteMapping.class)) {
            return ReqMethod.DELETE;
        }
        throw new RuntimeException("build request method un support method");

    }

}
