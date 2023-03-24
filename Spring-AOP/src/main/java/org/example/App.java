package org.example;

import org.example.Service.CalculatorService;
import org.example.controller.CalculatorController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        CalculatorService calculatorService = context.getBean(CalculatorService.class);
        int  ca = calculatorService.add(1,2);
    }
}
