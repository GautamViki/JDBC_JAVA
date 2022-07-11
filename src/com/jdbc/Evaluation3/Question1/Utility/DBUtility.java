package com.jdbc.Evaluation3.Question1.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
    public static Connection provideConnection(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String cs="jdbc:mysql://localhost:3306/db1";
        try {
            conn= DriverManager.getConnection(cs,"root","vikas123");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
