package org.example.streams.terminal_operations.reduce;

import org.example.streams.models.Employee;

import java.util.List;

/**
 * Use `reduce()` to calculate the sum of all salary in a stream.
 *
 */
public class ReduceMultiplySalaryExample {
    public static void main(String[] args) {
        List<Employee> empList = Employee.getSampleEmployees();
        Double result = empList.stream()
                .map(Employee::getSalary)
                .reduce(1.0, (total, curr) -> total * curr);
        System.out.println(result);
    }
}
