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
    public void beforeAdvice(JoinPoint joinPoint) throws Exception {
        for (Object arg : joinPoint.getArgs()) {
            if ((Integer) arg < 0) {
                throw new Exception("argument is below 0");
            }
        }
    }
}
