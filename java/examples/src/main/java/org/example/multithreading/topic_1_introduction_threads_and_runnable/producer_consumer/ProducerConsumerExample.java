package org.example.multithreading.topic_1_introduction_threads_and_runnable.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        SharedStore store = new SharedStore(new LinkedList<>(), 10);
        Thread producer = new Thread(new Producer(store), "PRODUCER");
        producer.start();
        Thread consumer = new Thread(new Consumer(store), "CONSUMER");
        consumer.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("FINISHED INVOKED");
        store.setFinished();
        System.out.println("MAIN Queue Size Remaining " + store.size());

    }

}

class Producer implements Runnable {

    final SharedStore store;

    public Producer(SharedStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Inside Producer");
        int count  = 0;
        synchronized (this.store) {
            while(!this.store.isFinished()) {
                while (this.store.isFull()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Producer waiting. Store Full. Size " + this.store.size());
                        this.store.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + count + " Size " + this.store.size());
                store.addElement(count++);
                this.store.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable {

    final SharedStore store;

    public Consumer(SharedStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Inside Consumer");
        synchronized (this.store) {
            while(!this.store.isFinished() || !this.store.isEmpty()) {
                while (this.store.isEmpty()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Consumer waiting Store Full. Size " + this.store.size());
                        this.store.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(Thread.currentThread().getName() + " " + this.store.getElement() + " Size " + this.store.size());

                this.store.notifyAll();
            }
        }

    }
}

class SharedStore {
    private final Queue<Integer> queue;
    private final int limit;
    private volatile boolean isFinished;
    public SharedStore(Queue<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
        this.isFinished = false;
    }

    public Integer getElement() {
        return queue.poll();
    }

    public Boolean isEmpty() {
        return queue.isEmpty();
    }

    public void addElement(Integer element) {
        // use size to limit the queue
        queue.add(element);
    }

    public void setFinished() {
        this.isFinished = true;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public boolean isFull() {
        return  this.limit <= this.queue.size();
    }

    public int size() {
        return this.queue.size();
    }


}
