package ru.aston.hometask.task3.decorator;

import java.math.BigDecimal;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getName() {
        return super.getName() + " + milk";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("50"));
    }
}
