package org.example.streams.intermediate_operations;

import org.example.streams.models.Employee;

import java.util.List;

/**
 * 9. Chain `filter()`, `map()`, and `sorted()` to transform and order a list of custom objects.
 * // Filter employees older than 30,
 *  Extract only names,
 *  Sort names in natural order,
 *  Collect to List
 */
public class Problem_9 {
    public static void main(String[] args) {
        List<Employee> empList = Employee.getSampleEmployees();

        List<String> result = empList.stream()
                .filter(emp -> emp.getSalary() > 60000)
                .map(Employee::getName)
                .sorted()
                .toList();

        System.out.println(result);

    }
}
