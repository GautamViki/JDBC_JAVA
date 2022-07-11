package com.jdbc.EmployeeApplication.masaiBean;

public class Employee {
    private int eid;
    private String name;
    private String address;
    private int salary;

    public Employee(){

    }
    public Employee(int eid, String name, String address, int salary) {
        this.eid = eid;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public int getEid() {
        return eid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}