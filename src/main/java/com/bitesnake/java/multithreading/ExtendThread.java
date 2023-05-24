package com.bitesnake.java.multithreading;

public class ExtendThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("I'm here");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("Starting the thread");
        t.start();
        System.out.println("Thread started");
        t.join();
        System.out.println("Finished");
    }
}
