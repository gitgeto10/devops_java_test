/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_tests;

/**
 *
 * @author pc
 */
import com.mycompany.maven_tests.util.Database;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    private Connection connection;

    @BeforeEach
    public void setUp() throws SQLException {
        // Supposons que Database.getConnection() retourne une connexion valide à la DB
        connection = Database.getConnection();
    }

    @Test
    public void testConnection() throws SQLException {
        // Vérifie que la connexion n'est pas null et est valide
        assertNotNull(connection, "La connexion à la base de données ne doit pas être nulle");
        assertTrue(connection.isValid(2), "La connexion doit être valide");
    }

    @Test
    public void testCloseConnection() throws SQLException {
        // Ferme la connexion et vérifie qu'elle est fermée
        connection.close();
        assertTrue(connection.isClosed(), "La connexion doit être fermée");
    }

    @AfterEach
    public void tearDown() throws SQLException {
        // Ferme la connexion après chaque test
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

