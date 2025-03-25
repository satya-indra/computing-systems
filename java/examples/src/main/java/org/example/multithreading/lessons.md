Below is a comprehensive list of additional problems for each topic in your Java Concurrency learning schedule. For every day (topic), you’ll find **10 practice problems** divided into 3 difficulty levels: **4 Easy, 4 Medium, and 2 Hard**. Work through these problems to reinforce your understanding step by step.

---

# Java Concurrency Learning Schedule – Additional Problems

> **Note:** Each “day” corresponds to a major sub-topic in your schedule. The problems are written in Markdown and are grouped by difficulty.

---

## **Week 1: Fundamentals of Concurrency**

### **Day 1: Introduction to Threads & Runnable Interface**

#### Easy
1. **Basic Thread Creation:**  
   Write a program that creates a thread by extending the `Thread` class. In the `run()` method, simply print the thread’s name.
2. **Runnable Implementation:**  
   Implement a `Runnable` that prints “Hello from Runnable!” and run it in a new thread.
3. **Sleep and Print:**  
   Create a thread that sleeps for 2 seconds, then prints “Awake!”.
4. **Method Call Test:**  
   Write a program that mistakenly calls `run()` directly (instead of `start()`) and document the output.

#### Medium
5. **Odd vs. Even Threads:**  
   Create two threads (using Runnable): one prints odd numbers and the other prints even numbers from 1 to 20.
6. **Multiple Thread IDs:**  
   Launch 5 threads concurrently, each printing its own thread ID and a unique message.
7. **Anonymous Runnable:**  
   Use an anonymous class (or lambda) to implement a Runnable that performs a countdown from 10 to 1.
8. **Thread Logging:**  
   Enhance one of the above programs by logging the start time and end time for each thread.

#### Hard
9. **Compare run() vs. start():**  
   Design an experiment to measure the time difference and output behavior when calling `run()` directly versus using `start()`.
10. **Custom Join Mechanism:**  
    Develop a multi-threaded application that launches 10 threads to print their names and then implement your own join mechanism (without using `Thread.join()`) to wait for all threads to finish.

---

### **Day 2: Thread Lifecycle & Thread States**

#### Easy
1. **State Logger:**  
   Write a program that creates a thread and prints its state before start, while running, and after termination.
2. **Sleep State Observation:**  
   Create a thread that sleeps for 1 second, logging its state before sleep, during sleep, and after waking.
3. **Interrupt and State:**  
   Start a thread, interrupt it while sleeping, and print its state immediately after interruption.
4. **State in run():**  
   From within the `run()` method, print the thread’s current state using `Thread.currentThread().getState()`.

#### Medium
5. **Join and Monitor:**  
   Create two threads where one waits for the other using `join()`. Log the states of both threads during the process.
6. **Multiple Threads Monitor:**  
   Launch multiple threads and periodically check and print their states until all threads are terminated.
7. **Yield Demonstration:**  
   Create a thread that repeatedly calls `Thread.yield()` and logs its state during each iteration.
8. **Waiting vs. Timed Waiting:**  
   Write a program that demonstrates the difference between WAITING (using `wait()`) and TIMED_WAITING (using `sleep()` with a timeout).

#### Hard
9. **Lock Contention Scenario:**  
   Design a program where one thread holds a lock for an extended period, forcing other threads to remain in the BLOCKED state. Log the durations.
10. **Custom Thread Monitor:**  
    Create a diagnostic tool that monitors a group of threads and outputs detailed logs if any thread stays in the BLOCKED state for longer than a given threshold.

---

### **Day 3: Synchronization (Intrinsic Locks & `synchronized` keyword)**

#### Easy
1. **Synchronized Method Counter:**  
   Write a program that uses a synchronized method to increment a shared counter and prints the final value.
2. **Synchronized Block:**  
   Rewrite the above program to use a synchronized block on a common lock object.
3. **Mutual Exclusion:**  
   Demonstrate that two threads calling the same synchronized method do not execute concurrently by printing timestamps.
4. **Lock Object Test:**  
   Create a program that uses a specific object as a lock in a synchronized block to protect a critical section.

#### Medium
5. **Race Condition Fix:**  
   Write a program that causes a race condition (unsynchronized counter) and then fix it with proper synchronization.
6. **Nested Synchronization:**  
   Develop a program with nested synchronized blocks and explain through comments potential pitfalls.
7. **Multiple Locks:**  
   Create a program that uses two different lock objects in separate synchronized blocks and observe the behavior.
8. **Minimize Lock Scope:**  
   Modify a concurrent program to reduce the scope of synchronized blocks to minimize contention, then explain your changes.

