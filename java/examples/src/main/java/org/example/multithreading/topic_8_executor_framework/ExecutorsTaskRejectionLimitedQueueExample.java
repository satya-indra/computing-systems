package org.example.multithreading.topic_8_executor_framework;

import java.util.concurrent.*;

public class ExecutorsTaskRejectionLimitedQueueExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                0L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                (r, executor1) -> System.out.println("Task rejected: " + r.toString()));

        for (int i = 0; i < 20; i++) {
            try {
                executor.execute(() -> {
                    System.out.println("Task " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000); // Simulate task workload
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } catch (RejectedExecutionException e) {
                System.out.println("Task " + i + " was rejected!");
            }

        }

        // If we dont shutdown, then the worker threads in the pool keep waiting for new tasks.
        // The JVM won't exit until all non-daemon threads have completed.
        // It keeps on waiting for new task to be submitted.
        executor.shutdown();

    }
}
