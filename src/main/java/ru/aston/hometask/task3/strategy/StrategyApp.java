package ru.aston.hometask.task3.strategy;

import java.util.Map;
import java.util.Scanner;

public class StrategyApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Operations, CalculatorStrategy> strategies = Map.of(
            Operations.ADD, new Add(),
            Operations.SUBTRACT, new Subtract(),
            Operations.MULTIPLY, new Multiply(),
            Operations.DIVIDE, new Divide());

    private static double readDouble() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("This is not a number. Enter a number.");
            }
        }
    }

    private static Operations getOperation() {
        while(true) {
            String input = scanner.nextLine().trim();
            Operations[] values = Operations.values();

            if (input.isEmpty()) {
                System.out.println("You must choose an operation");
            }
            else {
                try {
                    int choice = Integer.parseInt(input);
                    if (choice >= 0 && choice <= values.length) {
                        return values[choice];
                    }
                } catch (NumberFormatException ignored) {}
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void execute() {
        while (true) {
            System.out.println("Chose an operation from the list: \n 1) +; \n 2) -; \n 3) *; \n 4) /; \n 0) Exit.");

            Operations operation = getOperation();

            if (operation.equals(Operations.EXIT)) {
                System.out.println("Closing calculator.");
                break;
            }

            CalculatorStrategy calculatorStrategy = strategies.get(operation);

            Calculator calculator = new Calculator(calculatorStrategy);

            System.out.println("Enter first number:");
            double a = readDouble();
            System.out.println("Enter second number:");
            double b = readDouble();

            try {
                System.out.println("Calculated result: " + calculator.calculate(a, b));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