#### Hard
9. **Deadlock Simulation & Prevention:**  
   Design an application with multiple threads that initially causes a deadlock using synchronized blocks, then refactor it to enforce a strict lock ordering to prevent deadlock.
10. **Bank Transfer System:**  
    Implement a bank account transfer system where multiple threads perform transfers. Ensure thread safety by synchronizing on accounts in a consistent order to prevent deadlocks and race conditions.

---

### **Day 4: Thread Safety & Race Conditions**

#### Easy
1. **Unsynchronized Counter:**  
   Write a program where multiple threads increment a shared variable without synchronization and observe inconsistent results.
2. **Fix Race Condition:**  
   Modify the above program to use synchronized methods/blocks to correct the race condition.
3. **Volatile Flag:**  
   Create a program that uses a volatile boolean flag for thread termination and demonstrate its proper visibility across threads.
4. **Commentary on Race:**  
   Provide a detailed explanation (as comments) in a small code sample that demonstrates a race condition.

#### Medium
5. **Concurrent Updates:**  
   Develop a program that simulates multiple threads updating a shared resource (like a list) and identify potential race conditions.
6. **Atomic vs. Synchronized:**  
   Write two versions of a shared counter—one using atomic classes (e.g., `AtomicInteger`) and one using synchronized blocks—then compare their behavior.
7. **Data Structure Update:**  
   Create a program where two threads concurrently modify a shared data structure, then fix it using proper locking.
8. **Memory Consistency Test:**  
   Implement a scenario where memory consistency errors occur due to improper synchronization and then resolve them.

#### Hard
9. **High-Load Race Simulation:**  
   Design a simulation under heavy load that exposes a subtle race condition. Collect performance metrics to show the impact.
10. **Combined Concurrency Issues:**  
    Develop a complex application that deliberately combines both race conditions and visibility problems, then solve them using a mix of synchronization, volatile, and atomic variables. Provide a detailed explanation of your approach.

---

### **Day 5: Volatile & Atomic Variables**

#### Easy
1. **Volatile Stop Signal:**  
   Write a program that uses a volatile boolean to signal a thread to stop its execution.
2. **Atomic Counter:**  
   Create a simple counter using `AtomicInteger` that multiple threads increment concurrently.
3. **Compare Volatile:**  
   Develop a program that demonstrates the difference between a volatile variable and a non-volatile variable in a multi-threaded scenario.
4. **Flag Update and Read:**  
   Write a program where one thread updates a volatile flag and another thread continuously reads it, ensuring proper termination.

#### Medium
5. **Atomic vs. Synchronized Counter:**  
   Rewrite a shared counter problem using atomic variables instead of synchronized blocks and compare the performance.
6. **AtomicBoolean Signal:**  
   Develop a program that uses `AtomicBoolean` to control the execution flow of multiple threads.
7. **Compound Atomic Operations:**  
   Implement a counter that supports both increment and decrement operations atomically using `AtomicInteger`.
8. **Compound Update Scenario:**  
   Create a scenario where multiple threads perform compound (read-modify-write) operations on a shared variable and solve it using atomic classes.

#### Hard
9. **Lock-Free Data Structure:**  
   Design and implement a non-blocking algorithm using compare-and-swap (CAS) for updating a shared data structure.
10. **Lock-Free Linked List:**  
    Develop a lock-free linked list using atomic references. Compare its throughput and correctness with a version using explicit synchronization.

---

### **Day 6: Thread Communication (`wait()`, `notify()`, `notifyAll()`)**

#### Easy
1. **Basic Wait/Notify:**  
   Write a program with two threads where one thread waits (using `wait()`) for a signal from another thread (using `notify()`).
2. **Producer-Consumer (Simple):**  
   Implement a simple producer-consumer example using a shared buffer with `wait()` and `notify()`.
3. **Condition Wait:**  
   Create a program where a thread waits for a specific condition (e.g., a counter reaches a threshold) and then resumes.
4. **NotifyAll Example:**  
   Write a program that demonstrates the use of `notifyAll()` to wake up all waiting threads.

#### Medium
5. **Multi-Producer/Consumer:**  
   Develop a program with multiple producer threads and one consumer thread that coordinate via wait/notify.
6. **Spurious Wakeups:**  
   Create an example that handles spurious wakeups correctly by checking the waiting condition in a loop.
7. **Multiple Conditions:**  
   Implement a scenario where threads wait on different conditions and are selectively notified.
8. **Traffic Light Simulation:**  
   Write a simulation of a traffic light system using wait/notify for coordinating state changes.

#### Hard
9. **Multi-Stage Pipeline:**  
   Design a multi-threaded application that uses wait/notify to coordinate a multi-stage processing pipeline (each stage is a thread), ensuring correct sequencing and data handoff.
