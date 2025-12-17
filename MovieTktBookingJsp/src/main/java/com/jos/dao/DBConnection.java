package com.jos.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static String DB_URL = "jdbc:mysql://localhost:3306/movietktbooking";
    static String DB_USERNAME = "root";
    static String DB_PASSWORD = "root";

    public static Connection getConnection() throws Exception {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}