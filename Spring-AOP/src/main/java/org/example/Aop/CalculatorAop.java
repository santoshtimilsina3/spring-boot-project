package org.example.Aop;

import com.sun.org.slf4j.internal.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorAop {

    @Pointcut("execution(* org.example.Service.CalculatorService(..))")
    public void calculatorPointCut() {
    }

    @AfterReturning(pointcut = "add()", returning = "result")
    public void logAddMethod(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getArgs()[1]);
        System.out.println(result);
    }
}
