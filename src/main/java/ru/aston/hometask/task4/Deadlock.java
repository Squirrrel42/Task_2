package ru.aston.hometask.task4;

public class Deadlock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() ->{
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " got lock1");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " got lock2");
                }
            }

        });

        Thread thread2 = new Thread(() ->{
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " got lock2");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " got lock1");
                }
            }

        });

        thread1.start();
        thread2.start();
    }
}
