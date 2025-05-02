import java.sql.*;
import java.util.*;

public class BonLivraisonDAOImpl implements BonLivraisonDAO {
    private final String url = "jdbc:mysql://localhost:3306/db_tdevops";
    private final String user = "root";
    private final String password = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public List<BonLivraison> getAll() {
        List<BonLivraison> list = new ArrayList<>();
        String sql = "SELECT * FROM bonlivraison";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BonLivraison bl = new BonLivraison(
                    rs.getInt("id"),
                    rs.getString("status"),
                    rs.getDate("delivery_date")
                );
                list.add(bl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public BonLivraison getById(int id) {
        String sql = "SELECT * FROM bonlivraison WHERE id = ?";
        BonLivraison bl = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bl = new BonLivraison(id, rs.getString("status"), rs.getDate("delivery_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bl;
    }

    @Override
    public void insert(BonLivraison bl) {
        String sql = "INSERT INTO bonlivraison (id, status, delivery_date) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bl.getId());
            ps.setString(2, bl.getStatus());
            ps.setDate(3, bl.getDeliveryDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(BonLivraison bl) {
        String sql = "UPDATE bonlivraison SET status=?, delivery_date=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bl.getStatus());
            ps.setDate(2, bl.getDeliveryDate());
            ps.setInt(3, bl.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM bonlivraison WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
