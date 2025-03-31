package org.example.multithreading.topic_8_executor_framework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsFixedThreadPoolCallableFutureExample {
    public static void main(String[] args) {
        // Creates a Thread Pool of 3 threads.
        // It uses a shared queue for task submission. LinkedBlockingQueue.
        // When LinkedBlockingQueue becomes full, the task submitter stops submitting the task.
        // When it becomes empty, then task consumer ( i.e worker threads) stops consuming the task.
        // Executors.newFixedThreadPool(3) creates queue of unbounded size. It can grow infinetly and can put pressure on system resources.
        // The worker threads will pickup the task from the queue. The remaining task becomes waiting tasks.
        ExecutorService ex = Executors.newFixedThreadPool(3);

        Future[] futures = new Future[5];

        for (int i = 0; i < 5; i++) {
            Future<String> ans = ex.submit(() -> {
                return "Hello from " + Thread.currentThread().getName();
            });
            futures[i] = ans;
        }

        for (int i = 0; i < futures.length; i++) {
            try {
                String ans = (String) futures[i].get();
                System.out.println(ans);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


        ex.shutdown();
    }
}
