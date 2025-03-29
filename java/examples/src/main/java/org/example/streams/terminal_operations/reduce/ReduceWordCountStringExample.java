package org.example.streams.terminal_operations.reduce;

import org.example.streams.models.Employee;

import java.util.List;

/**
 * Use `reduce()` to calculate the sum of all salary in a stream.
 *
 */
public class ReduceWordCountStringExample {
    public static void main(String[] args) {
        List<Employee> empList = Employee.getSampleEmployees();
        Double result = empList.stream()
                .map(Employee::getSalary)
                .reduce(0.0, (total, curr) -> total + 1);
        System.out.println(result);
    }
}
