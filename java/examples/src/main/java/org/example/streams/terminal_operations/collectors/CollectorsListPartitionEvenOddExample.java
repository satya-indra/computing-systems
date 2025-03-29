package org.example.streams.terminal_operations.collectors;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsListPartitionEvenOddExample {
    public static void main(String[] args) {
        List<Employee> input = Employee.getSampleEmployees();
        Map<Boolean, List<Employee>> result = input.stream().collect(Collectors.partitioningBy(ele -> ele.getAge() % 2 == 0));
        System.out.println(result);

        // if need to partition with key as EVEN and ODD then use groupingBy

        Map<String, List<Employee>> result2 = input.stream().collect(Collectors.groupingBy(element -> element.getAge() % 2 == 0 ? "EVEN" : "ODD"));
        System.out.println(result2);
    }
}