10. **Dynamic Thread Coordination:**  
    Build a variant of the producer-consumer problem where threads are dynamically added and removed. Ensure that all waiting threads are correctly notified during a graceful shutdown, and explain your synchronization strategy.

---

### **Day 7: Mini Project: Build a Multi-threaded Counter**

#### Easy
1. **Basic Synchronized Counter:**  
   Build a multi-threaded counter using synchronized methods and verify that the final count is correct.
2. **Atomic Counter Implementation:**  
   Create a version of the counter using `AtomicInteger` and compare outputs.
3. **Multiple Thread Updates:**  
   Write a program that spawns multiple threads incrementing a shared counter and prints the final result.
4. **GUI Counter Display:**  
   Develop a basic GUI that displays the counter value in real time as multiple threads update it.

#### Medium
5. **Bidirectional Counter:**  
   Create a counter that supports both increment and decrement operations safely.
6. **Logging Counter Activity:**  
   Enhance the counter to log each increment/decrement operation along with timestamps.
7. **Threshold-Based Reset:**  
   Implement a counter that resets to zero when a certain threshold is reached, ensuring thread safety.
8. **Distributed Sub-Counters:**  
   Design a system where each thread maintains its own sub-counter and a master thread aggregates the totals periodically.

#### Hard
9. **Striped Counter:**  
   Design a high-performance counter that minimizes contention by using striped counters (partitioning the counter across multiple atomic variables) and compare its performance with a simple AtomicInteger counter.
10. **Dynamic Counter Framework:**  
    Build an extendable multi-threaded counter framework that allows dynamic addition and removal of counter threads, and create a test harness to simulate heavy concurrent updates with performance metrics.

---

## **Week 2: Advanced Concurrency & Executors**

### **Day 8: Thread Pools & `Executors` Framework**

#### Easy
1. **Fixed Thread Pool:**  
   Write a program that creates a fixed thread pool with 3 threads and submits tasks that print a simple message.
2. **Single Thread Executor:**  
   Create a program using `Executors.newSingleThreadExecutor()` to execute tasks sequentially.
3. **execute() vs. submit():**  
   Demonstrate the difference between using `execute()` and `submit()` in a thread pool by printing return values and exceptions.
4. **Sleep in Task:**  
   Implement a simple task that sleeps for 500ms and then prints the thread name.

#### Medium
5. **Task Order Logging:**  
   Submit 20 tasks to a fixed thread pool and log the order in which they are executed.
6. **Task Rejection:**  
   Create a thread pool with a limited queue size to demonstrate task rejection and handle the `RejectedExecutionException`.
7. **Executor Replacement:**  
   Refactor a small multi-threaded program that uses manual thread creation to use an ExecutorService instead.
8. **Thread Pool Monitor:**  
   Write a program that periodically prints the status of a thread pool (e.g., active count, queued tasks).

#### Hard
9. **Custom ThreadFactory:**  
   Design an application that uses a custom ThreadFactory with a thread pool to assign custom names and priorities to threads.
10. **Dynamic Scaling Executor:**  
    Implement an executor that dynamically adjusts its pool size based on the workload. Test its performance under varying loads and document your findings.

---

### **Day 9: `Callable`, `Future`, and `CompletableFuture`**

#### Easy
1. **Simple Callable:**  
   Write a program that uses a `Callable` to return a fixed string.
2. **Future Retrieval:**  
   Submit a Callable to an ExecutorService and retrieve the result using `Future.get()`.
3. **Factorial Calculation:**  
   Implement a Callable that calculates the factorial of a number and prints the result.
4. **Timeout Example:**  
   Write a program that calls `Future.get(timeout)` and handles a timeout scenario.

#### Medium
5. **Aggregate Callables:**  
   Create multiple Callable tasks, submit them to a thread pool, and aggregate their results.
6. **CompletableFuture SupplyAsync:**  
   Use `CompletableFuture.supplyAsync()` to perform an asynchronous task and print its result.
7. **Chained CompletableFuture:**  
   Build a chain of CompletableFuture tasks using `thenApply()` and `thenAccept()` to process a value.
8. **Exception Handling:**  
   Implement exception handling in a CompletableFuture chain using `exceptionally()` or `handle()`.

#### Hard
9. **Complex Asynchronous Pipeline:**  
   Design a task that combines multiple asynchronous operations using `thenCompose()` and `thenCombine()` to produce an aggregated result with error recovery.
10. **Multi-Step Process Simulation:**  
    Simulate a multi-step process (e.g., data aggregation from several services) using CompletableFuture. Merge the results into a final report with detailed logging and performance metrics.

---

### **Day 10: `Lock` Interface & `ReentrantLock`**

#### Easy
1. **Basic ReentrantLock:**  
   Write a program that uses a `ReentrantLock` to protect a critical section incrementing a counter.
