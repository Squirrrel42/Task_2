package ru.aston.hometask.task3.decorator;

public class SimpleCoffee implements Coffee{

    @Override
    public String getName() {
        return "Simple coffee";
    }

    @Override
    public float getCost() {
        return 200;
    }

    @Override
    public String toString() {
        return getName() + ", costs " + getCost() + " money.";
    }
}
