package com.loser.core.support.bean;

import com.loser.core.support.base.BaseRestFulHandlerFactory;
import com.loser.entity.RestFulFunction;
import com.loser.plugin.base.RestFulInPlugin;

import java.util.Objects;

/**
 * 总功能工厂类，可一次性替换全部插件
 *
 * @author loser
 * @see RestFulInPlugin 替换某一个插件
 */
public class RestFulHandlerFactory implements BaseRestFulHandlerFactory {

    private RestFulFunction restFulFunction;

    @Override
    public RestFulFunction getInstance() {

        if (Objects.nonNull(restFulFunction)) {
            return restFulFunction;
        }
        synchronized (RestFulHandlerFactory.class) {
            if (Objects.nonNull(restFulFunction)) {
                return restFulFunction;
            }
            restFulFunction = new RestFulFunction();
        }
        return restFulFunction;

    }

}