2. **Try-Finally Usage:**  
   Implement a simple program that demonstrates correct lock acquisition and release using a try/finally block.
3. **tryLock() Demo:**  
   Create a program that uses `tryLock()` to attempt to acquire a lock and prints whether it was successful.
4. **Lock Logging:**  
   Write a program that logs entry and exit times of a block protected by a ReentrantLock.

#### Medium
5. **Replace Synchronized Block:**  
   Modify a previously written synchronized counter program to use ReentrantLock and compare performance.
6. **Lock Interruptibly:**  
   Develop a program that uses `lockInterruptibly()` and demonstrates interrupting a thread waiting for a lock.
7. **Timeout Locking:**  
   Implement a scenario where multiple threads try to acquire a lock with a timeout using `tryLock(timeout)`.
8. **Resource Reservation:**  
   Simulate a real-world scenario (e.g., booking system) using ReentrantLock to coordinate resource access among threads.

#### Hard
9. **Multiple Lock Management:**  
   Design a system that uses several ReentrantLocks to protect different parts of a data structure while avoiding deadlock.
10. **Fair vs. Non-Fair Locks:**  
    Implement a simulation where tasks use a combination of fair and non-fair ReentrantLocks. Analyze and report on the performance differences under high contention.

---

### **Day 11: Deadlocks & How to Avoid Them**

#### Easy
1. **Intentional Deadlock:**  
   Write a program that intentionally causes a deadlock with two threads and two locks.
2. **Deadlock Warning:**  
   Modify the above program to detect a potential deadlock (e.g., using timeouts) and print a warning.
3. **Single Lock Usage:**  
   Create a program that uses a single lock to perform nested operations safely.
4. **Consistent Lock Ordering:**  
   Write a program that simulates resource allocation using a fixed lock ordering to avoid deadlock.

#### Medium
5. **Multiple Resources:**  
   Develop a program where several threads access two shared resources in a fixed order to prevent deadlock.
6. **Timeout with tryLock():**  
   Create a program that uses `tryLock(timeout)` to avoid deadlock by giving up if the lock cannot be acquired in time.
7. **Global Lock Ordering:**  
   Refactor a code snippet with potential deadlock by enforcing a global lock ordering strategy.
8. **Deadlock Diagnostics:**  
   Implement a small tool that logs thread states and identifies conditions that may lead to deadlock.

#### Hard
9. **Dining Philosophers Simulation:**  
   Design and implement the Dining Philosophers problem that initially causes deadlock, then refactor it using a resource hierarchy or other strategy to avoid deadlock.
10. **Dynamic Deadlock Recovery:**  
    Create a multi-threaded application that detects deadlocks at runtime (e.g., via thread dumps) and recovers by interrupting one or more threads, then document your approach.

---

### **Day 12: `ForkJoinPool` & Parallel Streams**

#### Easy
1. **ForkJoin Sum:**  
   Write a simple program that uses ForkJoinPool to sum the elements of an integer array.
2. **Parallel Stream Filter:**  
   Create a program that processes a list of numbers in parallel using Java 8 parallel streams to filter even numbers.
3. **Recursive Fibonacci:**  
   Implement a recursive task using ForkJoinTask to compute Fibonacci numbers.
4. **RecursiveAction Demo:**  
   Write a basic RecursiveAction that prints out a message after splitting a task.

#### Medium
5. **Parallel Merge Sort:**  
   Develop a parallel merge sort algorithm using ForkJoinPool and compare its performance to a sequential merge sort.
6. **Stream Transformation:**  
   Create a program that uses parallel streams to map and filter a collection of strings.
7. **Recursive Task Splitting:**  
   Implement a ForkJoinTask that splits work recursively (e.g., summing large arrays) and combines results.
8. **Work-Stealing Monitor:**  
   Write a program that monitors ForkJoinPool’s work-stealing behavior under load and logs thread activity.

#### Hard
9. **Optimized Matrix Multiplication:**  
   Design a parallel algorithm for matrix multiplication using ForkJoinPool, optimizing for cache usage and load balancing.
10. **Complex Data Pipeline:**  
    Implement a parallel data processing pipeline that combines ForkJoinPool and parallel streams. Integrate error handling and dynamic task splitting, and provide performance metrics.

---

### **Day 13: ThreadLocal & Concurrent Collections (`CopyOnWriteArrayList`, `ConcurrentHashMap`)**

#### Easy
1. **Basic ThreadLocal:**  
   Write a program that uses ThreadLocal to store and retrieve a thread-specific counter.
2. **ConcurrentHashMap Demo:**  
   Create a simple program that uses ConcurrentHashMap to perform thread-safe operations.
