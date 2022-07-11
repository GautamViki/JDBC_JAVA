package com.jdbc.Evaluation3.Question1.usesCases;

import com.jdbc.Evaluation3.Question1.Exception.EmployeeException;
import com.jdbc.Evaluation3.Question1.dao.EmployeeDao;
import com.jdbc.Evaluation3.Question1.dao.EmployeeDaoImplementation;
import com.jdbc.Evaluation3.Question1.masaiBeans.Employee;

import java.util.Scanner;

public class EmployeeByID {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter EmpID");
        int id= sc.nextInt();

        EmployeeDao dao=new EmployeeDaoImplementation();
        try {
            Employee emp=dao.getEmployeeByID(id);
            System.out.println("Emp ID : "+emp.getEmpId());
            System.out.println("Emp Name : "+emp.getName());
            System.out.println("Emp Address : "+emp.getAddress());
            System.out.println("Emp salary : "+emp.getSalary());
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
