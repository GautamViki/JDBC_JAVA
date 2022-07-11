package com.jdbc.Evaluation3.Question1.dao;
import com.jdbc.Evaluation3.Question1.Exception.EmployeeException;
import com.jdbc.Evaluation3.Question1.Utility.DBUtility;
import com.jdbc.Evaluation3.Question1.masaiBeans.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplementation  implements EmployeeDao{

    @Override
    public String saveEmployeeDetails(Employee employee) {
        String message="not saved";

        try(Connection conn= DBUtility.provideConnection()){
            PreparedStatement ps=conn.prepareStatement("insert into employee values(?,?,?,?)");
            ps.setInt(1, employee.getEmpId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getAddress());
            ps.setInt(4, employee.getSalary());
            int x=ps.executeUpdate();

            if (x>0){
                message="saved.....";
            }
        }catch (SQLException e){
            message=e.getMessage();
        }
        return message;
    }

    @Override
    public Employee getEmployeeByID(int empId) throws EmployeeException {
        Employee emp = null;
        try (Connection conn = DBUtility.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select *from employee where empid=?");
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("empid");
                String name = rs.getString("name");
                String address = rs.getString("Address");
                int salary = rs.getInt("salary");
                emp = new Employee(id, name, address, salary);
            } else {
                throw new EmployeeException("Employee does not exist");
            }
        } catch (SQLException e) {
            throw new EmployeeException(e.getMessage());
        }
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list=new ArrayList<>();

        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps= conn.prepareStatement("select *from employee");
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                int id=rs.getInt("empid");
                String name=rs.getString("name");
                String address=rs.getString("address");
                int salary=rs.getInt("salary");

                Employee emp=new Employee(id,name,address,salary);
                list.add(emp);
            }
            if (list.size()<=0){
//                throw new EmployeeException("No Employee In the Table ");
                System.out.println("No Employee In the Table ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public String deleteEmployee(int empId) throws EmployeeException {
        String message="not deleted";
        try(Connection conn=DBUtility.provideConnection()) {
            PreparedStatement ps= conn.prepareStatement("delete from employee where empid=?");
            ps.setInt(1,empId);
            int x= ps.executeUpdate();
            if (x>=0){
                message="deleted...";
            }
        } catch (SQLException e) {
            throw new EmployeeException("record not found");
        }


        return message;
    }
}