3. **CopyOnWriteArrayList Iteration:**  
   Implement a program that demonstrates safe iteration over a CopyOnWriteArrayList while modifying it.
4. **ThreadLocal Formatter:**  
   Write a program that uses ThreadLocal to store a date formatter for each thread.

#### Medium
5. **Session Data Management:**  
   Develop an application that uses ThreadLocal to manage user session data in a simulated multi-threaded server.
6. **Synchronized List vs. COW List:**  
   Compare the performance of a synchronized list (e.g., Collections.synchronizedList) with a CopyOnWriteArrayList under concurrent read scenarios.
7. **Safe Initialization:**  
   Implement a scenario using ConcurrentHashMap’s putIfAbsent() to safely initialize a shared data structure.
8. **Atomic Map Update:**  
   Create a program that uses ConcurrentHashMap’s compute methods to update a map of counters atomically.

#### Hard
9. **ThreadLocal Object Cache:**  
   Design a system that uses ThreadLocal to cache expensive-to-create objects (e.g., database connections or parsers) and analyze its performance under high concurrency.
10. **Custom Lock-Free Collection:**  
    Implement a custom concurrent collection using lock-free techniques (with atomic variables) and compare its performance and correctness to Java’s built-in ConcurrentHashMap.

---

### **Day 14: Mini Project: Multi-threaded Web Scraper**

#### Easy
1. **Basic Web Scraper:**  
   Write a simple web scraper that uses a fixed thread pool to fetch the content from a list of URLs.
2. **Title Extraction:**  
   Enhance the scraper to extract and print the HTML title of each web page.
3. **Task Logging:**  
   Implement logging to indicate when each web scraping task starts and ends.
4. **Callable Status Code:**  
   Write a version that uses Callable to fetch web pages and return their HTTP status codes.

#### Medium
5. **Concurrent URL Processing:**  
   Develop a version of the web scraper that uses ExecutorService to handle multiple URL fetches concurrently and aggregates the results.
6. **Error Handling:**  
   Modify your scraper to gracefully handle failed requests and timeouts.
7. **CompletableFuture Scraper:**  
   Refactor the scraper to use CompletableFuture for asynchronous fetching and processing.
8. **Data Extraction:**  
   Enhance the scraper to parse each web page for specific data (e.g., meta tags) and store the results in a thread-safe collection.

#### Hard
9. **Dynamic URL Discovery:**  
   Design and implement a robust multi-threaded web scraper that not only processes a fixed list of URLs but also extracts links from each page and adds them to the queue dynamically.
10. **Resilient Scraper with Shutdown:**  
    Create an advanced web scraper that handles rate-limiting, retries failed requests, and supports a graceful shutdown that ensures no scraped data is lost. Provide a detailed explanation of your error recovery and shutdown strategy.

---

## **Week 3: Real-World Concurrency Patterns & Performance**

### **Day 15: Producer-Consumer Pattern**

#### Easy
1. **Simple Producer-Consumer:**  
   Write a producer-consumer program using wait() and notify() with a bounded buffer.
2. **Single Producer/Consumer:**  
   Implement a version with one producer and one consumer that prints produced and consumed items.
3. **Log Actions:**  
   Create a program that logs each production and consumption event with timestamps.
4. **Direct Buffer Print:**  
   Write a consumer that prints each item immediately after retrieval from the buffer.

#### Medium
5. **Multiple Producers/Consumers:**  
   Develop a system with multiple producers and multiple consumers using wait/notify for coordination.
6. **BlockingQueue Refactor:**  
   Refactor your producer-consumer solution to use a LinkedBlockingQueue and compare code complexity.
7. **Random Intervals:**  
   Implement a producer-consumer system where producers generate items at random intervals and consumers process them.
8. **Graceful Shutdown:**  
   Modify the system to support a graceful shutdown once producers have finished producing.

#### Hard
9. **Dynamic Producer/Consumer:**  
   Design a producer-consumer system that adjusts the number of producers and consumers dynamically based on the queue length.
10. **Priority-Based Processing:**  
    Create an advanced producer-consumer simulation (e.g., a printing service) where tasks have priorities. Use a priority queue and ensure synchronization and fairness among threads.

---

### **Day 16: Read-Write Locks & Optimistic Locking**

#### Easy
1. **Basic Read-Write Lock:**  
   Write a program that uses `ReentrantReadWriteLock` to allow concurrent reading of a shared resource.
2. **Concurrent Readers:**  
   Create a data structure protected by a read lock and demonstrate multiple threads reading concurrently.
3. **Logging Reads/Writes:**  
   Implement logging in a program to show when threads acquire and release read/write locks.
4. **Write Lock Update:**  
   Write a simple program that updates a shared resource using a write lock and prints the updated value.

