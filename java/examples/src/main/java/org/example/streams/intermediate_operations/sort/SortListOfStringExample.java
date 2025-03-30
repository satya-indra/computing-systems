package org.example.streams.intermediate_operations.sort;

import java.util.Comparator;
import java.util.List;

/**
 * 6. Sort a list of strings in natural order and then in reverse order.
 */
public class SortListOfStringExample {
    public static void main(String[] args) {
        List<String> input = List.of("a", "abc", "b", "bcd");
        List<String> naturalOrder = input.stream().sorted(Comparator
                .naturalOrder())
        .toList();

        List<String> reverseOrder = input.stream().sorted(Comparator.reverseOrder()).toList();

    }
}
