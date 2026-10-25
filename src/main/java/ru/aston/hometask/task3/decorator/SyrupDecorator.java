package ru.aston.hometask.task3.decorator;

public class SyrupDecorator extends CoffeeDecorator{
    public SyrupDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getName() {
        return super.getName() + " + syrup";
    }

    @Override
    public float getCost() {
        return super.getCost() + 70;
    }
}
