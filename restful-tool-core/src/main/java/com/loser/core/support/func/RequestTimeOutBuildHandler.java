package com.loser.core.support.func;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.entity.ReqMethod;
import com.loser.entity.TimeOut;

import java.lang.reflect.Method;

/**
 * 超时参数构建插件
 *
 * @author loser
 */
public interface RequestTimeOutBuildHandler extends BaseRequestFunction {

    TimeOut buildRequestTimeOut(RestFulClient annotation, ReqMethod reqMethod, Method method);

}
