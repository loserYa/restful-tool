package com.loser.core.annotation;

import com.loser.core.support.func.RequestHeadHandler;
import com.loser.core.support.func.impl.DefaultRequestHeadHandler;
import com.loser.entity.ReqBodyType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * post 请求
 *
 * @author loser
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PostMapping {

    String[] value() default {};

    String[] headers() default {};

    int timeOut() default -1;

    ReqBodyType bodyType() default ReqBodyType.JSON;

    Class<? extends RequestHeadHandler> headHandler() default DefaultRequestHeadHandler.class;

}
