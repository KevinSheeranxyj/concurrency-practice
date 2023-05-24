package com.takis.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample.Counter counter = new SynchronizedExample.Counter();

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
        public Counter() {
            this.count = 1;
        }

         synchronized void incr() {
                count ++;
        }

        public int getCount() {
            return count;
        }
    }
}
