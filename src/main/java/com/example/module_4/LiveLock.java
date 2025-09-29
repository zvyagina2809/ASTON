package com.example.module_4;

public class LiveLock {
    private static boolean thread1WantToWork = true;
    private static boolean thread2WantToWork = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (thread1WantToWork) {
                if (thread2WantToWork) {
                    System.out.println("Поток 1: Сначала работай ты, я подожду");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    continue;
                }

                System.out.println("Поток 1: Работаю!");
                thread1WantToWork = false;
            }
        });

        Thread thread2 = new Thread(() -> {
            while (thread2WantToWork) {
                if (thread1WantToWork) {
                    System.out.println("Поток 2: Нет, сначала ты, я подожду");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    continue;
                }

                System.out.println("Поток 2: Работаю!");
                thread2WantToWork = false;
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
    }
}
