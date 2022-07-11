package com.jdbc.Evaluation3.Question1.usesCases;

import com.jdbc.Evaluation3.Question1.dao.EmployeeDao;
import com.jdbc.Evaluation3.Question1.dao.EmployeeDaoImplementation;
import com.jdbc.Evaluation3.Question1.masaiBeans.Employee;

import java.util.List;

public class GetAllEmployee {
    public static void main(String[] args) {
        EmployeeDao dao=new EmployeeDaoImplementation();
        try {
            List<Employee> list=dao.getAllEmployees();
            list.forEach(s->{
                System.out.println();
                System.out.println("Emp ID : "+s.getEmpId());
                System.out.println("Emp Name : "+s.getName());
                System.out.println("Emp Address : "+s.getAddress());
                System.out.println("Emp salary : "+s.getSalary());
                System.out.println("=================================================");
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
