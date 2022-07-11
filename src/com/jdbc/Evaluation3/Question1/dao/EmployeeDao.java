package com.jdbc.Evaluation3.Question1.dao;

import com.jdbc.Evaluation3.Question1.Exception.EmployeeException;
import com.jdbc.Evaluation3.Question1.masaiBeans.Employee;

import java.util.List;

public interface EmployeeDao {
    public  String saveEmployeeDetails(Employee employee);

    public  Employee getEmployeeByID(int empId) throws EmployeeException;

    public List<Employee> getAllEmployees();

    public String deleteEmployee(int empId)throws EmployeeException;
}
