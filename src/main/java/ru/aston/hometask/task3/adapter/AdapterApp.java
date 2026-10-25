package ru.aston.hometask.task3.adapter;

public class AdapterApp {
    private final static Castable magicMissile = new Spell("Magic missile", 10, 5);
    private final static Castable fireball = new Spell("Fireball", 50, 30);
    private final static Scroll rayOfFrost = new Scroll("Ray of frost", 20, 8);
    private final static Scroll lightningBolt = new Scroll("Lightning bolt", 40, 25);
    private final static Sorcerer gandalf = new Sorcerer("Gandalf", 10);

    public static void execute() {
        System.out.println("Casting a Spell:\n");
        gandalf.castSpell(magicMissile);
        gandalf.castSpell(fireball);

        // gandalf.castSpell(rayOfFrost); // does not compile
        // gandalf.castSpell(lightningBolt); // does not compile

        System.out.println("\nCasting a Scroll using ScrollAdapter:\n");
        Castable rayOfFrostAdapted = new ScrollAdapter(rayOfFrost);
        Castable lightningBoltAdapted = new ScrollAdapter(lightningBolt);
        gandalf.castSpell(rayOfFrostAdapted);
        gandalf.castSpell(lightningBoltAdapted);
    }
}
