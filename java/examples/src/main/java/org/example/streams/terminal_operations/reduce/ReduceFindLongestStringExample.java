package org.example.streams.terminal_operations.reduce;

import org.example.streams.models.Employee;

import java.util.List;

/**
 * Use `reduce()` to calculate the sum of all salary in a stream.
 *
 */
public class ReduceFindLongestStringExample {
    public static void main(String[] args) {
        List<Employee> empList = Employee.getSampleEmployees();
        String result = empList.stream()
                .map(Employee::getName)
                .reduce("", (prev, curr) -> prev.length() > curr.length() ? prev : curr);
        System.out.println(result);
    }
}
