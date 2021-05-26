package com.company;

import java.sql.*;

public class testare {
    private static Connection con = null;
    static {
        String jdbcURL = "jdbc:mysql://localhost:3306/sys";
        String username = "root";
        String password = "qweasd123";
        try {
            String url;
            String user;
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, username, password);
            if (con != null) {
                System.out.println("Am conectat baza de date!!");
            }
            Statement stmt = con.createStatement();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }
}