#### Medium
5. **Simulated Database Access:**  
   Develop a simulation where multiple threads perform long-running read operations while occasional write operations update the data.
6. **Optimistic Locking with Versioning:**  
   Create a simple simulation that uses version numbers (or atomic variables) to implement optimistic locking.
7. **Refactor to Read-Write:**  
   Convert a synchronized application to use `ReentrantReadWriteLock` and compare the responsiveness under heavy read load.
8. **Performance Measurement:**  
   Write a program that measures throughput differences between read-write locks and simple locks under various workloads.

#### Hard
9. **Mixed Locking Strategy:**  
   Design a system that uses both read-write locks and optimistic locking (e.g., for a shared cache) to maximize concurrency. Provide a performance analysis.
10. **High-Load Simulation:**  
    Create a simulation where read operations vastly outnumber writes. Optimize the system with advanced locking techniques (or lock-free strategies) and document the performance gains.

---

### **Day 17: Bounded Queues (`BlockingQueue` & `LinkedBlockingQueue`)**

#### Easy
1. **Simple BlockingQueue:**  
   Write a program that creates a LinkedBlockingQueue, then add and remove elements while printing actions.
2. **Producer/Consumer with BlockingQueue:**  
   Implement a producer that adds items and a consumer that removes items from a BlockingQueue.
3. **Blocking on Empty:**  
   Write a program that demonstrates blocking behavior by having a consumer call `take()` on an empty queue.
4. **Timeout Offer:**  
   Create a program that uses `offer()` with a timeout on a bounded queue and prints a message when the queue is full.

#### Medium
5. **Ticket Booking Simulation:**  
   Develop a simulation where a bounded queue represents available tickets, and multiple threads attempt to book them.
6. **Call Center Simulation:**  
   Implement a simulation of a call center where incoming calls are queued in a BlockingQueue and handled by consumer threads.
7. **Processing Time Logging:**  
   Write a program that logs processing times of items in a producer-consumer system using a BlockingQueue.
8. **Backpressure Handling:**  
   Modify a web scraping application to use a BlockingQueue for URLs, handling the scenario when the queue becomes full.

#### Hard
9. **Real-World Order Processing:**  
   Design an order processing system using a bounded queue with multiple producers and consumers. Ensure low latency and thread safety under high load.
10. **Dynamic Resizing Queue:**  
    Create an enhanced bounded queue that supports dynamic resizing. Analyze its performance under varying workloads and document the results.

---

### **Day 18: CompletableFuture Advanced Concepts**

#### Easy
1. **Fixed Value Future:**  
   Write a simple CompletableFuture example that returns a fixed value.
2. **Basic Chaining:**  
   Create a chain of CompletableFuture tasks using `thenApply()` to transform a number.
3. **Result Printing:**  
   Implement a task that uses `thenAccept()` to print the final result of an asynchronous computation.
4. **Exceptional Completion:**  
   Write a program that completes a CompletableFuture exceptionally and handles the error using `exceptionally()`.

#### Medium
5. **Combining Futures:**  
   Develop a program that uses two independent CompletableFutures and combines their results with `thenCombine()`.
6. **Flattening Futures:**  
   Create an example that uses `thenCompose()` to flatten nested CompletableFutures.
7. **Processing Pipeline:**  
   Implement a pipeline with CompletableFuture where each stage processes data and passes it to the next stage.
8. **Asynchronous Exception Handling:**  
   Write a program that demonstrates handling exceptions in an asynchronous pipeline using `handle()`.

#### Hard
9. **Multi-Stage Aggregation:**  
   Design a multi-stage asynchronous process using a combination of `thenCompose()` and `thenCombine()` to aggregate data from multiple sources, with robust error recovery.
10. **Service Aggregator:**  
    Build a simulation where multiple asynchronous tasks (e.g., API calls) are coordinated using CompletableFuture. Merge the results into a final report with detailed logging and performance metrics.

---

### **Day 19: Concurrency Performance & Tuning**

#### Easy
1. **Synchronized vs. Atomic Benchmark:**  
   Write a benchmark comparing a synchronized counter with an AtomicInteger counter under moderate load.
2. **Thread Pool Timing:**  
   Create a program that measures the execution time of tasks running in a thread pool.
3. **Simple Task Timer:**  
   Implement a program that logs task execution times using `System.nanoTime()`.
4. **Varying Thread Count:**  
   Run a simple concurrent task with different thread counts and log the average execution time.

#### Medium
5. **High Contention Simulation:**  
   Develop a program that simulates heavy contention on a synchronized block and measures the impact on throughput.
6. **Profiler Integration:**  
   Write a program that runs a concurrent application and use a profiler (like VisualVM) to identify performance bottlenecks.
