package ru.aston.hometask.task3.decorator;

import java.util.Scanner;

public class CoffeeMachine {
    private final static Scanner scanner = new Scanner(System.in);
    private static Coffee coffee = new SimpleCoffee();
    private static boolean ordering = true;

    public static void makeCoffee() {

        System.out.println("Making coffee...\nDo you want to add something?\n1) milk;\n2) sugar;\n3) syrup;\n4) latte art;\n0) done.");
        while (ordering) {
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Milk added. ");
                    coffee = new MilkDecorator(coffee);
                    break;
                case "2":
                    System.out.print("Sugar added. ");
                    coffee = new SugarDecorator(coffee);
                    break;
                case "3":
                    System.out.print("Syrup added. ");
                    coffee = new SyrupDecorator(coffee);
                    break;
                case "4":
                    System.out.print("Latte art added. ");
                    coffee = new LatteArtDecorator(coffee);
                    break;
                case "0":
                    ordering = false;
                    break;
                default: System.out.println("Wrong operation. Choose again.");
            }

            if (ordering) System.out.println("Do you want something else?");
        }

        System.out.println("Your coffee is ready!\n" + coffee);
    }
}
