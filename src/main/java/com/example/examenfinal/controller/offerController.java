Pour les opérations CRUD sur les offres
import org.springframework.web.bind.annotation.*;
import com.example.examenfinal.entity.Offer;
import com.example.examenfinal.service.OfferService;

@RestController
public class OfferController {
    private OfferService service;

    public OfferController(OfferService service) {
        this.service = service;
    }

    @GetMapping("/offers")
    public List<Offer> getAllOffers() throws SQLException {
        return service.getAllOffers();
    }

    // Ajoutez les autres méthodes pour créer, mettre à jour, supprimer des offres
}
