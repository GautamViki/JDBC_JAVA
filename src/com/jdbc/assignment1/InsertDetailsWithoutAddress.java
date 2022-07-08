package com.jdbc.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDetailsWithoutAddress {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Id : ");
        int id= sc.nextInt();
        System.out.print("Enter Name : ");
        String name=sc.next();
        System.out.print("Enter salary : ");
        int salary= sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String cs="jdbc:mysql://localhost:3306/db1";
        try(Connection conn= DriverManager.getConnection(cs,"root","vikas123")) {
            PreparedStatement ps= conn.prepareStatement("insert into employee (empID,Name,salary) values (?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,salary);

            int x=ps.executeUpdate();
            if(x>0){
                System.out.println("inserted.........");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
