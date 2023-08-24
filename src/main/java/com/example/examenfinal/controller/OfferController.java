package com.example.examenfinal.controller;

//Pour les opérations CRUD sur les offres
import org.springframework.web.bind.annotation.*;
import com.example.examenfinal.entity.Offer;
import com.example.examenfinal.service.OfferService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class OfferController {
    private OfferService service;

    public OfferController(OfferService service) {
        this.service = service;
    }

    @GetMapping("/offers")
    public List<Offer> getAllOffers() throws SQLException {
        try {
            return service.getAllOffers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Ajoutez les autres méthodes pour créer, mettre à jour, supprimer des offres
}
