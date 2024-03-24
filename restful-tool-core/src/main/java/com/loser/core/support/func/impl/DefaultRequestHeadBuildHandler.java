package com.loser.core.support.func.impl;

import com.loser.core.annotation.DeleteMapping;
import com.loser.core.annotation.GetMapping;
import com.loser.core.annotation.PostMapping;
import com.loser.core.annotation.PutMapping;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestHeadBuildHandler;
import com.loser.core.support.func.RequestHeadHandler;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DefaultRequestHeadBuildHandler implements RequestHeadBuildHandler {

    private static final Map<Class<? extends RequestHeadHandler>, RequestHeadHandler> HANDLER_MAP = new HashMap<>();

    @Override
    public ReqHead buildRequestHead(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args) {

        Map<String, String> heads = buildHeads(annotation, reqMethod, method, args);
        ReqHead reqHead = new ReqHead();
        reqHead.setHeads(heads);
        return reqHead;

    }

    private Map<String, String> buildHeads(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args) {

        String[] headers = new String[]{};
        Class<? extends RequestHeadHandler> headHandler = DefaultRequestHeadHandler.class;
        if (reqMethod == ReqMethod.POST) {
            PostMapping bizAnno = method.getAnnotation(PostMapping.class);
            headers = bizAnno.headers();
            headHandler = bizAnno.headHandler();
        }
        if (reqMethod == ReqMethod.GET) {
            GetMapping bizAnno = method.getAnnotation(GetMapping.class);
            headers = bizAnno.headers();
            headHandler = bizAnno.headHandler();
        }
        if (reqMethod == ReqMethod.PUT) {
            PutMapping bizAnno = method.getAnnotation(PutMapping.class);
            headers = bizAnno.headers();
            headHandler = bizAnno.headHandler();
        }
        if (reqMethod == ReqMethod.DELETE) {
            DeleteMapping bizAnno = method.getAnnotation(DeleteMapping.class);
            headers = bizAnno.headers();
            headHandler = bizAnno.headHandler();
        }
        if (Objects.equals(headHandler, DefaultRequestHeadHandler.class)) {
            headHandler = annotation.headHandler();
        }
        Map<String, String> reqHeads = getHandler(headHandler).doHead(annotation, reqMethod, method, args);
        for (String header : headers) {
            String[] item = header.split("=");
            if (item.length == 2) {
                reqHeads.put(item[0], item[1]);
            }
        }
        return reqHeads;

    }

    private RequestHeadHandler getHandler(Class<? extends RequestHeadHandler> target) {

        RequestHeadHandler headHandler = HANDLER_MAP.get(target);
        if (Objects.nonNull(headHandler)) {
            return headHandler;
        }
        synchronized (HANDLER_MAP) {
            headHandler = HANDLER_MAP.get(target);
            if (Objects.nonNull(headHandler)) {
                return headHandler;
            }
            try {
                headHandler = target.newInstance();
                HANDLER_MAP.put(target, headHandler);
            } catch (Exception e) {
                throw new RuntimeException("build headHandler error", e);
            }
        }
        return headHandler;

    }

}
