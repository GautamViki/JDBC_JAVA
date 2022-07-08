package com.jdbc.assignment1;

import java.sql.*;
import java.util.Scanner;

public class SalaryByID {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter id : ");
        int id= sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String cs="jdbc:mysql://localhost:3306/db1";

        try(Connection conn= DriverManager.getConnection(cs,"root","vikas123")) {
            PreparedStatement ps= conn.prepareStatement("select salary from employee where empID=?");
            ps.setInt(1,id);
            ResultSet resultSet=ps.executeQuery();
            if (resultSet.next()){
                System.out.println("Salary is : "+resultSet.getInt("salary"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } ;
    }
}
