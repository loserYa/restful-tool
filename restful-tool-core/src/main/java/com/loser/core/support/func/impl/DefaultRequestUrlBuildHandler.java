package com.loser.core.support.func.impl;

import com.loser.core.annotation.DeleteMapping;
import com.loser.core.annotation.GetMapping;
import com.loser.core.annotation.PathVariable;
import com.loser.core.annotation.PostMapping;
import com.loser.core.annotation.PutMapping;
import com.loser.core.annotation.RequestParam;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestUrlBuildHandler;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DefaultRequestUrlBuildHandler implements RequestUrlBuildHandler {

    @Override
    public RequestUrl buildRequestUrl(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args) {

        RequestUrl requestUrl = new RequestUrl();
        String host = annotation.host();
        String uri = getUri(reqMethod, method);
        uri = appendParams(uri, method, args);
        String url = host + uri;
        requestUrl.setUrl(url);
        return requestUrl;

    }

    private String appendParams(String uri, Method method, Object[] args) {

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations.length == 0) {
            return uri;
        }
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> pathParams = new HashMap<>();
        int index = 0;
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof RequestParam) {
                    RequestParam biz = (RequestParam) annotation;
                    String paramName = biz.value();
                    params.put(paramName, args[index]);
                } else if (annotation instanceof PathVariable) {
                    PathVariable biz = (PathVariable) annotation;
                    String paramName = biz.value();
                    pathParams.put(paramName, args[index]);
                }
            }
            index++;
        }
        if (!CollectionUtils.isEmpty(params)) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (sb.length() == 0) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(entry.getKey()).append("=").append(entry.getValue());
            }
            uri = uri + sb;
        }
        if (!CollectionUtils.isEmpty(pathParams)) {
            for (Map.Entry<String, Object> entry : pathParams.entrySet()) {
                uri = uri.replaceAll("\\{" + entry.getKey() + "}", entry.getValue().toString());
            }
        }

        return uri;

    }

    private String getUri(ReqMethod reqMethod, Method method) {

        if (ReqMethod.POST == reqMethod) {
            return method.getAnnotation(PostMapping.class).value()[0];
        }
        if (ReqMethod.GET == reqMethod) {
            return method.getAnnotation(GetMapping.class).value()[0];
        }
        if (ReqMethod.PUT == reqMethod) {
            return method.getAnnotation(PutMapping.class).value()[0];
        }
        if (ReqMethod.DELETE == reqMethod) {
            return method.getAnnotation(DeleteMapping.class).value()[0];
        }
        throw new RuntimeException("build url un support method by " + method);

    }

}
