package org.example.multithreading.topic_8_executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsFixedThreadPoolRunnableAnonymousClassExample {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            // producer main thread
            ex.submit(() -> {
                System.out.println("Hello from " + Thread.currentThread().getName());
            });
        }

        ex.shutdown();
    }
}
