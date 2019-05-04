/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Zach
 */
@Stateless
@LocalBean
public class PostBean {

    public void createPost(String code, String status) {
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/ZACHBOOKDB;"
                + "create=true;user=db;password=db";
        try {
            // Creating SQL query string
            String sqlQuery;
            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            // Creating the SQL Statement
            Statement statement = connection.createStatement();

            // Inserting a record in the User table in the DB
            sqlQuery = "INSERT INTO POST(status_code, status) VALUES('" + code + "','" + status + "')";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }
    }
    
    public String getPost(String code) {
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/ZACHBOOKDB;"
                + "create=true;user=db;password=db";
        
        String status = "";
        
        try {
            // Creating SQL query string
            String sqlQuery;
            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            // Creating the SQL Statement
            Statement statement = connection.createStatement();   
            ResultSet rs;

            // Inserting a record in the User table in the DB
            sqlQuery = "SELECT status FROM POST where status_code = '" + code + "'";
            rs = statement.executeQuery(sqlQuery);
            
            if(rs.next())
            {
                status = rs.getString("status");
            }

        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }
        return status;
    }

    public boolean checkCode(String code) {
        Boolean exists = false;
        String driverURL = "org.apache.derby.jdbc.EmbeddedDriver";
        // The dbURL to contain the Database URL
        String dbURL = "jdbc:derby://localhost:1527/ZACHBOOKDB;"
                + "create=true;user=db;password=db";
        try {
            // Creating SQL query string
            String sqlQuery;
            ResultSet rs;

            // Step 1: Loading the drivers for JAVA DB
            Class.forName(driverURL);

            Connection connection = DriverManager.getConnection(dbURL);

            // Creating the SQL Statement
            Statement statement = connection.createStatement();

            // Inserting a record in the User table in the DB
            sqlQuery = "SELECT * FROM POST";
            rs = statement.executeQuery(sqlQuery);

            while (rs.next()) {
                if (rs.getString("status_code").equals(code)) {
                    exists = true;
                    break;
                }
            }

        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }
        return exists;
    }
}
