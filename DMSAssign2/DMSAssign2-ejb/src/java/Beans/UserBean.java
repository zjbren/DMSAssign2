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
import java.util.ArrayList;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 * Bean used to add new users to DB Validates usernames and confirms does not
 * already exist
 *
 * @author Zach
 */
@Stateful
@LocalBean
public class UserBean {

    public void registerUser(String usrName, String pwd, String email) {

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
            sqlQuery = "INSERT INTO USERS(username, pwd, email) VALUES ('" + usrName + "','" + pwd + "','" + email + "')";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }
    }

    public ArrayList<String> getUserNames() {
        ArrayList<String> userNames = new ArrayList();

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
            // Select all users from db and return arraylist of usernames to be compared to
            sqlQuery = "SELECT * FROM USERS";
            rs = statement.executeQuery(sqlQuery);

            while (rs.next()) {
                userNames.add(rs.getString("username"));
            }

        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }
        return userNames;
    }

    public String getPwd(String userName) {
        String pwd = null;

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

            // Inserting a record in the dUser table in the DB
            sqlQuery = "Select pwd From USERS where userName = '" + userName + "'";
            rs = statement.executeQuery(sqlQuery);

            pwd = rs.getString("pwd");
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e.getMessage());
        }
        return pwd;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
