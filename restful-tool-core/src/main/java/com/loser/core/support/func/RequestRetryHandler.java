package com.loser.core.support.func;

import com.loser.core.annotation.RequestRetry;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;

import java.util.concurrent.Callable;

/**
 * 请求重试处理器
 *
 * @author loser
 */
public interface RequestRetryHandler extends BaseRequestFunction {

    Object doRetry(RestFulClient annotation, RequestRetry requestRetry, Callable<Object> callable);

}
