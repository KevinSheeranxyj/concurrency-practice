package com.takis.java.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunnableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> hello = CompletableFuture.runAsync(() -> System.out.println("Hello"));
        hello.get();
    }
}
