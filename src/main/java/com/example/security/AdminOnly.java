package com.example.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//元注解  表示运行完结束
@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)   //标注在方法级别
public @interface AdminOnly {
}
