package com.systematic.aop.workshop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class PerformanceService {
    @Pointcut("execution(* com.systematic.aop.workshop.services.MathService.sort(..))")
    public void logSortingTime() {
    }

    @Around("logSortingTime()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.nanoTime();
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Object arg = proceedingJoinPoint.getArgs()[1];
        System.out.printf("ASPECT PerformanceService: %s took %d nanoseconds.%n",
                arg.getClass().getSimpleName(),
                System.nanoTime() - start);
        return value;
    }
}
