package org.example;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.example.ShoppingCart.checkout(..))")
    public void beforeLogger(){
        System.out.println("loggers");
    }

/* * for any return type *.*.*. for any package any class
two dots inside the checkout(..) method it will match any number of parameters
*/
@After("execution(* *.*.*.checkout(..))")
    public void afterLogger(JoinPoint joinPoint){

    System.out.println("After Loggers");
    System.out.println(joinPoint.getSignature());
    System.out.println(joinPoint.getTarget());
//    System.out.println(result);
    }
}
