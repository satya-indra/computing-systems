package org.example.streams.terminal_operations.collectors;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsListToCSVExample {
    public static void main(String[] args) {
        List<Employee> list = Employee.getSampleEmployees();

        String result = list.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(result);

    }
}
