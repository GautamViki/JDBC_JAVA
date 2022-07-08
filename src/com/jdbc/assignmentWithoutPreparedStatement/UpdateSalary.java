package com.jdbc.assignmentWithoutPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSalary {
    public static void main(String[] args) {
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
            int x=st.executeUpdate("update employee set salary=salary+500");
            if (x>0){
                System.out.println("updated........");
            }
            else {
                System.out.println("not updated...........");
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
