package com.loser.core.annotation;

import com.loser.core.support.func.RequestHeadHandler;
import com.loser.core.support.func.impl.DefaultRequestHeadHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记接口可以被代理
 *
 * @author loser
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestFulClient {

    String host() default "";

    int timeOut() default -1;

    Class<? extends RequestHeadHandler> headHandler() default DefaultRequestHeadHandler.class;

}
