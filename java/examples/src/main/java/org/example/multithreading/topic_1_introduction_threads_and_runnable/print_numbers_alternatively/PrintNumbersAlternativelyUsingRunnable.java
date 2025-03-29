package org.example.multithreading.topic_1_introduction_threads_and_runnable.print_numbers_alternatively;

public class PrintNumbersAlternativelyUsingRunnable implements Runnable {
    int count = 0;
    int limit = 10;
    boolean even;
    final Object monitor;

    public PrintNumbersAlternativelyUsingRunnable(Object monitor, boolean even) {
        this.even = even;
        this.monitor = monitor;
    }


    public static void main(String[] args) {
        Object obj = new Object();
        Thread even = new Thread(new PrintNumbersAlternativelyUsingRunnable(obj, true), "EVEN");
        even.start();
        Thread odd = new Thread(new PrintNumbersAlternativelyUsingRunnable(obj, false), "ODD");
        odd.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " BEFORE LOOP " + count);
        while (count <= limit) {
            synchronized (monitor) {
                while ((count % 2 == 0) != this.even) { // Wait if it's not the thread's turn
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                if (count <= limit) {
                    System.out.println(Thread.currentThread().getName() + " " + count++);
                    monitor.notify(); // Wake up the other thread
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " AFTER LOOP " + count);
    }
}

