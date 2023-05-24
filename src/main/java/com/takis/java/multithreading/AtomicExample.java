package com.takis.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    public static void main(String[] args) throws InterruptedException {
        AtomicExample.Counter counter = new AtomicExample.Counter();

        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 1; i < 1000; i++) {
            pool.submit(counter::incr);
        }

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("The result is " + counter.getCount());

    }


    static class Counter {
        private AtomicInteger count;
        public Counter() {
            this.count = new AtomicInteger(1);
        }

        public void incr() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }
}
