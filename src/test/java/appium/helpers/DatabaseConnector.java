package appium.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnector {
    private void connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql:dkjtks", "user", "password");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from employees");

            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
