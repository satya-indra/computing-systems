package org.example.streams.intermediate_operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 4. Use `flatMap()` to flatten a list of lists into one list.
 */
public class Problem_4 {

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
