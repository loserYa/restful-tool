package com.loser.plugin;

import com.loser.core.support.base.BaseRequestFunction;
import com.loser.core.support.func.RestConverterHandler;
import com.loser.plugin.base.RestFulInPlugin;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 结构装换器插件
 *
 * @author loser
 */
public interface RestConverterHandlerInPlugin extends RestFulInPlugin {

    @Override
    default Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        return converter(arguments[0], arguments[1], methodInvocation);
    }

    @Override
    default Class<? extends BaseRequestFunction> getTargetType() {
        return RestConverterHandler.class;
    }

    Object converter(Object target, Object res, MethodInvocation methodInvocation) throws Throwable;

}
