package com.jdbc.EmployeeApplication.usecases;

import com.jdbc.EmployeeApplication.dao.EmployeeDao;
import com.jdbc.EmployeeApplication.dao.EmployeeDaoImplementation;
import com.jdbc.EmployeeApplication.exceptions.EmployeeException;
import com.jdbc.EmployeeApplication.masaiBean.Employee;

import java.util.Scanner;

public class GetEmployeeByIDUseCase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter EmpID");
        int id= sc.nextInt();

        EmployeeDao dao=new EmployeeDaoImplementation();
        try {
            Employee emp=dao.getEmployeeByID(id);
            System.out.println("Emp ID : "+emp.getEid());
            System.out.println("Emp Name : "+emp.getName());
            System.out.println("Emp Address : "+emp.getAddress());
            System.out.println("Emp salary : "+emp.getSalary());
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
