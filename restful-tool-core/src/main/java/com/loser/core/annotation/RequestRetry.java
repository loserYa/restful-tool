package com.loser.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求重试
 *
 * @author loser
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestRetry {

    boolean timeOut() default true;

    boolean exception() default true;

    int retryNum() default 1;

    long sleepTime() default 100;

}
