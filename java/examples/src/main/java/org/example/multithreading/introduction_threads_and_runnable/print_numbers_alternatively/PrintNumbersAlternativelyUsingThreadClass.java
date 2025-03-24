package org.example.multithreading.introduction_threads_and_runnable.print_numbers_alternatively;

public class PrintNumbersAlternativelyUsingThreadClass {
    int count = 0;
    int limit = 10;

    public static void main(String[] args) {
        PrintNumbersAlternativelyUsingThreadClass printer = new PrintNumbersAlternativelyUsingThreadClass();

        Thread even = new Thread(printer::count, "Thread A");
        even.start();
        Thread odd = new Thread(printer::count, "Thread B");
        odd.start();
    }

    public synchronized void count() {
        while (count < limit) {
            notify();
            System.out.println(Thread.currentThread().getName() + " - " + count);
            count++;
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notify();

    }

}
