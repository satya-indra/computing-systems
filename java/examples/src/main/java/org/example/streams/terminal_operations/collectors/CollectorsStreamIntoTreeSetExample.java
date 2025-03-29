package org.example.streams.terminal_operations.collectors;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectorsStreamIntoTreeSetExample {
    public static void main(String[] args) {
        List<Employee> list = Employee.getSampleEmployees();
        TreeSet<Employee> result = list.stream().collect(Collectors.toCollection(TreeSet::new));
    }
}
