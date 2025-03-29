package org.example.streams.intermediate_operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 8. Skip the first 3 elements of a stream and collect the next 7.
 */
public class Problem_8 {
    public static void main(String[] args) {
        
        List<Integer> input = IntStream.range(0, 20).boxed().toList();

        List<Integer> result = input.stream().skip(3).toList();



    }
}
