/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests.dao;

/**
 *
 * @author dell
 */

import com.mycompany.maven_tests.model.LigneBonLivraison;
import com.mycompany.maven_tests.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LigneBonLivraisonDAO {

    public int insert(LigneBonLivraison ligne) {
        String sql = "INSERT INTO lignebonlivraison (id_bonlivraison, designation, quantity) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, ligne.getIdBonLivraison());
            stmt.setString(2, ligne.getDesignation());
            stmt.setInt(3, ligne.getQuantity());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public LigneBonLivraison getById(int id) {
        String sql = "SELECT * FROM lignebonlivraison WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                LigneBonLivraison ligne = new LigneBonLivraison();
                ligne.setId(rs.getInt("id"));
                ligne.setIdBonLivraison(rs.getInt("id_bonlivraison"));
                ligne.setDesignation(rs.getString("designation"));
                ligne.setQuantity(rs.getInt("quantity"));
                return ligne;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<LigneBonLivraison> getAllByBonLivraisonId(int idBonLivraison) {
        List<LigneBonLivraison> list = new ArrayList<>();
        String sql = "SELECT * FROM lignebonlivraison WHERE id_bonlivraison = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idBonLivraison);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LigneBonLivraison ligne = new LigneBonLivraison();
                ligne.setId(rs.getInt("id"));
                ligne.setIdBonLivraison(rs.getInt("id_bonlivraison"));
                ligne.setDesignation(rs.getString("designation"));
                ligne.setQuantity(rs.getInt("quantity"));
                list.add(ligne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
