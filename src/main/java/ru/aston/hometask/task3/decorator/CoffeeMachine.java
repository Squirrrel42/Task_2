package ru.aston.hometask.task3.decorator;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Operations, Function<Coffee, CoffeeDecorator>> decorators = Map.of(
            Operations.MILK, MilkDecorator::new,
            Operations.SUGAR, SugarDecorator::new,
            Operations.SYRUP, SyrupDecorator::new,
            Operations.LATTE_ART, LatteArtDecorator::new
    );

    private static Operations chooseDecorator() {
        String input = scanner.nextLine().trim();
        Operations[] values = Operations.values();
        while (true) {
            if (input.isEmpty()) {
                System.out.println("You must choose an operation");
            } else {
                try {
                    int choice = Integer.parseInt(input);
                    if (choice >= 0 && choice <= values.length) {
                        return values[choice];
                    }
                } catch (NumberFormatException ignored) {
                }
                System.out.println("Invalid choice. Try again.");
            }
        }
    }


    public static void makeCoffee() {
        Coffee coffee = new SimpleCoffee();

        System.out.println("Making coffee...\nDo you want to add something?\n1) milk;\n2) sugar;\n3) syrup;\n4) latte art;\n0) done.");
        while (true) {
            Operations operation = chooseDecorator();

            if (operation.equals(Operations.EXIT)) {
                break;
            }

            Function<Coffee, CoffeeDecorator> function = decorators.get(operation);

            coffee = function.apply(coffee);

            System.out.println("Do you want to add something else?\n1) milk;\n2) sugar;\n3) syrup;\n4) latte art;\n0) done.");
        }

        System.out.println("Your coffee is ready!\n" + coffee);
    }
}
