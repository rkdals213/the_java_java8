package com.example.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App3 {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        Callable<String> hello = () -> {
//            Thread.sleep(3000L);
//            return "Hello";
//        };
//
//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println("Started!");
//        System.out.println(helloFuture.isDone());
//
////        helloFuture.get();  // 블로킹
//        helloFuture.cancel(false);
//
//        System.out.println(helloFuture.isDone());
//        System.out.println("End!!");
//
//        executorService.shutdown();
//    }
//}

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> hello = () -> {
            Thread.sleep(3000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(2000L);
            return "Java";
        };

        Callable<String> kang = () -> {
            Thread.sleep(1000L);
            return "Kang";
        };

//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, kang)); // 등록된 Callable이 모두 끝날때까지 기다린다. -> 6초뒤 다음이 실행됨
//        for (Future<String> f : futures) {
//            System.out.println(f.get());
//        }

        String s = executorService.invokeAny(Arrays.asList(hello, java, kang));  // 제일 빨리 끝나는 친구를 리턴한다
        System.out.println(s);

        executorService.shutdown();
    }
}
