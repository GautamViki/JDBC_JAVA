package com.jdbc.assignment1;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;

public class UpdateSalaryby500 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter bonus : ");
        int bonus= sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String cs="jdbc:mysql://localhost:3306/db1";

        try(Connection conn= DriverManager.getConnection(cs,"root","vikas123")) {
            PreparedStatement ps=conn.prepareStatement("update employee set salary=salary+?");
            ps.setInt(1,bonus);
            int x=ps.executeUpdate();
            if (x>0){
                System.out.println("updated.......");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
