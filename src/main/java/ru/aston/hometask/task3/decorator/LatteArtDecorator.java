package ru.aston.hometask.task3.decorator;

import java.math.BigDecimal;

public class LatteArtDecorator extends CoffeeDecorator{
    public LatteArtDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getName() {
        return super.getName() + " + latte art";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("100"));
    }
}
