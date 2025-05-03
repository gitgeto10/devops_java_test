/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dell
 */

import com.mycompany.maven_tests.model.LigneBonLivraison;
import com.mycompany.maven_tests.dao.LigneBonLivraisonDAO;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LigneBonLivraisonDAOTest {

    private LigneBonLivraisonDAO dao;

    @BeforeEach
    void setUp() {
        dao = new LigneBonLivraisonDAO();
    }

    @Test
    void testInsertAndGetById() {
        LigneBonLivraison ligne = new LigneBonLivraison();
        ligne.setIdBonLivraison(1); // suppose que ce bon de livraison existe
        ligne.setDesignation("Produit Test");
        ligne.setQuantity(10);

        int id = dao.insert(ligne);
        assertTrue(id > 0);

        LigneBonLivraison fetched = dao.getById(id);
        assertNotNull(fetched);
        assertEquals("Produit Test", fetched.getDesignation());
        assertEquals(10, fetched.getQuantity());
    }

    @Test
    void testGetAllByBonLivraisonId() {
        LigneBonLivraison ligne1 = new LigneBonLivraison();
        ligne1.setIdBonLivraison(1);
        ligne1.setDesignation("Produit A");
        ligne1.setQuantity(3);
        dao.insert(ligne1);

        LigneBonLivraison ligne2 = new LigneBonLivraison();
        ligne2.setIdBonLivraison(1);
        ligne2.setDesignation("Produit B");
        ligne2.setQuantity(7);
        dao.insert(ligne2);

        List<LigneBonLivraison> lignes = dao.getAllByBonLivraisonId(1);
        assertTrue(lignes.size() >= 2);
    }
}
