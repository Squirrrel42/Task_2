package ru.aston.hometask.task3.decorator;

import java.math.BigDecimal;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getName() {
        return super.getName() + " + sugar";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("30"));
    }
}
