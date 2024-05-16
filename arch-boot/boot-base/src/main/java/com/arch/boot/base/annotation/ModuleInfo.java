package com.arch.boot.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//模块说明
@Target({ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInfo {
    String value() default "";
}
