package ru.aston.hometask.task3.strategy;

import java.util.Objects;

public class Calculator {
    private CalculatorStrategy calculatorStrategy;

    public Calculator(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = Objects.requireNonNull(calculatorStrategy);
    }

    public double calculate(double a, double b) {
        return calculatorStrategy.execute(a, b);
    }

    public void setStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = Objects.requireNonNull(calculatorStrategy);
    }
}
