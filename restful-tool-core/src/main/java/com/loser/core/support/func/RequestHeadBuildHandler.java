package com.loser.core.support.func;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;

import java.lang.reflect.Method;

/**
 * 请求投构建 插件处理类
 *
 * @author loser
 */
public interface RequestHeadBuildHandler extends BaseRequestFunction {

    ReqHead buildRequestHead(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args);

}
