package com.example.module_4;

public class AlternatingThreads {
    private static final Object lock = new Object();
    private static boolean isOnesTurn = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!isOnesTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("1");
                    isOnesTurn = false;
                    lock.notifyAll();
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (isOnesTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println("2");
                    isOnesTurn = true;
                    lock.notifyAll();
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
