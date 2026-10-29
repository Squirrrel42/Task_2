package ru.aston.hometask.task4;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            try {
                while (true) {
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName() + " got lock1. Trying lock2...");

                    if (!lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
                        System.out.println(Thread.currentThread().getName() + " cannot acquire lock2. Releasing lock1...");
                        lock1.unlock();
                        continue;
                    }

                    System.out.println(Thread.currentThread().getName() + " acquired lock 2. Finishing work...");
                    lock1.unlock();
                    lock2.unlock();
                }

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                while (true) {
                    lock2.lock();
                    System.out.println(Thread.currentThread().getName() + " got lock2. Trying lock1...");

                    if (!lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                        System.out.println(Thread.currentThread().getName() + " cannot acquire lock1. Releasing lock2...");
                        lock2.unlock();
                        continue;
                    }

                    System.out.println(Thread.currentThread().getName() + " acquired lock 1. Finishing work...");
                    lock1.unlock();
                    lock2.unlock();
                }

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        thread1.start();
        thread2.start();
    }
}