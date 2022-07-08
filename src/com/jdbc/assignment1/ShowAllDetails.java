package com.jdbc.assignment1;

import java.sql.*;

public class ShowAllDetails {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String cs="jdbc:mysql://localhost:3306/db1";
        try (Connection conn= DriverManager.getConnection(cs,"root","vikas123")){
            PreparedStatement ps=conn.prepareStatement("select *from employee");
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                System.out.println("Employee ID is : "+rs.getInt("empID"));
                System.out.println("Employee Name is : "+rs.getString("Name"));
                System.out.println("Employee Address  is : "+rs.getString("address"));
                System.out.println("Employee Salary is : "+rs.getInt("salary"));
                System.out.println("======================================================");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
