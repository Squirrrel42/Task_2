package ru.aston.hometask.task3.decorator;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getName() {
        return super.getName() + " + milk";
    }

    @Override
    public float getCost() {
        return super.getCost() + 50;
    }
}
