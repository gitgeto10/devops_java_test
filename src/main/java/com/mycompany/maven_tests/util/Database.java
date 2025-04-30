/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests.util;

/**
 *
 * @author dell
 */

import java.sql.*;

public class Database {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/devops_db";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}
