package org.example.streams.basics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        // Create stream of random numbers between tw values
        List<Integer> numList = IntStream.range(1, 50).boxed().toList();

//        filterOutNumbersGreaterThanKth(numList, 5);
//
//        convertListOfNumbersIntoSquares(numList);

        countElementsOnCondition(numList, 20);

        checkEmptyStream(stream);

    }

    /**
     * Check if a stream is empty and handle it safely.
     * @param stream
     */
    private static void checkEmptyStream(Stream<Integer> stream) {
        Optional<Integer> ans = stream.findAny();
        System.out.println(ans.isEmpty());
    }

    /***
     * Count the number of elements in a stream that match a specific condition.
     * @param numList
     * @param condition
     */
    private static void countElementsOnCondition(List<Integer> numList, int condition) {

        long ans = numList.stream().filter(element -> element > condition).count();
        System.out.println(ans);
    }

    /**
     * Convert a stream of integers into their squares.
     * @param numList
     */
    private static void convertListOfNumbersIntoSquares(List<Integer> numList) {
        List<Integer> ans = numList.stream().map(element -> element * element).toList();
        System.out.println(ans);
    }

    /**
     * Create a stream from a list of integers and filter out numbers greater than a given value.
     * @param list
     * @param k
     */
    private static void filterOutNumbersGreaterThanKth(List<Integer> list, int k) {
        List<Integer> ans = list.stream().filter(element -> element > k).toList();
        System.out.println(ans);
    }

    private static Stream<Integer> createStreamFromInteger(List<Integer> list) {
        return list.stream();
    }


}
