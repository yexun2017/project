package com.wwx.myo2o.test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/11/2  15:24
 **/
@Target(value = {FIELD})//Target:此注解用到的地方有TYPE、FIELD、METHOD
@Retention(value = RUNTIME)//注解的运行环境
public @interface  CustomConnection {
    String url() default "";
    String driverClass() default "";
    String username() default "";
    String password() default "";
}
