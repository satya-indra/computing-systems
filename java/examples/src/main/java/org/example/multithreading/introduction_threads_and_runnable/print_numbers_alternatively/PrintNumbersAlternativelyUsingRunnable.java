package org.example.multithreading.introduction_threads_and_runnable.print_numbers_alternatively;

public class PrintNumbersAlternativelyUsingRunnable implements Runnable {
    int count = 0;
    int limit = 10;


    public static void main(String[] args) {
        PrintNumbersAlternativelyUsingRunnable printer = new PrintNumbersAlternativelyUsingRunnable();
        Thread even = new Thread(printer, "EVEN");
        even.start();
        Thread odd = new Thread(printer, "ODD");
        odd.start();
    }

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " BEFORE LOOP " + count);
        while (count < limit) {
            notify();
            System.out.println(Thread.currentThread().getName() + " " + ++count);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " AFTER LOOP " + count);
        notify();
    }
}

