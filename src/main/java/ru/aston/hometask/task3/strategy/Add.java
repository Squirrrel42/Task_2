package ru.aston.hometask.task3.strategy;

public class Add implements Strategy{

    @Override
    public float execute(float a, float b) {
        return a + b;
    }
}
