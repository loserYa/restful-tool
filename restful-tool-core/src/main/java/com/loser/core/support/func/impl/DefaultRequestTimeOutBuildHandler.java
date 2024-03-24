package com.loser.core.support.func.impl;

import com.loser.core.annotation.DeleteMapping;
import com.loser.core.annotation.GetMapping;
import com.loser.core.annotation.PostMapping;
import com.loser.core.annotation.PutMapping;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestTimeOutBuildHandler;
import com.loser.entity.ReqMethod;
import com.loser.entity.TimeOut;

import java.lang.reflect.Method;

public class DefaultRequestTimeOutBuildHandler implements RequestTimeOutBuildHandler {

    @Override
    public TimeOut buildRequestTimeOut(RestFulClient annotation, ReqMethod reqMethod, Method method) {

        TimeOut timeOut = new TimeOut();
        int time = buildTime(reqMethod, method);
        time = time == -1 ? annotation.timeOut() : time;
        timeOut.setTimeOut(time);
        return timeOut;

    }

    private int buildTime(ReqMethod reqMethod, Method method) {

        if (reqMethod == ReqMethod.POST) {
            return method.getAnnotation(PostMapping.class).timeOut();
        }
        if (reqMethod == ReqMethod.GET) {
            return method.getAnnotation(GetMapping.class).timeOut();
        }
        if (reqMethod == ReqMethod.PUT) {
            return method.getAnnotation(PutMapping.class).timeOut();
        }
        if (reqMethod == ReqMethod.DELETE) {
            return method.getAnnotation(DeleteMapping.class).timeOut();
        }
        throw new RuntimeException("build timeOut un support method by " + reqMethod);

    }

}
