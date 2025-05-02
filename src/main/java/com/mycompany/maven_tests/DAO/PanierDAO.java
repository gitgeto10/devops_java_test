/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests.dao;

import com.mycompany.maven_tests.model.Panier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PanierDAO {

    private final Connection connection;

    public PanierDAO(Connection connection) {
        this.connection = connection;
    }

    public int insert(Panier panier) throws SQLException {
    String sql = "INSERT INTO panier (n_article, client) VALUES (?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, panier.getArticle());
        stmt.setString(2, panier.getClient());
        stmt.executeUpdate();

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
    }
    return -1;
}
}
