package com.jdbc.Evaluation3.Question1.usesCases;

import com.jdbc.Evaluation3.Question1.Exception.EmployeeException;
import com.jdbc.Evaluation3.Question1.dao.EmployeeDao;
import com.jdbc.Evaluation3.Question1.dao.EmployeeDaoImplementation;

import java.util.Scanner;

public class DeleteByID {
    public static void main(String[] args) throws EmployeeException {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter id");
        int id= sc.nextInt();

        EmployeeDao dao=new EmployeeDaoImplementation();
        String message= dao.deleteEmployee(id);
        System.out.println(message);
    }
}
