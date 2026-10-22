package ru.aston.hometask.task3.strategy;

public class Multiply implements Strategy{
    @Override
    public float execute(float a, float b) {
        return a * b;
    }
}
