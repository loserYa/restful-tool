package com.loser.core.support.base;

import com.loser.core.support.aop.RestFulCglibPluginReplaceHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标准这个这个方法是可插件方法可以被代理
 *
 * @author loser
 * @see RestFulCglibPluginReplaceHandler
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestFulPlugin {

    Class<? extends BaseRequestFunction> value();

}
