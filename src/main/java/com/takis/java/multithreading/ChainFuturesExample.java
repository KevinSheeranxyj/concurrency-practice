package com.takis.java.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ChainFuturesExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApplyAsync(s -> s + " world");
        System.out.println(future.get());

    }
}
