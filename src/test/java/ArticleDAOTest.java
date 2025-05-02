/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yassin
 */



import com.mycompany.maven_tests.dao.ArticleDAO;
import com.mycompany.maven_tests.model.Article;
import com.mycompany.maven_tests.util.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;
public class ArticleDAOTest {
    private Connection connection;
    private ArticleDAO articleDAO;

    @BeforeEach
    public void setUp() {
        try {
            System.out.println("Attempting to initialize ArticleDAO...");
            connection = Database.getConnection();
       
          
            articleDAO = new ArticleDAO(connection);
            System.out.println("ArticleDAO initialized successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to initialize ArticleDAO: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Setup failed: " + e.getMessage(), e);
        }
    }

    @AfterEach
    public void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close connection: " + e.getMessage());
            }
        }
    }

    @Test
    public void testArticle() throws SQLException {
        System.out.println("Running testArticle...");

        // Test valid article (prixUnitaire > 0, qte > 0)
        Article validArticle = new Article("ART111", "Produit AB", 130.0, 15);
        int id = articleDAO.insert(validArticle);
        Article foundArticle = articleDAO.findById(id);
        assertNotNull(foundArticle, "Article with valid prixUnitaire and qte should be found in the database");
        assertEquals("ART111", foundArticle.getRef(), "Reference should match");
        assertEquals("Produit AB", foundArticle.getNom(), "Name should match");
        assertEquals(130.0, foundArticle.getPrixUnitaire(), 0.001, "Prix unitaire should match");
        assertEquals(15, foundArticle.getQte(), "Quantité should match");

        // Test invalid prixUnitaire (≤ 0)
        Article invalidPrixArticle = new Article("ART002", "Produit B", 0.0, 5);
        assertThrows(IllegalArgumentException.class, () -> {
            articleDAO.insert(invalidPrixArticle);
        }, "Should throw exception for invalid prixUnitaire");

        // Test invalid qte (≤ 0)
        Article invalidQteArticle = new Article("ART003", "Produit C", 150.0, 0);
        assertThrows(IllegalArgumentException.class, () -> {
            articleDAO.insert(invalidQteArticle);
        }, "Should throw exception for invalid qte");
    }
}