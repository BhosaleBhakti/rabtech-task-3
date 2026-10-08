package com.rabtech.business;

public class Manager extends Person {

    private int teamSize;

    public Manager(String name, int teamSize) {
        super(name);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public void showRole() {
        System.out.println("Role: Manager");
    }
}