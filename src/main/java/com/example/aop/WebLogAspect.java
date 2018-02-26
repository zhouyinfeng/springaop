package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WebLogAspect {
protected static org.slf4j.Logger logger= LoggerFactory.getLogger(WebLogAspect.class);

//切入点
@Pointcut("execution(public * com.example.web..*.*(..))")
    public void webLog(){
    System.out.println("webLog().............");
}

@Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
    System.out.println("进入doBefore切面");
    logger.info("后置拦截--------->");
    //接收到请求 记录请求内容
    ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    //记录下面内容
    logger.info("URL--------->:" +request.getRequestURL().toString());
    logger.info("HTTP_METHOD---------> " +request.getMethod());
    logger.info("IP---------> "+request.getRemoteAddr());
    logger.info("CLASS_METHOD--------->"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
}

@AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        logger.info("后置拦截--------->"+ret);
        logger.info("RESPONSE--------->"+ret);
    }

   /* @Around("webLog()")
    public void doAround(ProceedingJoinPoint joinPoint){
        logger.info("进入环绕通知-----------------》");
    }*/
}
