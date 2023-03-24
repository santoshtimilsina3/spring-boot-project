package org.example.controller;

import org.example.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int add(int a, int b) {
        return calculatorService.add(a, b);
    }

}
