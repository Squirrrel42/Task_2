package ru.aston.hometask.task3.strategy;

public class Divide implements Strategy{

    @Override
    public float execute(float a, float b) {
        if(b == 0) {
            throw new IllegalArgumentException("cannot divide by 0");
        }
        return a / b;
    }
}
