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
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

public class PanierDAOTest {

    private Connection connection;
    private PanierDAO panierDAO;

    @BeforeEach
    public void setUp() throws Exception {
        connection = Database.getConnection();
        panierDAO = new PanierDAO(connection);
    }

    @Test
    public void testInsertPanier() throws Exception {
        // Ne pas spécifier l'ID (laisser la BDD l'auto-incrémenter)
        Panier panier = new Panier(0, "ART001", "ASMAA"); // ou simplement créer un constructeur sans id

        int result = panierDAO.insert(panier);

        // L'insertion doit réussir
        assertTrue(result > 0, "L'ID retourné doit être supérieur à 0");
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (connection != null) connection.close();
    }
}

