package com.rp.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chapter3Challenge2 {
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

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", salary=" + salary +
                    '}';
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


        Map<String, Float> jobTitleAvgSalaryMap = employees
                .stream()
                .collect(Collectors.groupingBy((employee -> employee.jobTitle)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                                .stream()
                                .map(employee -> employee.salary)
                                .reduce(0f, (acc, x) -> (acc + x) / entry.getValue().size())
                ));

        /**
         * Challenge
         * 1. Create a map with Job Title as a Ke : Average Salary as a value
         * Approach:
         * 1. Get hold of stream from Employee collection
         * 2. Use Collectors.groupingBy pivoting on jobtitle. This would get hold of Map Structure <jobtitle, list<employees>
         * 3. Get hold of stream generated based on collections entrySet api call
         * 4. Use collectors.toMap - with keys as still job title and process values as
         * 4.1. Map the object to colleciton of salaries
         * 4.2. Reduce the salaries by acumulating and dividing total count.
         */

        Map<String, Float> avSalMap = employees
                .stream()
                .collect(Collectors.groupingBy(employee -> employee.jobTitle))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry) -> entry.getValue()
                        .stream()
                        .map(employee -> employee.salary)
                        .reduce(0f, (acc,x) -> (acc+x) / entry.getValue().size())
                ));

        System.out.println(avSalMap   );
    }
}
