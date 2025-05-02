/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import com.mycompany.maven_tests.dao.LigneFactureDAO;
import com.mycompany.maven_tests.model.lignefacture;
import com.mycompany.maven_tests.util.Database;
import org.junit.jupiter.api.*;

import java.sql.Connection;

public class LigneFactureDAOTest {

    private Connection connection;
    private LigneFactureDAO lignefactureDAO;

    @BeforeEach
    public void setUp() throws Exception {
        connection = Database.getConnection();
        lignefactureDAO = new LigneFactureDAO(connection);
    }

    @Test
    public void testInsertLigneFacture() throws Exception {
        lignefacture lf = new lignefacture(1, 1, 3, 300.0);  
        int id = lignefactureDAO.insert(lf);
        Assertions.assertTrue(id > 0, "Insert ID should be greater than 0");
    }
    

    @AfterEach
    public void tearDown() throws Exception {
        if (connection != null) connection.close();
    }
}
