package ru.aston.hometask.task3.adapter;

public class Spell implements Castable {
    private final String name;
    private final int damage;
    private final int manaCost;

    public Spell(String name, int damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    @Override
    public void cast() {
        System.out.println("Casting " + name + " spell. Damage dealt: " + damage);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }
}
