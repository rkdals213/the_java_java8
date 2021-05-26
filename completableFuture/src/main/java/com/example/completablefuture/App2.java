package com.example.completablefuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App2 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(() -> { // 프로세스가 시작되고 종료되지 않기때문에 명시적으로 종료해줘야함
//            System.out.println("Thread : " + Thread.currentThread().getName());
//        });
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("this"));
        executorService.submit(getRunnable("is"));
        executorService.submit(getRunnable("the"));
        executorService.submit(getRunnable("java"));
        executorService.submit(getRunnable("class"));

        executorService.shutdown();  // 명시적 종료

//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleAtFixedRate(getRunnable("hello"), 1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " : " + Thread.currentThread().getName());
    }
}
