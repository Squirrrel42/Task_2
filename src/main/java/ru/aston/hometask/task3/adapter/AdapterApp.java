package ru.aston.hometask.task3.adapter;

public class AdapterApp {

    public static void execute() {
        Castable magicMissile = new Spell("Magic missile", 10, 5);
        Castable fireball = new Spell("Fireball", 50, 30);
        Scroll rayOfFrost = new Scroll("Ray of frost", 20, 8);
        Scroll lightningBolt = new Scroll("Lightning bolt", 40, 25);
        Sorcerer gandalf = new Sorcerer("Gandalf", 10);

        System.out.println("Casting a Spell:\n");
        gandalf.castSpell(magicMissile);
        gandalf.castSpell(fireball);

        System.out.println("\nCasting a Scroll using ScrollAdapter:\n");
        Castable rayOfFrostAdapted = new ScrollAdapter(rayOfFrost);
        Castable lightningBoltAdapted = new ScrollAdapter(lightningBolt);
        gandalf.castSpell(rayOfFrostAdapted);
        gandalf.castSpell(lightningBoltAdapted);
    }
}
