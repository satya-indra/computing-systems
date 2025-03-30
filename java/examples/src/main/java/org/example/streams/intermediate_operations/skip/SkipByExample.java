package org.example.streams.intermediate_operations.skip;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 8. Skip the first 3 elements of a stream and collect the next 7.
 */
public class SkipByExample {
    public static void main(String[] args) {
        
        List<Integer> input = IntStream.range(0, 20).boxed().toList();

        List<Integer> result = input.stream().skip(3).toList();



    }
}
