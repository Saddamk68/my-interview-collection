/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import myinterviewcollection.util.Employee;

/**
 *
 * @author saddam
 */
public class EmployeeProblems {
    
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        
        empList.add(new Employee(1, "John", "Engineering", 50000));
        empList.add(new Employee(2, "Alice", "Sales", 60000));
        empList.add(new Employee(3, "Jhony", "Engineering", 60000));
        empList.add(new Employee(4, "James", "Engineering", 48000));
        empList.add(new Employee(5, "Amily", "Sales", 40000));
        empList.add(new Employee(6, "Ama", "Sales", 30000));
        empList.add(new Employee(7, "Alen", "Sales", 25000));
        empList.add(new Employee(8, "Ema", "Marketing", 29000));
        empList.add(new Employee(9, "Elson", "Marketing", 22000));
        empList.add(new Employee(10, "Elen", "Marketing", 25000));
        empList.add(new Employee(11, "Adam", "Engineering", 60000));
        
        findMaxSalariedEmployees(empList);
        
        findMaxSalariedEmployeeOfEachDepartment(empList);
        
        
        // Create HashMap with Employee as key and some arbitrary value as value
        HashMap<Employee, String> employeeMap = new HashMap<>();

        // Create Employee objects
        Employee emp1 = new Employee(1, "John", "Engineering", 50000);
        Employee emp2 = new Employee(2, "Alice", "Sales", 60000);
        Employee emp3 = new Employee(1, "John", "Engineering", 50000); // Duplicate of emp1

        // Add employees to the HashMap
        employeeMap.put(emp1, "Employee 1");
        employeeMap.put(emp2, "Employee 2");

        System.out.println("Size of map is : " + employeeMap.size());
        // Retrieve value by providing a key
        String value = employeeMap.get(emp1);
        System.out.println("Value for emp1: " + value); // Output: Employee 1

        // Retrieve value by providing a key
        value = employeeMap.get(emp2);
        System.out.println("Value for emp2: " + value); // Output: Employee 1
        
        // Retrieving with a duplicate key
        value = employeeMap.get(emp3);
        System.out.println("Value for emp3: " + value); // Output: Employee 1 (because emp3 has same details as emp1)
        
        System.out.println("hashCode of emp1 : " + emp1.hashCode()); // Output: Employee 1
        System.out.println("hashCode of emp3 : " + emp3.hashCode()); // Output: Employee 1

    }
    
    /**
     * @company : Coforge
     * @implementedFuntions : mapToDouble, max, getAsDouble, filter, sorted
     * find the list of max salaried employees and sort them based on there name
     */
    public static void findMaxSalariedEmployees(List<Employee> empList) {        
        double maxSalary = empList.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .getAsDouble();
        
        empList.stream()
                .filter(emp -> emp.getSalary() == maxSalary)
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .forEach(emp -> {
                    System.out.println("Emp Name : " + emp.getName() + " Emp Salary : " + emp.getSalary());
                });
    }
    
    /**
     * @company : Seimen
     * @implementedFuntions : groupingBy, maxBy
     * find the list of max salaried employees of each department
     */
    public static void findMaxSalariedEmployeeOfEachDepartment(List<Employee> empList) {
        Map<String, Optional<Employee>> maxSalaryEmployeesByDepartment = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
//                .entrySet().forEach(entry -> System.out.println(entry.getValue().get().getName()));
        
        maxSalaryEmployeesByDepartment.forEach((department, emp) -> {
            System.out.println("Department: " + department 
                    + " Salary : " + emp.get().getSalary() 
                    + " Name : " + emp.get().getName());
            
//            System.out.println("Department: " + department);
//            employee.ifPresent(emp -> System.out.println("Max Salary Employee: " + emp.getName()));
//            System.out.println();
        });
    }
    
}
