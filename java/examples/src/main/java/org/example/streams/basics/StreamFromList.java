package org.example.streams.basics;

import java.util.List;
import java.util.stream.Stream;

/**
 * - **Practice Problems**
 *     1. Create a stream from a list of integers and filter out numbers greater than a given value.
 *     2. Convert a stream of integers into their squares.
 *     3. Count the number of elements in a stream that match a specific condition.
 *     4. Check if a stream is empty and handle it safely.
 *     5. Print each element of a stream using `forEach()`.
 */
public class StreamFromList {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 5, 10);
        Stream<Integer> stream = createStreamFromInteger(list);

    }

    private static Stream<Integer> createStreamFromInteger(List<Integer> list) {
        return list.stream();
    }


}
