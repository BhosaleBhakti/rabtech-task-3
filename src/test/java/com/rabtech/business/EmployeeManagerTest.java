package com.rabtech.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {

    @Test
    void testAddEmployee() {

        EmployeeManager manager = new EmployeeManager();

        Employee employee = new Employee(1, "Rahul", 30000);

        manager.addEmployee(employee);

        assertEquals(1, manager.getEmployeeCount());
    }

    @Test
    void testFilterBySalary() {

        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee(1, "Rahul", 30000));
        manager.addEmployee(new Employee(2, "Amit", 50000));

        List<Employee> result = manager.filterBySalary(40000);

        assertEquals(1, result.size());
        assertEquals("Amit", result.get(0).getName());
    }

    @Test
    void testSortBySalary() {

        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee(1, "Rahul", 50000));
        manager.addEmployee(new Employee(2, "Amit", 30000));

        List<Employee> result = manager.sortBySalary();

        assertEquals("Amit", result.get(0).getName());
        assertEquals("Rahul", result.get(1).getName());
    }

    @Test
    void testInvalidSalaryException() {

        EmployeeManager manager = new EmployeeManager();

        Employee employee = new Employee(1, "Rahul", -5000);

        assertThrows(
                InvalidSalaryException.class,
                () -> manager.addEmployeeWithValidation(employee)
        );
    }

    @Test
    void testInvalidEmployeeIdException() {

        EmployeeManager manager = new EmployeeManager();

        assertThrows(
                InvalidEmployeeIdException.class,
                () -> manager.findEmployeeById(0)
        );
    }

    @Test
    void testEmployeeRecord() {

        EmployeeInfo employee = new EmployeeInfo(
                101,
                "Priya",
                "IT"
        );

        assertEquals(101, employee.id());
        assertEquals("Priya", employee.name());
        assertEquals("IT", employee.department());
    }

    @Test
    void testInheritanceAndPolymorphism() {

        Person employee = new Employee(
                1,
                "Rahul",
                30000
        );

        Person manager = new Manager(
                "Priya",
                5
        );

        assertEquals("Rahul", employee.getName());
        assertEquals("Priya", manager.getName());

        assertTrue(employee instanceof Employee);
        assertTrue(manager instanceof Manager);
    }
}