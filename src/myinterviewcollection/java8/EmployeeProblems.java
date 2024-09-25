/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
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
        empList.add(new Employee(12, "John", "Engineering", 51000));
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
        
        listToMap(empList);
        
        findMaxSalariedEmployees(empList);
        
        findMaxSalariedEmployeeOfEachDepartment(empList);
        
        findKthHighestSalariedEmployees(empList, 1);        
        
        System.out.println("sortEmployeeOnThereNameAndSalary : ");
        print(sortEmployeeOnThereNameAndSalary(empList));
        
        groupEmployeeByDepartment(empList);
        
        /**
         * This will does the same thing as sortEmployeeOnThereNameAndSalary method does
         */
//        Collections.sort(empList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee e1, Employee e2) {
//                // First compare by name (ascending)
//                int nameComparison = e1.getName().compareTo(e2.getName());
//                if (nameComparison != 0) {
//                    return nameComparison;
//                }
//                // If names are the same, compare by salary (descending)
//                return Double.compare(e2.getSalary(), e1.getSalary());
//            }
//        });
        
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
    
    // print employee list
    public static void print(List<Employee> empList) {
        empList.forEach(emp -> {
            System.out.println("Id : " + emp.getId() 
                    + ", Name : " + emp.getName() 
                    + ", Salary : " + emp.getSalary());
        });
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
//                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
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
    
    /**
     * @company : 
     * @implementedFuntions : Objects.nonNull(), map, distinct, sorted, reverseOrder, skip, findFirst, get
     * find the k'th highest salary where k is an integer given by user
     */
    public static double findKthHighestSalary(List<Employee> empList, int k) {
        return empList.stream()
                .filter(Objects::nonNull) // to filter null Employee object
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(k-1)
                .findFirst()
                .get();                
    }
    
    /**
     * @company : 
     * @implementedFuntions : filter, forEach
     * find the list of max salaried employees who has k'th highest salary
     * where k is an integer given by user
     */
    public static void findKthHighestSalariedEmployees(List<Employee> empList, int k) {
        double salary = findKthHighestSalary(empList, k);

        System.out.println("k'th highest salaried employees are : ");
        empList.stream().filter(emp -> emp.getSalary() == salary).forEach(emp -> {
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getDepartment() + " " + emp.getSalary());
        });
    }
    
    /**
     * @company : Global Logic
     * @implementedFuntions : sorted, comparing, thenComparing, reverseOrder
     * sort the list of employee based on there name in ascending order
     * and if the names are same sort them based on there salary in descending order
     */
    public static List<Employee> sortEmployeeOnThereNameAndSalary(List<Employee> empList) {
        return empList.stream()
                .sorted(Comparator.comparing(Employee::getName)
//                        .thenComparing(Collections.reverseOrder(Comparator.comparing(Employee::getSalary))))
                        .thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
                .toList();
    }

    /**
     * @company : Altimetrik
     * @implementedFuntions : Collectors.toMap()
     * converting a list of employee object to map 
     * where key is id and value is entire employee object
     */
    public static void listToMap(List<Employee> empList) {
        System.out.println("Converting list of employee to map");
        Map<Integer, Employee> map = empList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
        
        map.entrySet().forEach(entry -> {
            System.out.println("Key : " + entry.getKey() + " and Value is : " + entry.getValue());
        });
    }
    
    public static void groupEmployeeByDepartment(List<Employee> empList) {
        Map<String, List<Employee>> map = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        
        map.entrySet().forEach(entry -> {
            System.out.println("Department is : " + entry.getKey() + " and Employees are : " + entry.getValue());
        });
    }
    
}
