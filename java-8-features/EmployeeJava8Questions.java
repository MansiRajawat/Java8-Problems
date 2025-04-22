import java.util.*;
import java.util.stream.Collectors;

public class EmployeeJava8Questions {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList( new Employee("John", "IT", 50000),
                new Employee("Alice", "HR", 45000),
                new Employee("Bob", "IT", 55000),
                new Employee("Jane", "Finance", 60000));

        // Filter employees who work in IT department and have salary > 50000
       List<Employee> result = filterEmployees(employees);
        System.out.println(result);

        //find average salary of all the employees
        double salary = findAverageSalaries(employees);
        System.out.println(salary);

        //group employees by the departments

        Map<String, List<Employee>> groupingOfEMployess =  groupEmployeesByDeparments(employees);
        System.out.println(groupingOfEMployess);

        //maximum salaries in each department.
        Map<String, Optional<Employee>>
                employeesWithMaxSalaryInEachDept = maximumSalariesInEachDepartment(employees);
        System.out.println(employeesWithMaxSalaryInEachDept);

        //sort the employees based on the salary.

        List<Employee> sortEmpBasedOnSalary=  sortEmployeesBasedOnSalaries(employees);
        System.out.println(sortEmpBasedOnSalary);

    }

    private static List<Employee> sortEmployeesBasedOnSalaries(List<Employee> employees) {
      return  employees.stream().sorted(Comparator.comparing(Employee:: getSalary, Comparator.reverseOrder()))
                .collect(Collectors.toList());

    }

    private static Map<String, Optional<Employee>> maximumSalariesInEachDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

    }

    private static Map<String, List<Employee>> groupEmployeesByDeparments(List<Employee> employees) {
       return employees.stream().collect(Collectors.groupingBy(i -> i.getDepartment()));
    }

    private static double  findAverageSalaries(List<Employee> employees) {
       return employees.stream().mapToDouble(i -> i.getSalary()).average().orElse(0.0);
    }

    private static List<Employee> filterEmployees(List<Employee> employees) {
       return employees.stream()
               .filter(e -> "IT".equals(e.getDepartment()) && e.getSalary() > 50000)
               .collect(Collectors.toList());
    }
}
