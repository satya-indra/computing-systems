package org.example.streams.terminal_operations.reduce;

import org.example.streams.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Use `reduce()` to calculate the sum of all salary in a stream.
 *
 */
public class ReduceMergeListsExample {
    public static void main(String[] args) {
        List<Employee> empList1 = Employee.getSampleEmployees();
        List<Employee> empList2 = Employee.getSampleEmployees();


        List<Employee> result = Stream.of(empList1, empList2)
                .reduce(new ArrayList<Employee>(), (a, b) -> {
                    a.addAll(b);
                    return a;
                });
        System.out.println(result);
    }
}
