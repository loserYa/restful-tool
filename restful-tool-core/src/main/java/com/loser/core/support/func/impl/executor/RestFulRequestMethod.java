package com.loser.core.support.func.impl.executor;

import com.loser.core.support.func.RestFulHttpExecutorHandler;
import com.loser.entity.ReqMethod;

/**
 * 区分不同请求方式
 *
 * @author loser
 */
public interface RestFulRequestMethod extends RestFulHttpExecutorHandler {

    ReqMethod getMethod();

}
