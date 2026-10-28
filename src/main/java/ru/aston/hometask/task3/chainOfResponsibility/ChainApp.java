package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;
import java.util.Scanner;

public class ChainApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Map<String, String> clients = Map.of(
            "dostoyevski.fm@mail.ru", "pravo_imeyu",
            "kamu.alber@orange.fr", "cest_la_vie",
            "ivanov.ivan@yandex.ru", "password123"
    );

    public static void execute() {
        AuthenticationState authenticationState = new AuthenticationState(false);
        EmailFormat emailFormat = new EmailFormat(clients, authenticationState);
        EmailFinder emailFinder = new EmailFinder(clients, authenticationState);
        PasswordFinder passwordFinder = new PasswordFinder(clients, authenticationState);

        emailFormat.setNext(emailFinder);
        emailFinder.setNext(passwordFinder);

        while (!authenticationState.state) {
            System.out.println("Enter your email:");
            String email = scanner.nextLine().trim();
            System.out.println("Enter your password:");
            String password = scanner.nextLine().trim();

            emailFormat.handle(email, password);
        }
    }
}
