/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc
 */
package com.mycompany.maven_tests;

import com.mycompany.maven_tests.dao.PanierDAO;
import com.mycompany.maven_tests.model.Panier;
import com.mycompany.maven_tests.util.Database;
import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class PanierDAOTest {

    private Connection connection;
    private PanierDAO panierDAO;

    @BeforeEach
    public void setUp() throws Exception {
        // Créer une connexion avant chaque test
        connection = Database.getConnection();
        panierDAO = new PanierDAO(connection);
    }

    @Test
    public void testInsertPanier() throws Exception {
        // Créer un objet Panier sans ID, la BDD auto-incrémentera l'ID
        Panier panier = new Panier(0, "ART001", "ASMAA");

        // Insérer l'objet Panier dans la base de données
        int result = panierDAO.insert(panier);

        // L'insertion doit réussir, l'ID retourné doit être supérieur à 0
        assertTrue(result > 0, "L'ID retourné doit être supérieur à 0");

        // Vérifier que l'insertion a bien eu lieu dans la base de données
        String query = "SELECT * FROM panier WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, result);
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next(), "Le panier inséré doit être présent dans la base de données");

            // Vérifier les valeurs de la ligne insérée
            assertEquals("ART001", rs.getString("n_article"));
            assertEquals("ASMAA", rs.getString("client"));
        }
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Nettoyage après chaque test : fermer la connexion
        if (connection != null) connection.close();
    }
}

