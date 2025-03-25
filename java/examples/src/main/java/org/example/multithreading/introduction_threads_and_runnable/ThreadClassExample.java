package org.example.multithreading.introduction_threads_and_runnable;

public class ThreadClassExample implements Runnable  {
    int count;
    int max;

    public ThreadClassExample(int max) {
        this.count = 0;
        this.max = max;
    }

    public static void main(String[] args) {
        ThreadClassExample obj = new ThreadClassExample(10);
        Thread t1 = new Thread(obj::count, "Thread 1");
        t1.start();
        Thread t2 = new Thread(obj::count, "Thread 2");
        t2.start();
    }

    public synchronized void count() {
        while (count < max) {
            notify();
            System.out.println(Thread.currentThread().getName() + " count " + ++count); /// 0, thread 0
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notify();

    }


    @Override
    public void run() {

    }
}


