package ru.aston.hometask.task3.strategy;

import java.util.Map;
import java.util.Scanner;

public class StrategyApp {
    private static final Map<String, Strategy> operations = Map.of(
            "1", new Add(),
            "2", new Substract(),
            "3", new Multiply(),
            "4", new Divide());

    private static float readFloat(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("This is not a number. Enter a number.");
            }
        }
    }

    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Chose an operation from the list: \n 1) +; \n 2) -; \n 3) *; \n 4) /; \n 0) Exit.");
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) {
                System.out.println("Program ended.");
                break;
            }

            Strategy strategy = operations.get(choice);
            if (strategy == null) {
                System.out.println("Wrong operation.");
                continue;
            }
            calculator.setStrategy(strategy);

            System.out.println("Enter first number:");
            float a = readFloat(scanner);
            System.out.println("Enter second number:");
            float b = readFloat(scanner);

            try {
                System.out.println("Calculated result: " + calculator.calculate(a, b));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
