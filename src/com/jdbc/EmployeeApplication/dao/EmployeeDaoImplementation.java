package com.jdbc.EmployeeApplication.dao;

import com.jdbc.EmployeeApplication.Utility.DBUtility;
import com.jdbc.EmployeeApplication.exceptions.EmployeeException;
import com.jdbc.EmployeeApplication.masaiBean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplementation implements EmployeeDao{
    @Override
    public String insertEmployeeDetails(int eid, String name, String address, int salary) {
        String message="not inserted";

        try(Connection conn= DBUtility.provideConnection()){
            PreparedStatement ps= conn.prepareStatement("insert into employee3 values (?,?,?,?)");
            ps.setInt(1,eid);
            ps.setString(2,name);
            ps.setString(3,address);
            ps.setInt(4,salary);

            int x=ps.executeUpdate();
            if (x>0){
                message="inserted.......";
            }
        } catch (SQLException e) {
            message=e.getMessage();
        }
        return message;
    }

    @Override
    public String insertEmployeeDetails2(Employee employee) {
        String message ="not inserted.......";
        try(Connection conn=DBUtility.provideConnection()){
            PreparedStatement ps=conn.prepareStatement("insert into employee3 values(?,?,?,?)");
            ps.setInt(1, employee.getEid());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getAddress());
            ps.setInt(4, employee.getSalary());
            int x=ps.executeUpdate();

            if (x>0){
                message="inserted.....";
            }
        }catch (SQLException e){
            message=e.getMessage();
        }
        return message;
    }

    @Override
    public int getMarksByID(int eid) throws EmployeeException {
        int marks=-1;

        try(Connection conn=DBUtility.provideConnection()){
            PreparedStatement ps=conn.prepareStatement("select salary from employee3 where eid=?");
            ps.setInt(1,eid);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                marks=rs.getInt("salary");
            }else {
                throw new EmployeeException("Employee does not exist with the eid : "+eid);
            }
        } catch (SQLException e) {
//            System.out.println(e.getMessage());
            throw new EmployeeException(e.getMessage());
        }
        return marks;
    }

    @Override
    public Employee getEmployeeByID(int eid) throws EmployeeException {
        Employee emp=null;
        try (Connection conn= DBUtility.provideConnection()){
            PreparedStatement ps=conn.prepareStatement("select *from employee3 where eid=?");
            ps.setInt(1,eid);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                int id=rs.getInt("eid");
                String name=rs.getString("name");
                String address=rs.getString("Address");
                int salary=rs.getInt("salary");
                emp=new Employee(id,name,address,salary);
            }else {
                throw new EmployeeException("Employee does not exist");
            }
        } catch (SQLException e) {
            throw new EmployeeException(e.getMessage());
        }
        return emp;
    }

    @Override
    public List<Employee> getAllEmployeeDetails()throws EmployeeException {
        List<Employee> list=new ArrayList<>();

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps= conn.prepareStatement("select *from employee3");
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                int id=rs.getInt("eid");
                String name=rs.getString("name");
                String address=rs.getString("address");
                int salary=rs.getInt("salary");

                Employee emp=new Employee(id,name,address,salary);
                list.add(emp);
            }
            if (list.size()<=0){
                throw new EmployeeException("No Employee In the Table ");
            }
        } catch (SQLException e) {
            throw new EmployeeException(e.getMessage());
        }

        return list;
    }

    @Override
    public List<Employee> getEmpDetailsSalaryLessThan(int salary) throws EmployeeException {
        List<Employee>list=new ArrayList<>();
        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("select *from Employee3 where salary<?");
            ps.setInt(1,salary);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt("eid");
                String name=rs.getString("name");
                String address=rs.getString("address");
                int sal=rs.getInt("salary");
                Employee emp=new Employee(id,name,address,sal);
                list.add(emp);
            }
            if(list.size()<=0){
                throw new EmployeeException("No employee found");
            }
        } catch (SQLException e) {
            throw new EmployeeException(e.getMessage());
        }
        return list;
    }

    @Override
    public String insertEmpDetailsWithoutAddress(Employee employee) {
        String message="not inserted";

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps= conn.prepareStatement("insert into employee3 (eid,name,salary) values(?,?,?)");
            ps.setInt(1,employee.getEid());
            ps.setString(2,employee.getName());
            ps.setInt(3,employee.getSalary());

            int x=ps.executeUpdate();
           if(x>0){
               message="data inserted......";
           }
        } catch (SQLException e) {
            message=e.getMessage();
        }
        return message;
    }

    @Override
    public String UpdateSalaryBy(int bonus)  {
        String message="not updated....";

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps= conn.prepareStatement("update employee3 set salary=salary+?");
            ps.setInt(1,bonus);
            int x=ps.executeUpdate();
            if (x>0){
                message="salary updated.......";
            }

        } catch (SQLException e) {
            message=e.getMessage();
        }
        return message;
    }
}