7. **Executor Parameter Tuning:**  
   Experiment with different thread pool parameters (core size, max size, keep-alive time) and log the impact on performance.
8. **Executor Comparison:**  
   Implement a benchmark comparing fixed, cached, and single-thread executors under varying workloads.

#### Hard
9. **Comprehensive Test Suite:**  
   Design a full performance test suite for a multi-threaded application. Measure lock contention, CPU usage, and memory utilization. Produce a detailed report of your findings.
10. **Dynamic Tuning Simulation:**  
    Create a simulation combining both I/O and CPU-bound tasks. Develop a mechanism to tune thread pool parameters dynamically based on runtime performance, and document the results.

---

### **Day 20: Parallel Algorithms & Best Practices**

#### Easy
1. **Parallel For-Loop:**  
   Write a program that uses Java 8 parallel streams to implement a parallel for-loop that sums numbers.
2. **Map-Reduce with Streams:**  
   Create a simple map-reduce operation using parallel streams.
3. **Parallel Summation:**  
   Implement a program using ForkJoinPool to sum an array of numbers in parallel.
4. **Stream Transformation:**  
   Write a program that processes a list of strings in parallel using stream operations (filter, map).

#### Medium
5. **Parallel Merge Sort:**  
   Develop a merge sort algorithm that uses ForkJoinPool to sort an array in parallel. Compare with a sequential version.
6. **Dataset Processing:**  
   Create a program that uses parallel streams to process a large dataset (e.g., filter and transform records) and compare performance.
7. **Element Counting:**  
   Implement a parallel algorithm to count the occurrences of a specific element in an array.
8. **False Sharing Demo:**  
   Write a program that demonstrates false sharing in multi-threaded array updates, then modify it to solve the issue.

#### Hard
9. **Optimized Matrix Multiplication:**  
   Design and implement a parallel matrix multiplication algorithm using ForkJoinPool. Optimize for cache utilization and load balancing.
10. **Dynamic Work Splitting:**  
    Create a parallel algorithm for a complex task (e.g., image processing) that dynamically splits work using both ForkJoinPool and parallel streams. Provide an in-depth performance analysis and document best practices.

---

### **Day 21: Final Project: High-Performance Logging System**

#### Easy
1. **Console Logger:**  
   Write a simple logging system that uses a fixed thread pool to write log messages to the console.
2. **BlockingQueue Logger:**  
   Create a logger that queues log messages in a BlockingQueue and processes them asynchronously.
3. **File Logger:**  
   Implement a version that writes log messages to a file asynchronously.
4. **Task Logging:**  
   Develop a program that logs the start and end of each logging task along with timestamps.

#### Medium
5. **Aggregated Logger:**  
   Design a logging system that collects log messages from multiple sources using a concurrent collection and aggregates them.
6. **Multi-Level Logging:**  
   Implement a logger that supports multiple log levels (INFO, DEBUG, ERROR) with separate processing threads.
7. **CompletableFuture Logger:**  
   Create a logging system that uses CompletableFuture to process log messages asynchronously.
8. **Timestamp & Thread ID:**  
   Enhance the logger to include precise timestamps and the thread ID for every log entry.

#### Hard
9. **High-Throughput Logger:**  
   Build a high-performance logging system capable of handling very high throughput without losing messages, including support for log rotation and a safe shutdown procedure.
10. **Distributed Logger:**  
    Design and implement a distributed logging system where log messages from multiple applications are aggregated into a central repository with fault tolerance and real-time monitoring. Provide a detailed design report of your solution.

---

### **Day 22: Final Project: Multi-Threaded File Scanner with GUI**

This exercise is structured progressively so that each subproblem builds on the previous one, ultimately leading to a complete multi-threaded file scanner with a GUI.

---  

## **📌 Problem Statement**
Build a **multi-threaded file scanner** that searches for files based on conditions (e.g., name contains "bob" or size is between 10kB-100kB) and provides a GUI to interact with it. The scanner should evolve from a **single-threaded** implementation to a **scalable multi-threaded** solution with a **responsive GUI** and a **cancel option**.

---

## **🛠️ Sub-Problems & Step-by-Step Approach**

### **🟢 Phase 1: Basic File Scanner (Single Threaded)**
📌 **Goal:** Implement a simple file scanner that searches a folder for matching files.

1️⃣ **Write a single-threaded program** to scan a folder and find files that match a condition.
- Take **folder path** as input.
- Search for **files containing "bob" in the name** OR **files between 10kB-100kB**.
- Print results and measure execution time.

**📝 Expected Outcome:** A working **single-threaded file scanner** that prints file paths.

---

### **🟡 Phase 2: Introducing Multi-Threading (Fixed Threads)**
📌 **Goal:** Improve performance by using **two threads**.

