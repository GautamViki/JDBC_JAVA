package com.jdbc.EmployeeApplication.usecases;

import com.jdbc.EmployeeApplication.dao.EmployeeDao;
import com.jdbc.EmployeeApplication.dao.EmployeeDaoImplementation;
import com.jdbc.EmployeeApplication.exceptions.EmployeeException;
import com.jdbc.EmployeeApplication.masaiBean.Employee;

import java.util.Iterator;
import java.util.List;

public class EmployeeDetailsUseCase {
    public static void main(String[] args) {
        EmployeeDao dao=new EmployeeDaoImplementation();
        try {
            List<Employee>list=dao.getAllEmployeeDetails();
            list.forEach(s->{
                System.out.println();
                System.out.println("Emp ID : "+s.getEid());
                System.out.println("Emp Name : "+s.getName());
                System.out.println("Emp Address : "+s.getAddress());
                System.out.println("Emp salary : "+s.getSalary());
                System.out.println("=================================================");
            });
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
