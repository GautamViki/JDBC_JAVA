package com.jdbc.Evaluation3.Question1.usesCases;

import com.jdbc.Evaluation3.Question1.dao.EmployeeDao;
import com.jdbc.Evaluation3.Question1.dao.EmployeeDaoImplementation;
import com.jdbc.Evaluation3.Question1.masaiBeans.Employee;

import java.util.Scanner;

public class InsertDetails {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter E_ID : ");
        int eid=sc.nextInt();
        System.out.println("Enter Name : ");
        String name= sc.next();
        System.out.println("Enter Address : ");
        String address=sc.next();
        System.out.println("Enter salary : ");
        int salary=sc.nextInt();

//        EmployeeDaoImplementation dao=new EmployeeDaoImplementation();
        EmployeeDao dao=new EmployeeDaoImplementation();
//       String message= dao.insertEmployeeDetails(eid,name,address,salary);
        Employee employee =new Employee(eid,name,address,salary);
        String message=dao.saveEmployeeDetails(employee);
        System.out.println(message);
    }
}
