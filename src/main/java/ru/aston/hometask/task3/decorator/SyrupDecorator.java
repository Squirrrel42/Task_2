package ru.aston.hometask.task3.decorator;

import java.math.BigDecimal;

public class SyrupDecorator extends CoffeeDecorator{
    public SyrupDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getName() {
        return super.getName() + " + syrup";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("70"));
    }
}
