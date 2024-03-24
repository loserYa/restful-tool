package com.loser.core.support.func;

import com.loser.core.annotation.RestFulClient;
import com.loser.entity.ReqMethod;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 自定义请求头 构建插件
 *
 * @author loser
 */
public interface RequestHeadHandler {

    Map<String, String> doHead(RestFulClient annotation, ReqMethod reqMethod, Method method, Object[] args);

}
