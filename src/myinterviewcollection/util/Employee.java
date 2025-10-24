/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myinterviewcollection.util;

/**
 *
 * @author saddam
 */
public class Employee {
    
    private int id;
    private String name;
    private String department;
    private double salary;
        
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.department + " " + this.salary;
    }
    
    // Rest of the Employee class code
    // Override equals and hashCode methods
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        Employee employee = (Employee) obj;
        return id == employee.id && 
               name.equals(employee.name) &&
               department.equals(employee.department) &&
               salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, department, salary);
    }
    
}
