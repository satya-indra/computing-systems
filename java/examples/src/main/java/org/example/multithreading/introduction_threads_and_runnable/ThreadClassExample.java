package org.example.multithreading.introduction_threads_and_runnable;

public class ThreadClassExample {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        Thread t1 = new Thread(new NumberPrinter(nums));
        t1.start();
    }
}

class NumberPrinter extends Thread {
    int[] nums;
    public NumberPrinter(int[] nums) {
        this.nums = nums;
    }
    public void run() {
        System.out.println("Name : " + Thread.currentThread().getName() + "Entering the run method");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Name : " + Thread.currentThread().getName() + " Num : " + i);
        }
    }
}


