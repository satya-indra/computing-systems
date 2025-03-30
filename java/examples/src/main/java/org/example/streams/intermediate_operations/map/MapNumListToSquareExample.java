package org.example.streams.intermediate_operations.map;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 3. Convert a stream of integers to their squares.
 */
public class MapNumListToSquareExample {
    public static void main(String[] args) {
        int[] input = IntStream.range(0, 20).toArray();
        int[] result = Arrays.stream(input).map(num -> num*num).toArray();

        for(int i : result) {

            System.out.print(i + " ");
        }

    }
}
