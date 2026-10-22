package ru.aston.hometask.task3.chainOfResponsibility;

import java.util.Map;
import java.util.Scanner;

public class PasswordFinder extends BaseHandler{

    public PasswordFinder(Map<String, String> clients, AuthenticationState state) {
        super(clients, state);
    }

    @Override
    public void handle(String request) {
        System.out.println("Enter your password:");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine().trim();

        if(clients.get(request).equals(password)) {
            System.out.println("Welcome!");
            state.state = true;
        }
        else {
            System.out.println("Wrong password.");
        }

    }
}
