package ru.aston.hometask.task3.proxy;

import java.util.Scanner;

public class ProxyApp {
    private final static Scanner scanner = new Scanner(System.in);

    public static void execute() {
        ImageLoader real = new RealImageLoader();
        ImageLoader proxy = new ProxyImageLoader();

        System.out.println("Enter a name of the file you want to download:");
        String fileName = scanner.nextLine().trim();

        System.out.println("\nShowing image with real loader:");
        real.getImage(fileName).show();
        System.out.println("\nAnd again:");
        real.getImage(fileName).show();

        System.out.println("\nShowing image with proxy loader:");
        proxy.getImage(fileName).show();
        System.out.println("\nAnd again:");
        proxy.getImage(fileName).show();
    }
}
