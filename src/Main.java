import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String cs="jdbc:mysql://localhost:3306/sb1";
        try {
            Connection con=DriverManager.getConnection(cs,"root","vikas123");
            Statement st=con.createStatement();
            int x= st.executeUpdate("insert into person values (125,'vikas','dsdgs')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}