package org.example;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    public String authenticatingPointCut() {
        if (true) {
            return "Give a pass";
        }
        return "Dont let him get in";
    }

    public void authorizationPointCut(){

    }
}
