package ru.aston.hometask.task3.decorator;

public class LatteArtDecorator extends CoffeeDecorator{
    public LatteArtDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getName() {
        return super.getName() + " + latte art";
    }

    @Override
    public float getCost() {
        return super.getCost() + 100;
    }
}
