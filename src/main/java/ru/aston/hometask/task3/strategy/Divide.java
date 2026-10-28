package ru.aston.hometask.task3.strategy;

public class Divide implements CalculatorStrategy {

    @Override
    public double execute(double a, double b) {
        if(b == 0) {
            throw new IllegalArgumentException("cannot divide by 0");
        }
        return a / b;
    }
}
