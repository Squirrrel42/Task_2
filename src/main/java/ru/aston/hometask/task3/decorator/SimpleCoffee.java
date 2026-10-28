package ru.aston.hometask.task3.decorator;

import java.math.BigDecimal;

public class SimpleCoffee implements Coffee{

    @Override
    public String getName() {
        return "Simple coffee";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal("200");
    }

    @Override
    public String toString() {
        return getName() + ", costs " + getCost() + " money.";
    }
}
