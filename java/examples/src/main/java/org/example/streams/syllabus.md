# Java Stream API Study Plan for Interview Preparation

## 1. **Stream Basics**
- **Key Concepts**
    - Introduction to Streams
      - Creating Streams (from Collections, Arrays, and Functions)
        - Collections
          - List
            - List.stream()
          - Map
            - Map.keySet().stream()
            - Map.entrySet().stream()
          - Set
        - Arrays
          - Arrays.stream(intArray) -- returns IntStream
              ```
                int[] arr = {1, 2, 3};
                IntStream stream = Arrays.stream(arr);
              ```
            - Pros
              - Useful for primitive data types like int[], double[] etc
              - Avoids boxing/unboxing overhead
              - Additional operations like sum(), average() available
            - Cons
              - Not suitable for object arrays like Integer[]
              - If result is required in Stream<Integer> then boxing is required which is less efficient.
          - Stream.of(IntegerArray) -- returns Stream<Integer>
              ```
                Integer[] arr = {1, 2, 3};
                Stream<Integer> stream = Stream.of(arr);
              ```
          - IntStream.of(intArray)
          - IntStream.range()
            - Useful for generating numbers
        - Functions
          - Stream.generate() -- to generate infinite streams based on supplier
            - example
            ```java
             import java.util.stream.Stream;

             public class StreamFromFunction {
             public static void main(String[] args) {
             // Generate a stream of random numbers
             Stream<Double> randomStream = Stream.generate(Math::random);
          
             // Limit to 5 elements and print
             randomStream.limit(5).forEach(System.out::println);
             }
            }
            ```
          - Stream.iterate -- creating sequences with custom rules
          - StreamSupport.stream()
          - Stream.Builder
    - Understanding Stream Pipeline (Source → Intermediate → Terminal Operations)

- **Practice Problems**
    1. Create a stream from a list of integers and filter out numbers greater than a given value.
    2. Convert a stream of integers into their squares.
    3. Count the number of elements in a stream that match a specific condition.
    4. Check if a stream is empty and handle it safely.
    5. Print each element of a stream using `forEach()`.

---

## 2. **Intermediate Operations**
- **Key Concepts**
    - `filter()`
    - `map()`
      - Used for transformation, converts each element of stream into another object.
      - Practise Problems
        1. Convert a List of Strings to Uppercase
        2. Convert a stream of integers into their squares.
        3. Extract a Field from an Object
    - `flatMap()`
    - `sorted()`
    - `distinct()`
    - `limit()` and `skip()`

- **Practice Problems**
    1. Filter even numbers from a list of integers.
    2. Flatten a list of lists into a single list using `flatMap()`.
    3. Sort a list of strings alphabetically and in reverse order.
    4. Remove duplicates from a stream of integers using `distinct()`.
    5. Skip the first 3 elements and return the next 5 from a stream.

---

## 3. **Terminal Operations**
- **Key Concepts**
    - `collect()`
    - `reduce()`
    - `forEach()`
    - `toArray()`
    - Matching operations (`anyMatch()`, `allMatch()`, `noneMatch()`)

- **Practice Problems**
    1. Find the sum of all elements in a stream using `reduce()`.
    2. Group strings by their lengths using `collect()` and `Collectors.groupingBy()`.
    3. Check if all elements in a list are positive using `allMatch()`.
    4. Convert a stream of integers to an array using `toArray()`.
    5. Find the maximum and minimum values in a stream of numbers.

---

## 4. **Collectors API**
- **Key Concepts**
    - Collecting results into different data structures (`toList()`, `toSet()`, `toMap()`)
    - Grouping and partitioning data
    - Aggregation (`summingInt()`, `averagingDouble()`)

- **Practice Problems**
    1. Convert a list of integers into a comma-separated string.
    2. Group people by their age using `groupingBy()`.
    3. Partition a list of numbers into even and odd using `partitioningBy()`.
    4. Create a map where the key is the string length and the value is a list of strings of that length.
    5. Calculate the total and average salary of employees in a list.

---

## 5. **Parallel Streams**
- **Key Concepts**
    - Introduction to parallel streams
    - Converting a stream to parallel
    - Performance considerations and pitfalls

- **Practice Problems**
    1. Process a large dataset of integers using parallel streams and compare performance with sequential streams.
    2. Use parallel streams to calculate the sum of an array of numbers.
    3. Debug and handle concurrency issues in a program using parallel streams.
    4. Parallelize a stream pipeline for a CPU-intensive task.

---

## 6. **Stream API with Custom Objects**
- **Key Concepts**
    - Stream operations on custom objects
    - Combining multiple operations in a single pipeline

- **Practice Problems**
    1. Filter a list of employees earning above a specific threshold.
    2. Sort a list of students by grade and then by name.
    3. Find the oldest person in a list of `Person` objects using `max()`.
    4. Convert a list of `User` objects into a map with `userId` as the key and `userName` as the value.

---

## 7. **Real-World Use Cases**
- **Key Concepts**
    - Applying multiple Stream API features in a single program
    - Solving real-world problems using Stream API

- **Practice Problems**
    1. Find the most frequent word in a paragraph using Stream API.
    2. Write a program to implement word count using streams.
    3. Remove duplicate and sort a list of products by price.
    4. Combine multiple data sources (e.g., two lists) and process them using streams.

---

## 8. **Advanced Topics**
- **Key Concepts**
    - Using `peek()` for debugging
    - Handling exceptions in Stream API
    - Combining Streams

- **Practice Problems**
    1. Use `peek()` to debug a stream pipeline that processes a list of strings.
    2. Handle exceptions in a stream operation where each element might throw an exception.
    3. Merge two streams of integers and remove duplicates.

---

## Additional Resources
- [LeetCode: Java Stream API Problems](https://leetcode.com/)
- [HackerRank: Functional Programming Challenges](https://www.hackerrank.com/)
- [Baeldung: Stream API Guide](https://www.baeldung.com/java-8-streams)
- Practice exercises from Java-focused blogs and tutorials.

## Notes
- Focus on understanding the concepts behind each operation and its real-world applicability.
- Discuss solutions with peers or mentors for better clarity.
- Attempt to optimize stream pipelines for readability and performance.
