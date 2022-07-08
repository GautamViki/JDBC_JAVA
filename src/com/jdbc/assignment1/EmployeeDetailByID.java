package com.jdbc.assignment1;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDetailByID {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id : ");
        int id= sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String cs="jdbc:mysql://localhost:3306/db1";
        try(Connection conn= DriverManager.getConnection(cs,"root","vikas123")) {
            PreparedStatement ps=conn.prepareStatement("select * from employee where empid=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                System.out.println("Employee id : "+rs.getInt("empId"));
                System.out.println("Employee Name : "+rs.getString("name"));
                System.out.println("Employee Address : "+rs.getString("Address"));
                System.out.println("Employee salary : "+rs.getInt("salary"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
