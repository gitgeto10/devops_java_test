/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests.dao;

import com.mycompany.maven_tests.model.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yassin
 */
public class ArticleDAO {
    private Connection connection;

    public ArticleDAO(Connection connection) {
        this.connection = connection;
    }

    public int insert(Article article) throws SQLException {
        if (article.getPrixUnitaire() <= 0 || article.getQte() <= 0) {
            throw new IllegalArgumentException("Prix unitaire et quantité doivent être > 0");
        }
        String sql = "INSERT INTO article (ref, nom, prixUnitaire, qte) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, article.getRef());
            stmt.setString(2, article.getNom());
            stmt.setDouble(3, article.getPrixUnitaire());
            stmt.setInt(4, article.getQte());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Inserting article failed, no rows affected.");
            }

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                } else {
                    throw new SQLException("Inserting article failed, no ID obtained.");
                }
            }
        }
    }

    public Article findById(int id) throws SQLException {
        String sql = "SELECT * FROM article WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Article article = new Article();
                    article.setId(rs.getInt("id"));
                    article.setRef(rs.getString("ref"));
                    article.setNom(rs.getString("nom"));
                    article.setPrixUnitaire(rs.getDouble("prixUnitaire"));
                    article.setQte(rs.getInt("qte"));
                    return article;
                }
            }
        }
        return null;
    }
}