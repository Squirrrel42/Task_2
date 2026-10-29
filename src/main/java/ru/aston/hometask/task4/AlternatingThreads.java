package ru.aston.hometask.task4;

public class AlternatingThreads {

    private static final Object LOCK = new Object();
    private static int turn = 1;

    private static void printNumber(int number) {
        while (true) {
            synchronized (LOCK) {
                while (turn != number) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                System.out.println(number);

                if (number == 1) {
                    turn = 2;
                }
                else {
                    turn = 1;
                }

                LOCK.notify();
            }
        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> printNumber(1));
        Thread thread2 = new Thread(() -> printNumber(2));

        thread1.start();
        thread2.start();
    }
}