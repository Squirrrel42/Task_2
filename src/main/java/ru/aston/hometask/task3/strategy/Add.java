package ru.aston.hometask.task3.strategy;

public class Add implements CalculatorStrategy {

    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}
