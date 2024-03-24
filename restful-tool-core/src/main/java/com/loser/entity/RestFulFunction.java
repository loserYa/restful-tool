package com.loser.entity;

import com.loser.core.support.func.RequestBodyBuildHandler;
import com.loser.core.support.func.RequestHeadBuildHandler;
import com.loser.core.support.func.RequestLimitHandler;
import com.loser.core.support.func.RequestMethodBuildHandler;
import com.loser.core.support.func.RequestRetryHandler;
import com.loser.core.support.func.RequestRollBackHandler;
import com.loser.core.support.func.RequestTimeOutBuildHandler;
import com.loser.core.support.func.RequestUrlBuildHandler;
import com.loser.core.support.func.RestConverterHandler;
import com.loser.core.support.func.RestFulHttpExecutorHandler;
import com.loser.core.support.func.impl.DefaultRequestBodyBuildHandler;
import com.loser.core.support.func.impl.DefaultRequestHeadBuildHandler;
import com.loser.core.support.func.impl.DefaultRequestLimitHandler;
import com.loser.core.support.func.impl.DefaultRequestMethodBuildHandler;
import com.loser.core.support.func.impl.DefaultRequestRetryHandler;
import com.loser.core.support.func.impl.DefaultRequestRollBackHandler;
import com.loser.core.support.func.impl.DefaultRequestTimeOutBuildHandler;
import com.loser.core.support.func.impl.DefaultRequestUrlBuildHandler;
import com.loser.core.support.func.impl.DefaultRestConverterHandler;
import com.loser.core.support.func.impl.DefaultRestFulHttpExecutorHandler;

public class RestFulFunction {

    private RequestMethodBuildHandler requestMethodBuildHandler;
    private RequestUrlBuildHandler requestUrlBuildHandler;
    private RequestHeadBuildHandler requestHeadBuildHandler;
    private RequestBodyBuildHandler requestBodyBuildHandler;
    private RestFulHttpExecutorHandler restFulHttpExecutorHandler;
    private RestConverterHandler restConverterHandler;
    private RequestTimeOutBuildHandler requestTimeOutBuildHandler;
    private RequestLimitHandler requestLimitHandler;
    private RequestRetryHandler requestRetryHandler;
    private RequestRollBackHandler requestRollBackHandler;

    public RestFulFunction() {

        requestMethodBuildHandler = new DefaultRequestMethodBuildHandler();
        requestUrlBuildHandler = new DefaultRequestUrlBuildHandler();
        requestHeadBuildHandler = new DefaultRequestHeadBuildHandler();
        requestBodyBuildHandler = new DefaultRequestBodyBuildHandler();
        restFulHttpExecutorHandler = new DefaultRestFulHttpExecutorHandler();
        restConverterHandler = new DefaultRestConverterHandler();
        requestTimeOutBuildHandler = new DefaultRequestTimeOutBuildHandler();
        requestLimitHandler = new DefaultRequestLimitHandler();
        requestRetryHandler = new DefaultRequestRetryHandler();
        requestRollBackHandler = new DefaultRequestRollBackHandler();

    }

    public RequestMethodBuildHandler getRequestMethodBuildHandler() {
        return requestMethodBuildHandler;
    }

    public void setRequestMethodBuildHandler(RequestMethodBuildHandler requestMethodBuildHandler) {
        this.requestMethodBuildHandler = requestMethodBuildHandler;
    }

    public RequestUrlBuildHandler getRequestUrlBuildHandler() {
        return requestUrlBuildHandler;
    }

    public void setRequestUrlBuildHandler(RequestUrlBuildHandler requestUrlBuildHandler) {
        this.requestUrlBuildHandler = requestUrlBuildHandler;
    }

    public RequestHeadBuildHandler getRequestHeadBuildHandler() {
        return requestHeadBuildHandler;
    }

    public void setRequestHeadBuildHandler(RequestHeadBuildHandler requestHeadBuildHandler) {
        this.requestHeadBuildHandler = requestHeadBuildHandler;
    }

    public RequestBodyBuildHandler getRequestBodyBuildHandler() {
        return requestBodyBuildHandler;
    }

    public void setRequestBodyBuildHandler(RequestBodyBuildHandler requestBodyBuildHandler) {
        this.requestBodyBuildHandler = requestBodyBuildHandler;
    }

    public RestFulHttpExecutorHandler getRestFulHttpExecutorHandler() {
        return restFulHttpExecutorHandler;
    }

    public void setRestFulHttpExecutorHandler(RestFulHttpExecutorHandler restFulHttpExecutorHandler) {
        this.restFulHttpExecutorHandler = restFulHttpExecutorHandler;
    }

    public RestConverterHandler getRestConverterHandler() {
        return restConverterHandler;
    }

    public void setRestConverterHandler(RestConverterHandler restConverterHandler) {
        this.restConverterHandler = restConverterHandler;
    }

    public RequestTimeOutBuildHandler getRequestTimeOutBuildHandler() {
        return requestTimeOutBuildHandler;
    }

    public void setRequestTimeOutBuildHandler(RequestTimeOutBuildHandler requestTimeOutBuildHandler) {
        this.requestTimeOutBuildHandler = requestTimeOutBuildHandler;
    }

    public RequestLimitHandler getRequestLimitHandler() {
        return requestLimitHandler;
    }

    public void setRequestLimitHandler(RequestLimitHandler requestLimitHandler) {
        this.requestLimitHandler = requestLimitHandler;
    }

    public RequestRetryHandler getRequestRetryHandler() {
        return requestRetryHandler;
    }

    public void setRequestRetryHandler(RequestRetryHandler requestRetryHandler) {
        this.requestRetryHandler = requestRetryHandler;
    }

    public RequestRollBackHandler getRequestRollBackHandler() {
        return requestRollBackHandler;
    }

    public void setRequestRollBackHandler(RequestRollBackHandler requestRollBackHandler) {
        this.requestRollBackHandler = requestRollBackHandler;
    }
}
