package com.rabtech.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();

    private Set<String> departments = new HashSet<>();

    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employeeMap.put(employee.getId(), employee);
    }

    public void addEmployeeWithValidation(Employee employee)
            throws InvalidSalaryException {

        if (employee.getSalary() <= 0) {
            throw new InvalidSalaryException(
                    "Salary must be greater than zero"
            );
        }

        addEmployee(employee);
    }

    public void addDepartment(String department) {
        departments.add(department);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Set<String> getDepartments() {
        return departments;
    }

    public Map<Integer, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public int getEmployeeCount() {
        return employees.size();
    }

    public List<Employee> filterBySalary(double minimumSalary) {
        return employees.stream()
                .filter(employee -> employee.getSalary() >= minimumSalary)
                .collect(Collectors.toList());
    }

    public List<Employee> sortBySalary() {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public Employee findEmployeeById(int id) {

        if (id <= 0) {
            throw new InvalidEmployeeIdException(
                    "Employee ID must be greater than zero"
            );
        }

        return employeeMap.get(id);
    }
}