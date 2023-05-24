package com.takis.java.multithreading;

import java.util.concurrent.*;

/**
 * Executor Service
 */
public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 1; i < 1000; i++) {
            pool.submit(counter::incr);
        }

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("The result is " + counter.getCount());

    }


    static class Counter {
        private int count;
        private Semaphore semaphore;
        public Counter() {
            this.count = 1;
            this.semaphore = new Semaphore(1);
        }

        public void incr() {
            try {
                semaphore.acquire();
                count ++;
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public int getCount() {
            return count;
        }
    }
    //
}
