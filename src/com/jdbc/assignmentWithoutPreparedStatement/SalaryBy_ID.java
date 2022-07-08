package com.jdbc.assignmentWithoutPreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class SalaryBy_ID {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Emp ID ");
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
            Statement st=conn.createStatement();
            ResultSet rs= st.executeQuery("select *from employee where empId="+id);
            if (rs.next()){
                System.out.println("Salary : "+rs.getInt("salary"));
            }else {
                System.out.println("Employee is not Available");
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
