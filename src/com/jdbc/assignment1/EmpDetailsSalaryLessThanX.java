package com.jdbc.assignment1;

import java.sql.*;
import java.util.Scanner;

public class EmpDetailsSalaryLessThanX {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter salary : ");
        int salary= sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String cs="jdbc:mysql://localhost:3306/db1";
        try(Connection conn= DriverManager.getConnection(cs,"root","vikas123")) {
            PreparedStatement ps=conn.prepareStatement("select *from employee where salary<?");
            ps.setInt(1,salary);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println("Emp Id : "+rs.getInt("empID"));
                System.out.println("Emp name : "+rs.getString("Name"));
                System.out.println("Emp address : "+rs.getString("Address"));
                System.out.println("Emp salary : "+rs.getInt("salary"));
                System.out.println("=================================================");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
