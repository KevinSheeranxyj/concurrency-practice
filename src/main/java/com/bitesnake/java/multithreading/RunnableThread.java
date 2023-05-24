package com.bitesnake.java.multithreading;

/**
 * Semaphore list
 */
public class RunnableThread {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
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
        };

        Thread t = new Thread(r);

        System.out.println("Starting the thread");
        t.start();
        System.out.println("Thread started");
        t.join();
        System.out.println("Finished");
    }

}
