import java.util.List;

public interface BonLivraisonDAO {
    List<BonLivraison> getAll();
    BonLivraison getById(int id);
    void insert(BonLivraison bl);
    void update(BonLivraison bl);
    void delete(int id);
}
