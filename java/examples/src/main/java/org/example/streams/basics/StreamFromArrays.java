package org.example.streams.basics;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFromArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};

        IntStream stream = createStreamFromArray(arr);

    }

    private static IntStream createStreamFromArray(int[] arr) {
        return Arrays.stream(arr);
    }
}
