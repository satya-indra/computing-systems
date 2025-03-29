package org.example.multithreading.topic_1_introduction_threads_and_runnable;

import java.util.stream.IntStream;

public class RunnableExample {
    public static void main(String[] args) {
        int[] arr = IntStream.range(1,10).toArray();
        Thread t = new Thread(new RunnableNumberPrinter(arr));
        t.start();

        new Thread(() -> {
           System.out.println("Inside Runnable Lamba");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }).start();

    }
}

class RunnableNumberPrinter implements Runnable {
    int[] arr;
    public RunnableNumberPrinter(int[] arr) {
        this.arr = arr;
    }
    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
