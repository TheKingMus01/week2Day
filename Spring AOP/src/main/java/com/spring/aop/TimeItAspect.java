package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeItAspect {

    @Pointcut("@annotation(com.example.TimeIt)")
    public void timeItAnnotatedMethod() {}

    @AfterReturning(pointcut = "timeItAnnotatedMethod()", returning = "result")
    public void logTimeItExecutionTime(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        long elapsedTime = System.currentTimeMillis() - TimeItThreadLocal.getStartTime();
        System.out.println("Method " + methodName + " took " + elapsedTime + "ms to execute.");
    }
}