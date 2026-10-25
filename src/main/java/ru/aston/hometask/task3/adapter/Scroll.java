package ru.aston.hometask.task3.adapter;

public class Scroll {
    private final String name;
    private final int damage;
    private final int manaCost;

    public Scroll(String name, int damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public void read() {
        System.out.println("Reading the '" + name + "' scroll. Damage dealt: " + damage);
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }
}