2️⃣ Modify the program to **split the work** between **two threads**.
- Divide the files between **Thread 1** and **Thread 2**.
- Ensure each thread scans a different part of the directory.
- Print results and measure execution time.
- Compare speed with the single-threaded version.

**📝 Expected Outcome:** **Faster execution** and understanding of how **multiple threads** can process files.

---

### **🟠 Phase 3: Dynamic Thread Pool for Scalability**
📌 **Goal:** Scale the program using a **variable number of threads** dynamically.

3️⃣ Modify the scanner to use an **ExecutorService (Thread Pool)**.
- Create a **configurable thread pool**.
- Assign each folder scan as a separate task.
- Prevent **overlapping** or **duplicate processing**.
- Handle **large directories efficiently**.

🔍 **Challenges to Address:**
- **Thread starvation:** Some threads may be waiting indefinitely.
- **Duplicate file scanning:** Ensure the same file isn’t scanned twice.

**📝 Expected Outcome:** A **scalable, multi-threaded** file scanner that adapts to system load.

---

### **🔴 Phase 4: Handling Synchronization & Shared Resources**
📌 **Goal:** Ensure **thread safety** when multiple threads access shared resources.

4️⃣ Use **concurrent collections (`ConcurrentHashMap`)** to store scanned file paths.
- Prevent **race conditions** when multiple threads modify shared data.
- Ensure **efficient synchronization** using `ReentrantLock` or `synchronized`.

🔍 **Challenges to Address:**
- **Data corruption** if multiple threads modify the same list.
- **Performance bottlenecks** due to excessive locking.

**📝 Expected Outcome:** A **thread-safe multi-threaded scanner** that prevents duplicate processing.

---

### **🟣 Phase 5: Adding GUI for User Interaction**
📌 **Goal:** Create a **basic GUI** with user input and background scanning.

5️⃣ Build a **Java Swing / JavaFX** GUI with:
- An **editable text field** for folder selection.
- A **start button** to trigger the scan.
- A **display area** to show search results.
- Ensure the UI **remains responsive** while scanning.

🔍 **Challenges to Address:**
- **Long-running tasks freezing the UI.**
- **Properly updating the UI from background threads.**

**📝 Expected Outcome:** A **GUI-based file scanner** that runs in the background without freezing.

---

### **🟤 Phase 6: Adding a Cancel Button (Thread Interruption)**
📌 **Goal:** Allow users to **cancel the scan** at any time.

6️⃣ Add a **Cancel Button** to **stop the scanning process mid-way**.
- Use **thread interruption (`Thread.interrupt()`)** to stop active threads.
- Ensure the program **gracefully shuts down** ongoing tasks.

🔍 **Challenges to Address:**
- **Properly handling interrupted tasks.**
- **Avoiding resource leaks when stopping mid-way.**

**📝 Expected Outcome:** A **fully interactive GUI** that lets users start and cancel file scanning.

---

### **🟢 Bonus Challenge: Performance Testing & Optimization**
📌 **Goal:** Fine-tune performance for **large directories** and **many threads**.

7️⃣ Experiment with:
- Different **thread pool sizes** (`FixedThreadPool`, `CachedThreadPool`).
- Optimizing **I/O-bound** operations.
- Handling **1,000+ files efficiently**.

🔍 **Key Learnings:**
- Difference between **CPU-bound** and **I/O-bound** multithreading.
- Understanding **bottlenecks** in concurrent execution.

**📝 Expected Outcome:** A **high-performance file scanner** with optimal thread utilization.

---

## **🎯 Final Deliverable:**
A **fully functional multi-threaded file scanner with GUI** that:  
✅ Scans folders **efficiently** using **multiple threads**.  
✅ Uses **thread-safe collections** to store results.  
✅ Has a **GUI** that remains **responsive** during scanning.  
✅ Supports **cancellation** while scanning.  
✅ Can handle **large file directories** efficiently.

---

## **💡 Key Concepts Covered in This Exercise:**
- **Thread Creation** (`Thread` & `Runnable`).
- **Thread Pools & Executors** (`ExecutorService`).
- **Synchronization & Thread Safety** (`ReentrantLock`, `ConcurrentHashMap`).
- **Parallel Processing** (Splitting work across multiple threads).
- **Java Swing / JavaFX UI Updates from Threads**.
- **Thread Interruption & Graceful Shutdown**.

---

## **🚀 Why This Exercise?**
This hands-on project will give you **practical experience** in Java concurrency and **real-world challenges** like:  
🔹 Deadlocks & race conditions.  
🔹 Thread synchronization & performance optimization.  
🔹 GUI-Thread interaction & handling long-running tasks.

---