package org.example.streams.terminal_operations.collectors;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 4. Create a map where keys are string lengths and values are lists of strings with that length.
 */
public class CollectorsGroupStringLengthExample {
    public static void main(String[] args) {
        List<Employee> list = Employee.getSampleEmployees();

        Map<Integer, List<Employee>> result = list.stream()
                .collect(Collectors.groupingBy(element -> element.getName().length()));

        System.out.println(result);

    }
}
