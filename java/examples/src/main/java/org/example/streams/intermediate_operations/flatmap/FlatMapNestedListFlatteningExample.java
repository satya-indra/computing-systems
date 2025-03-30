package org.example.streams.intermediate_operations.flatmap;

import java.util.Arrays;
import java.util.List;

public class FlatMapNestedListFlatteningExample {
    public static void main(String[] args) {
        // Deeply nested list (List of Objects)
        // We dont know the exact levels of nesting hence object
        List<Object> nestedList = Arrays.asList(
                "apple",
                Arrays.asList("banana", Arrays.asList("cherry", "date")),
                Arrays.asList("elderberry", Arrays.asList(Arrays.asList("fig", "grape")), "honeydew")
        );

        System.out.println(nestedList);



    }
}
