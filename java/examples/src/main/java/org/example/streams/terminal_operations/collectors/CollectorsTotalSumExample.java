package org.example.streams.terminal_operations.collectors;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsTotalSumExample {
    public static void main(String[] args) {
        List<Employee> list = Employee.getSampleEmployees();
        int result = list.stream().mapToInt(e -> (int) e.getSalary()).sum();
        System.out.println(result);
    }
}
