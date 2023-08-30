package com.example.examenfinal.controller;

import org.springframework.web.bind.annotation.*;
import com.example.examenfinal.entity.Offer;
import com.example.examenfinal.service.OfferService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private OfferService offerService;

    public OfferController(OfferService offerService) {
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

    @PutMapping("/{id}")
    public void updateOffer(@PathVariable int id, @RequestBody Offer offer) {
        offerService.updateOffer(offer);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable int id){
        offerService.deleteOffer(id);
    }
}
