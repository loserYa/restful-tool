package com.loser.core.support.func.impl;

import com.loser.core.annotation.RequestRetry;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.func.RequestRetryHandler;
import com.loser.utils.RetryUtil;

import java.util.concurrent.Callable;

public class DefaultRequestRetryHandler implements RequestRetryHandler {

    @Override
    public Object doRetry(RestFulClient annotation, RequestRetry requestRetry, Callable<Object> callable) {

        try {
            return RetryUtil.retry(callable, requestRetry.exception(), requestRetry.sleepTime(), requestRetry.retryNum());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
