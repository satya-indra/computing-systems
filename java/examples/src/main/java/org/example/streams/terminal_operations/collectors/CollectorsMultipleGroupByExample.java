package org.example.streams.terminal_operations.collectors;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMultipleGroupByExample {
    public static void main(String[] args) {
        List<Employee> list = Employee.getSampleEmployees();
        Map<String, Map<Double, List<Employee>>> result = list.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy(Employee::getSalary)));
        System.out.println(result);
    }
}
