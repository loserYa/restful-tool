package com.loser.core.support.func;

import com.loser.core.annotation.RequestLimit;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;

import java.lang.reflect.Method;

/**
 * 请求限流处理器
 *
 * @author loser
 */
public interface RequestLimitHandler extends BaseRequestFunction {

    void doLimit(RestFulClient annotation, RequestLimit requestLimit, Object proxy, Method method, Object[] args);

}
