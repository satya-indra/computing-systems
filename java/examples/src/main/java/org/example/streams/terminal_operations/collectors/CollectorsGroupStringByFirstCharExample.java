package org.example.streams.terminal_operations.collectors;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGroupStringByFirstCharExample {
    public static void main(String[] args) {
        List<Employee> input = Employee.getSampleEmployees();
        Map<Character, List<Employee>> result = input
                .stream()
                .collect(Collectors.groupingBy(name -> name.getName().charAt(0)));
        System.out.println(result);
    }
}
