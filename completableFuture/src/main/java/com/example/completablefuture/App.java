package com.example.completablefuture;

public class App {
    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
//            while (true) {
//                System.out.println("Hello : " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("exit!");
//                    return;
//                }
//            }
        });
        thread.start();

        System.out.println("Thread : " + Thread.currentThread().getName());
//        Thread.sleep(3000L);
//        thread.interrupt();
        thread.join();
        System.out.println(thread + " is finished");
    }

    static class MyThread extends Thread {
        public void run() {
            System.out.println("Hello : " + Thread.currentThread().getName());
        }
    }
}
