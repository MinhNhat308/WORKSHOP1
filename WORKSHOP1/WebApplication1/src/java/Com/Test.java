/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com;

/**
 *
 * @author ASUS
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=AutomobileDB;integratedSecurity=true";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(jdbcURL);
            
            if (connection != null) {
                System.out.println("Database connected successfully.");
                
                String sql = "SELECT * FROM CARS";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("CarID") + " - " + 
                                       resultSet.getString("CarName") + " - " + 
                                       resultSet.getString("Manufacturer"));
                }
            } else {
                System.out.println("Failed to connect database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
