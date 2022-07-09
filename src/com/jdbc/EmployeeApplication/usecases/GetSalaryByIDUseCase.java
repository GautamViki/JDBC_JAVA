package com.jdbc.EmployeeApplication.usecases;

import com.jdbc.EmployeeApplication.dao.EmployeeDao;
import com.jdbc.EmployeeApplication.dao.EmployeeDaoImplementation;
import com.jdbc.EmployeeApplication.exceptions.EmployeeException;

import java.util.Scanner;

public class GetSalaryByIDUseCase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Id");
        int id= sc.nextInt();

        EmployeeDao dao=new EmployeeDaoImplementation();
        int salary= 0;
        try {
            salary = dao.getMarksByID(id);
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
        if (salary>0){
            System.out.println("Salary : "+salary);
        }
        else {
            System.out.println("Employee does not exist");
        }

    }
}
