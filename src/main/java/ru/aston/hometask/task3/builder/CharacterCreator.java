package ru.aston.hometask.task3.builder;

import java.util.Optional;
import java.util.Scanner;

public class CharacterCreator {
    private static final Scanner scanner = new Scanner(System.in);

    private static String getName() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Character must have a name.");
            } else {
                return input;
            }
        }
    }

    private static <T extends Enum<T>> T getEnum(Class<T> enumClass, String message) {
        while (true) {
            System.out.println("Choose " + message + " for your character from the list:");
            T[] values = enumClass.getEnumConstants();
            int i = 1;
            for (T value : values) {
                System.out.println(i++ + ") " + value);
            }
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Character's " + message + " must be specified.");
            } else {
                try {
                    int choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= values.length) {
                        return values[choice - 1];
                    }
                } catch (NumberFormatException ignored) {
                }

                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static Optional<String> getNickname() {
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(input);
        }
    }

    private static <T extends Enum<T>> Optional<T> getOptionalEnum(Class<T> enumClass, String message) {
        while (true) {
            System.out.println("Choose " + message + " for your character from the list (press ENTER to skip):");
            T[] values = enumClass.getEnumConstants();
            int i = 1;
            for (T value : values) {
                System.out.println(i++ + ") " + value);
            }
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return Optional.empty();
            } else {
                try {
                    int choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= values.length) {
                        return Optional.of(values[choice - 1]);
                    }
                } catch (NumberFormatException ignored) {
                }

                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static RPGCharacter makeCharacter() {
                System.out.println("Character creation started. \n Name your character:");
        String name = getName();
        Sex sex = getEnum(Sex.class, "sex");
        Species species = getEnum(Species.class, "species");
        CharacterClass characterClass = getEnum(CharacterClass.class, "class");

        CharacterBuilder builder = new CharacterBuilder()
                .setName(name)
                .setSex(sex)
                .setSpecies(species)
                .setCharacterClass(characterClass);

        System.out.println("Give a nickname to your character (press ENTER to skip):");
        getNickname().ifPresent(builder::setNickname);
        getOptionalEnum(Feat.class, "feat").ifPresent(builder::setFeat);
        getOptionalEnum(DistinguishingFeature.class, "distinguishing feature").ifPresent(builder::setFeature);
        getOptionalEnum(HairColor.class, "hair color").ifPresent(builder::setHairColor);
        getOptionalEnum(EyeColor.class, "eye color").ifPresent(builder::setEyeColor);

        RPGCharacter rpgCharacter = builder.build();

        System.out.println("Your character is ready! Look at "
                + (rpgCharacter.getSex() == Sex.MALE ? "him" : "her")
                + ":\n"
                + rpgCharacter);


        return rpgCharacter;
    }
}
