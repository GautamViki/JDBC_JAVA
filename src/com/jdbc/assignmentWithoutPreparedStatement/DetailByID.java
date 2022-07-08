package com.jdbc.assignmentWithoutPreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class DetailByID {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter ID : ");
        int id= sc.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String cs="jdbc:mysql://localhost:3306/db1";
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(cs,"root","vikas123");
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery("select *from employee where empID="+id);

     if (rs.next()){
                System.out.println();
                System.out.println("Emp ID : "+rs.getInt("empID"));
                System.out.println("Emp Name : "+rs.getString("Name"));
                System.out.println("Emp Address : "+rs.getString("Address"));
                System.out.println("Emp Salary : "+rs.getInt("Salary"));
                System.out.println("======================================");
            }
     else {
         System.out.println("Employee not available");
     }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                conn.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
