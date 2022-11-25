package com.systematic.aop.workshop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RetryService {

    @Pointcut("execution(* com.systematic.aop.workshop.services.ConnectionService.connect(..))")
    public void connect() {
    }

    @Around("connect()")
    public Object retryMechanism(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnValue;
        try {
            returnValue = proceedingJoinPoint.proceed();
        } catch (IllegalStateException e){
            return retryMechanism(proceedingJoinPoint);
        }
        return returnValue;
    }
}
