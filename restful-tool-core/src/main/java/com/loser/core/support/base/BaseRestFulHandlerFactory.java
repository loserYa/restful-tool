package com.loser.core.support.base;

import com.loser.entity.RestFulFunction;
import com.loser.plugin.base.RestFulInPlugin;

/**
 * 总功能工厂类，可一次性替换全部插件
 *
 * @author loser
 * @see RestFulInPlugin 替换某一个插件
 */
public interface BaseRestFulHandlerFactory {

    RestFulFunction getInstance();

}
