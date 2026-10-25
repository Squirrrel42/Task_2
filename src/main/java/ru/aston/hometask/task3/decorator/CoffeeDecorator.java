package ru.aston.hometask.task3.decorator;

public class CoffeeDecorator implements Coffee{
    private final Coffee wrapped;

    public CoffeeDecorator(Coffee wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getName() {
        return wrapped.getName();
    }

    @Override
    public float getCost() {
        return wrapped.getCost();
    }

    @Override
    public String toString() {
        return getName() + ", costs " + getCost() + " money.";
    }
}
