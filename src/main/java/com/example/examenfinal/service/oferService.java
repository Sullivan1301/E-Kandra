import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.examenfinal.entity.Offer;
import com.example.examenfinal.repository.OfferDAO;

@Service
public class OfferService {
    private OfferDAO dao;

    public OfferService(OfferDAO dao) {
        this.dao = dao;
    }

    public List<Offer> getAllOffers() throws SQLException {
        return dao.getAll();
    }

    // Implémentez les autres méthodes de service pour créer, mettre à jour, supprimer des offres
}