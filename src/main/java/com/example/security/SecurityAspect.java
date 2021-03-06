package com.example.security;

import com.example.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect  //定义一个切面
@Component
public class SecurityAspect {
    @Autowired
    AuthService authService;

    @Pointcut("@annotation(AdminOnly)")   //定义要切的方法
    public void adminOnly(){
    }

    @Before("adminOnly()")
    public void check(){
        authService.checkAccess();
    }
}
