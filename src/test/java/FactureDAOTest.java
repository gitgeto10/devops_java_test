/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import com.mycompany.maven_tests.dao.FactureDAO;
import com.mycompany.maven_tests.model.Facture;
import com.mycompany.maven_tests.util.Database;
import org.junit.jupiter.api.*;

import java.sql.Connection;

public class FactureDAOTest {

    private Connection connection;
    private FactureDAO factureDAO;

    @BeforeEach
    public void setUp() throws Exception {
        connection = Database.getConnection();
        factureDAO = new FactureDAO(connection);
    }

    @Test
    public void testInsertFacture() throws Exception {
        Facture facture = new Facture(1, 100.00);
        int id = factureDAO.insert(facture);
        Assertions.assertTrue(id > 0, "Insert ID should be greater than 0");
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (connection != null) connection.close();
    }
}
