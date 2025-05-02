package com.mycompany.maven_tests.dao;

import com.mycompany.maven_tests.model.lignefacture;
import java.sql.*;

public class LigneFactureDAO {
    private Connection connection;

    public LigneFactureDAO(Connection connection) {
        this.connection = connection;
    }

    public int insert(lignefacture lf) throws SQLException {
        String sql = "INSERT INTO lignefacture (id_facture, id_article, quantity, sub_total) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, lf.getId_facture());
            stmt.setLong(2, lf.getId_article());
            stmt.setInt(3, lf.getQuantity());
            stmt.setDouble(4, lf.getSub_total());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        }
        return -1;
    }
}
