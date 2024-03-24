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
 * delete 方式
 *
 * @author loser
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DeleteMapping {

    String[] value() default {};

    String[] headers() default {};

    int timeOut() default -1;

    ReqBodyType bodyType() default ReqBodyType.NONE;

    Class<? extends RequestHeadHandler> headHandler() default DefaultRequestHeadHandler.class;

}
