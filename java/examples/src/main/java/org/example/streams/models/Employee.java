package org.example.streams.models;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Salary: " + salary + ")";
    }

    // ✅ Pre-filled list of employees
    public static List<Employee> getSampleEmployees() {
        return Arrays.asList(
                new Employee("Alice", 30, 50000),
                new Employee("Bob", 45, 70000),
                new Employee("Charlie", 25, 60000),
                new Employee("David", 35, 65000),
                new Employee("Eve", 50, 80000),
                new Employee("Frank", 28, 55000),
                new Employee("Grace", 40, 72000),
                new Employee("Hank", 33, 68000)
        );
    }
}

