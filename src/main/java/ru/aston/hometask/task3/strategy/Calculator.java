package ru.aston.hometask.task3.strategy;

public class Calculator {
    private Strategy strategy;

    public Calculator() {}

    public Calculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public float calculate(float a, float b) {
        return strategy.execute(a, b);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
