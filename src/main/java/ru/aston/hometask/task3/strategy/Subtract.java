package ru.aston.hometask.task3.strategy;

public class Subtract implements CalculatorStrategy {

    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}
