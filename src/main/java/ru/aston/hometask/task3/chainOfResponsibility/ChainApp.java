package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;
import java.util.Scanner;

public class ChainApp {

    private static final Map<String, String> clients = Map.of(
            "dostoyevski.fm@mail.ru", "pravo_imeyu",
            "kamu.alber@orange.fr", "cest_la_vie",
            "ivanov.ivan@yandex.ru", "password123"
    );

    public static void execute() {
        AuthenticationState state = new AuthenticationState();
        EmailFormat emailFormat = new EmailFormat(clients, state);
        EmailFinder emailFinder = new EmailFinder(clients, state);
        PasswordFinder passwordFinder = new PasswordFinder(clients, state);

        emailFormat.setNext(emailFinder);
        emailFinder.setNext(passwordFinder);

        Scanner scanner = new Scanner(System.in);
        while (!state.state) {
            System.out.println("Enter your email:");
            String request = scanner.nextLine().trim();

            emailFormat.handle(request);
        }
    }
}
