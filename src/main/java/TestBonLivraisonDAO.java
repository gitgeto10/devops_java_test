import java.sql.Date;

public class TestBonLivraisonDAO {
    public static void main(String[] args) {
        BonLivraisonDAO dao = new BonLivraisonDAOImpl();

        // Insert
        BonLivraison bl1 = new BonLivraison(12, "Delivered", Date.valueOf("2025-05-01"));
        dao.insert(bl1);

        // Update
        bl1.setStatus("Delayed");
        dao.update(bl1);

        // Get By ID
        BonLivraison blFromDB = dao.getById(1);
        System.out.println("Get by ID: " + blFromDB);

        // Get All
        System.out.println("All records:");
        for (BonLivraison bl : dao.getAll()) {
            System.out.println(bl);
        }

        // Delete
        dao.delete(1);
    }
}
