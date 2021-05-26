package com.example.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future = hello.thenCompose(App5::getWorld);
        System.out.println(future.get());

        System.out.println("========================================================================");

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> future1 = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future1.get());

        System.out.println("========================================================================");

        CompletableFuture<Void> voidFuture = CompletableFuture.allOf(hello, world) // hello와 world의 리턴 타입이 동일하단 보장도 없고 에러가 있을수도 있음
                .thenAccept(System.out::println);
        System.out.println(voidFuture.get());

        System.out.println("========================================================================");

        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        results.get().forEach(System.out::println);

        System.out.println("========================================================================");

        boolean throwError = true;

        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            if (throwError) {
                throw new IllegalStateException();
            }
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });
        System.out.println(hello1.get());

        System.out.println("========================================================================");

        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            if (throwError) {
                throw new IllegalStateException();
            }
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "Error!";
            }
            return result;
        });
        System.out.println(hello2.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }

}
