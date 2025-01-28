package org.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ProducerConsumerExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();


        Runnable producer = () -> {
            try {
                while (list.isEmpty()) {
                    Thread.sleep(1000);
                    list.add(1);
                    System.out.println("Thread " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable consumer = () -> {
            while (!list.isEmpty()) {
                list.removeLast();
                System.out.println("remove");
            }

        };

        Thread pt = new Thread(producer);
        Thread ct = new Thread(consumer);

        pt.start();
        ct.start();

    }


}

