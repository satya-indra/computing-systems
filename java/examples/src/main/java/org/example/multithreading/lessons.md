# Java Concurrency Learning Schedule

We'll follow a **progressive approach**, starting with foundational concepts and gradually moving to more complex topics.

---

## **Week 1: Fundamentals of Concurrency**
- ✅ **Day 1:** Introduction to Threads & Runnable Interface
- ✅ **Day 2:** Thread Lifecycle & Thread States
- ✅ **Day 3:** Synchronization (Intrinsic Locks & `synchronized` keyword)
- ✅ **Day 4:** Thread Safety & Race Conditions
- ✅ **Day 5:** Volatile & Atomic Variables
- ✅ **Day 6:** Thread Communication (`wait()`, `notify()`, `notifyAll()`)
- ✅ **Day 7:** Mini Project: Build a Multi-threaded Counter

---

## **Week 2: Advanced Concurrency & Executors**
- ✅ **Day 8:** Thread Pools & `Executors` Framework
- ✅ **Day 9:** `Callable`, `Future`, and `CompletableFuture`
- ✅ **Day 10:** `Lock` Interface & `ReentrantLock`
- ✅ **Day 11:** Deadlocks & How to Avoid Them
- ✅ **Day 12:** `ForkJoinPool` & Parallel Streams
- ✅ **Day 13:** ThreadLocal & Concurrent Collections (`CopyOnWriteArrayList`, `ConcurrentHashMap`)
- ✅ **Day 14:** Mini Project: Multi-threaded Web Scraper

---

## **Week 3: Real-World Concurrency Patterns & Performance**
- ✅ **Day 15:** Producer-Consumer Pattern
- ✅ **Day 16:** Read-Write Locks & Optimistic Locking
- ✅ **Day 17:** Bounded Queues (`BlockingQueue` & `LinkedBlockingQueue`)
- ✅ **Day 18:** `CompletableFuture` Advanced Concepts
- ✅ **Day 19:** Concurrency Performance & Tuning
- ✅ **Day 20:** Parallel Algorithms & Best Practices
- ✅ **Day 21:** Final Project: High-Performance Logging System

---

## **Day 1: Introduction to Threads & Runnable**

### **Why do we need concurrency?**
👉 Modern applications demand speed and responsiveness. Running multiple tasks in parallel ensures efficient CPU utilization.

---

### **Creating Threads in Java**

Java provides **two** main ways to create a thread:
1️⃣ **Extending `Thread` class**  
2️⃣ **Implementing `Runnable` interface**

#### **Example 1: Extending `Thread` Class**
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();  // Starts the thread
    }
}
```

#### **Example 2: Implementing `Runnable` Interface**
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable is running: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();  // Starts the thread
    }
}
```
🔹 `Runnable` is preferred in **real-world applications** since it allows flexibility (e.g., using thread pools).

---

## **🛠️ Hands-on Exercise**

### **Problem 1:**
Create a **multi-threaded Java program** that prints numbers from 1 to 10 using two different threads. Each thread should print **only even** or **only odd** numbers.

### **🎯 Tasks**
1. Implement two threads (`EvenThread` & `OddThread`).
2. The `EvenThread` should print **even numbers** (2, 4, 6...).
3. The `OddThread` should print **odd numbers** (1, 3, 5...).
4. Both threads should run concurrently.

Try it out and share your solution! 🚀
