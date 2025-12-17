package practiceQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class practiceSet1{
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList( new Employee("John", "IT", 50000),
                new Employee("Alice", "HR", 45000),
                new Employee("Bob", "IT", 55000),
                new Employee("Jane", "Finance", 60000));


       Map<String , Map<Double , List<Employee>>>  result = employees.stream().collect(Collectors.groupingBy(
               Employee::getDepartment,
               Collectors.groupingBy(Employee::getSalary)));

        System.out.println(result);

     Map<String, Optional<Employee>> minSalary=   employees.stream().collect(Collectors.groupingBy(Employee::getDepartment
                , Collectors.minBy(Comparator.comparing(Employee :: getSalary))));

        System.out.println("min salary  "+minSalary);



    }
}
