package com.loser.core.support.func;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;

import java.lang.reflect.Method;

/**
 * 请求地址构建插件
 *
 * @author loser
 */
public interface RequestUrlBuildHandler extends BaseRequestFunction {

    RequestUrl buildRequestUrl(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args);

}
