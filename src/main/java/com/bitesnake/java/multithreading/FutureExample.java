package com.bitesnake.java.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        future.complete("Hii");
        Thread.sleep(1000);
        System.out.println(future.get());
    }

    // Runnable Future

}
