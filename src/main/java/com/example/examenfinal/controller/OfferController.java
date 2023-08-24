package com.example.examenfinal.controller;

//Pour les opérations CRUD sur les offres
import org.springframework.web.bind.annotation.*;
import com.example.examenfinal.entity.Offer;
import com.example.examenfinal.service.OfferService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private OfferService offerService;

    public OfferController(OfferService service) {
        this.offerService =  offerService;
    }

    @GetMapping
    public List<Offer> getAllOffers() throws SQLException {
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public Offer getOfferById(@PathVariable int id){
        return offerService.getOfferById(id);
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer){
        return offerService.createOffer(offer);
    }

    @PutMapping("/{if}")
    public void updateOffer(@PathVariable int id, @RequestBody Offer offer) {
        offerService.updateOffer(offer);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable int id, @RequestBody Offer offer){
        offerService.deleteOffer(id);
    }
}
