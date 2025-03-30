package org.example.streams.intermediate_operations.flatmap;

import java.util.Arrays;
import java.util.List;

/**
 * 4. Use `flatMap()` to flatten a list of lists into one list.
 */
public class FlatMapFlattenListExample {

    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("cherry", "date"),
                Arrays.asList("elderberry", "fig", "grape")
        );

        List<String> result = listOfLists.stream().flatMap(List::stream).toList();

        System.out.println(result.toString());
    }

}
