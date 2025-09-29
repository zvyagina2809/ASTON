package com.example.module_4;

public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " захватил lock1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " захватил lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " захватил lock2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " захватил lock1");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock example = new DeadLock();

        Thread thread1 = new Thread(() -> {
            while (true) {
                example.method1();
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            while (true) {
                example.method2();
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
