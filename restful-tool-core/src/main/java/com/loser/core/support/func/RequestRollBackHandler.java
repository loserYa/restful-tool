package com.loser.core.support.func;

import com.loser.core.annotation.RequestRollBack;
import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;

import java.lang.reflect.Method;

/**
 * 请求降级处理器
 *
 * @author loser
 */
public interface RequestRollBackHandler extends BaseRequestFunction {

    Object doRollBack(RestFulClient annotation, RequestRollBack requestRollBack, Object proxy, Method method, Object[] args);

}
