/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Markus
 */
public class DBConnection {
    private Connection DBConnection;
    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection success");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Connection fail: + " + cnfe);
        }
        String url = "jdbc:mysql://localhost/3306/projectlul";
        try {
            DBConnection = DriverManager.getConnection(url, "root", "");
            System.out.println("Database connected");
        }
        catch (SQLException se) {
            System.out.println("Database connection failed: " + se);
        }
        return DBConnection;
    }
    
}
