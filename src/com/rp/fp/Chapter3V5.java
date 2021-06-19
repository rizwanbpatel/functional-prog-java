package com.rp.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chapter3V5 {
    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        /**
         * Discover the role based salary average developer compare to other job titles
         */

        Predicate<Employee> developers = employee -> employee.jobTitle.equalsIgnoreCase("developer");

        Float totalDeveloperSalaries = employees
                .stream()
                .filter(developers)
                .map(developer -> developer.salary)
                .reduce(0f, (acc, x) -> acc + x);
        Long numberOfDevelopers = employees
                .stream()
                .filter(developers)
                .collect(Collectors.counting());

        Float averageDeveloperSalar = totalDeveloperSalaries / numberOfDevelopers;

        System.out.println(averageDeveloperSalar);


    }
}
