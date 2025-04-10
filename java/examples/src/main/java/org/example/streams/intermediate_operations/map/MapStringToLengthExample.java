package org.example.streams.intermediate_operations.map;

import java.util.List;

/**
 * Map a list of strings to their lengths.
 * Input ["Banana", "Apple", "Orange"]
 * Output [6, 5, 6]
 */
public class MapStringToLengthExample {
    public static void main(String[] args) {
        List<String> list = List.of("Banana", "Apple", "Orange");
        List<Integer> result = list.stream().map(element -> element.length()).toList();
        System.out.println(result);
    }
}
