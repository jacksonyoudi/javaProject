package org.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解
 * Target：使用范围
 * Retention: 保存级别，注解的生命周期
 */

@Target(value = {ElementType.METHOD})
public @interface MyAnnotation {
    String studentName() default "";
    int age() default 0;
    int id() default -1;

    String[] school() default {"hello"};
}
