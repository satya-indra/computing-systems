package org.example.streams.terminal_operations.reduce;

import org.example.streams.models.Employee;

import java.util.List;

/**
 * Use `reduce()` to calculate the sum of all salary in a stream.
 *
 */
public class ReduceStringConcatExample {
    public static void main(String[] args) {
        List<Employee> empList = Employee.getSampleEmployees();
        String result = empList.stream()
                .map(Employee::getName)
                .reduce("", (total, current) -> total + ", " + current);
        System.out.println(result);
    }
}
