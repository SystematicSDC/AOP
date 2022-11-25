package com.systematic.aop.workshop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class ValidatorService {
    @Pointcut("execution(* com.systematic.aop.workshop.services.MathService.addPositives(..))")
    public void addPositives() {
    }

    @Before("addPositives()")
    public void beforeAddPositives(JoinPoint jp) throws Exception {
        for (Object arg : jp.getArgs()) {
            if ((Integer) arg < 0) {
                throw new Exception("argument is below 0");
            }
        }
    }
}
