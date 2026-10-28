package ru.aston.hometask.task3.adapter;

public class Sorcerer {
    private final String name;
    private final int mana;

    public Sorcerer(String name, int mana) {
        this.name = name;
        this.mana = mana;
    }
    public void castSpell(Castable spell) {
        if (spell.getManaCost() > mana) {
            System.out.println(name + " cannot cast the '" + spell.getName() + "' spell, not enough mana!");
            return;
        }
        System.out.print(name + " is casting a spell! ");
        spell.cast();
    }

    public String getName() {
        return name;
    }

    public int getMana() {
        return mana;
    }
}
