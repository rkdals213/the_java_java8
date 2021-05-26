package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("kang");
        System.out.println(future.get());

        System.out.println("========================================================================");

        CompletableFuture<String> future1 = CompletableFuture.completedFuture("kang");
        System.out.println(future1.get());

        System.out.println("========================================================================");

        CompletableFuture<Void> voidFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        voidFuture.get();

        System.out.println("========================================================================");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future2.get());

        System.out.println("========================================================================");

        CompletableFuture<Void> voidFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        voidFuture1.get();

        System.out.println("========================================================================");

        CompletableFuture<Void> voidFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        voidFuture2.get();

        System.out.println("========================================================================");

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CompletableFuture<Void> voidFuture3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService);
        voidFuture3.get();

        executorService.shutdown();

    }
}
