package org.example.streams.terminal_operations.collectors;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.OptionalDouble;

public class CollectorsFindAverageExample {
    public static void main(String[] args) {
        List<Employee> list = Employee.getSampleEmployees();
        double average = list.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        System.out.println(average);
    }
}
