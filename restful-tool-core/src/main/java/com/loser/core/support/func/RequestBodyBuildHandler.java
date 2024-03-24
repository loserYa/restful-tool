package com.loser.core.support.func;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqMethod;

import java.lang.reflect.Method;

/**
 * 请求体构建 插件处理类
 *
 * @author loser
 */
public interface RequestBodyBuildHandler extends BaseRequestFunction {

    ReqBody buildRequestBody(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args);

}
