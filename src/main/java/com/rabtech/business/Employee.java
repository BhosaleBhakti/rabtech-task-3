package com.rabtech.business;

public class Employee extends Person {

    private int id;
    private double salary;

    public Employee(int id, String name, double salary) {
        super(name);
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void showRole() {
        System.out.println("Role: Employee");
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + salary);
    }
}