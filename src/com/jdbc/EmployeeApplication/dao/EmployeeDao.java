package com.jdbc.EmployeeApplication.dao;

import com.jdbc.EmployeeApplication.exceptions.EmployeeException;
import com.jdbc.EmployeeApplication.masaiBean.Employee;

import java.util.List;

public interface EmployeeDao {
    public String insertEmployeeDetails(int eid,String name,String address,int salary);
    public  String insertEmployeeDetails2(Employee employee);

    public int getMarksByID(int eid) throws EmployeeException;

    public Employee getEmployeeByID(int eid) throws EmployeeException;

    public List<Employee>  getAllEmployeeDetails() throws EmployeeException;

    public List<Employee> getEmpDetailsSalaryLessThan(int salary) throws EmployeeException;

    public String insertEmpDetailsWithoutAddress(Employee employee);

    public String UpdateSalaryBy(int bonus) throws EmployeeException;
}
