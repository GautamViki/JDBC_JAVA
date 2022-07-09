package com.jdbc.EmployeeApplication.usecases;

import com.jdbc.EmployeeApplication.dao.EmployeeDao;
import com.jdbc.EmployeeApplication.dao.EmployeeDaoImplementation;
import com.jdbc.EmployeeApplication.masaiBean.Employee;

import java.util.Scanner;

public class InsertWithoutAddress {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Emp id");
        int id= sc.nextInt();
        System.out.println("Emp name");
        String name=sc.next();
        System.out.println("Emp salary");
        int salary=sc.nextInt();

        EmployeeDao dao=new EmployeeDaoImplementation();
        Employee emp=new Employee();
        emp.setEid(id);
        emp.setName(name);
        emp.setSalary(salary);

        String message=dao.insertEmpDetailsWithoutAddress(emp);
        System.out.println(message);
    }
}
