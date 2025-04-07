package org.example.multithreading.topic_2_thread_lifecycle_and_states;

/**
 *    Write a program that creates a thread and prints its state before start, while running, and after termination.
 */
public class LifecycleThreadExample implements Runnable {
    public static void main(String[] args) {
        Thread th = new Thread(new LifecycleThreadExample());
        System.out.println("State Before Start : " + th.getState());
        th.start();
        System.out.println("State After Start : " + th.getState());
    }

    public void run() {
        System.out.println("Thread State while running: " + Thread.currentThread().getState());
        try {
            Thread.sleep(1000);
            System.out.println("Thread State after sleep: " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
