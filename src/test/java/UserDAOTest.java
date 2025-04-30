/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dell
 */
import com.mycompany.maven_tests.model.User;
import com.mycompany.maven_tests.util.Database;
import  com.mycompany.maven_tests.dao.UserDAO;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.List;

public class UserDAOTest {

    private Connection connection;
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() throws Exception {
        connection = Database.getConnection();
        userDAO = new UserDAO(connection);
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> users = userDAO.findAll();
        Assertions.assertNotNull(users);
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (connection != null) connection.close();
    }
}
