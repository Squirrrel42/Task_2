package ru.aston.hometask.task3.decorator;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getName() {
        return super.getName() + " + sugar";
    }

    @Override
    public float getCost() {
        return super.getCost() + 30;
    }
}
