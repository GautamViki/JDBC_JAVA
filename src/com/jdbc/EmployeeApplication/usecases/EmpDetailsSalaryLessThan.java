package com.jdbc.EmployeeApplication.usecases;

import com.jdbc.EmployeeApplication.dao.EmployeeDao;
import com.jdbc.EmployeeApplication.dao.EmployeeDaoImplementation;
import com.jdbc.EmployeeApplication.exceptions.EmployeeException;
import com.jdbc.EmployeeApplication.masaiBean.Employee;

import java.util.List;
import java.util.Scanner;

public class EmpDetailsSalaryLessThan{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter salary : ");
        int salary=sc.nextInt();

        EmployeeDao dao=new EmployeeDaoImplementation();
        try {
            List<Employee>list=dao.getEmpDetailsSalaryLessThan(salary);
            list.forEach(s->{
                System.out.println();
                System.out.println("Emp id : "+s.getEid());
                System.out.println("Emp Name : "+s.getName());
                System.out.println("Emp Address : "+s.getAddress());
                System.out.println("Emp salary : "+s.getSalary());
                System.out.println("=====================================");
            });
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
