package com.loser.core.support.func;

import com.loser.core.annotation.RestFulClient;
import com.loser.core.support.base.BaseRequestFunction;
import com.loser.entity.ReqMethod;

import java.lang.reflect.Method;

/**
 * 请求方式构建插件
 *
 * @author loser
 */
public interface RequestMethodBuildHandler extends BaseRequestFunction {

    ReqMethod buildRequestMethod(RestFulClient annotation, Method method);

}
