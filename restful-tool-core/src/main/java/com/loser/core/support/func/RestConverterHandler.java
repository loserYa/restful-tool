package com.loser.core.support.func;

import com.loser.core.support.base.BaseRequestFunction;

import java.lang.reflect.Method;

/**
 * 结构转换构建插件
 *
 * @author loser
 */
public interface RestConverterHandler extends BaseRequestFunction {

    Object converter(Method method, String res);

}
