package com.jdbc.EmployeeApplication.usecases;

import com.jdbc.EmployeeApplication.dao.EmployeeDao;
import com.jdbc.EmployeeApplication.dao.EmployeeDaoImplementation;
import com.jdbc.EmployeeApplication.exceptions.EmployeeException;

import java.util.Scanner;

public class UpdateSalaryByBonus {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter bonus");
        int bonus=sc.nextInt();

        EmployeeDao dao=new EmployeeDaoImplementation();
        try {
            String message=dao.UpdateSalaryBy(bonus);
            System.out.println(message);
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
