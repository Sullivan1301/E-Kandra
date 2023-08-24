package com.example.examenfinal.service;

import java.sql.SQLException;
import java.util.List;

import com.example.examenfinal.repository.OfferDAOInterface;
import org.springframework.stereotype.Service;
import com.example.examenfinal.entity.Offer;
import com.example.examenfinal.repository.OfferDAO;

@Service
public class OfferService {
    private OfferDAOInterface dao;

    public OfferService(OfferDAOInterface dao) {
        this.dao = dao;
    }

    public Offer createOffer(Offer offer){
        return dao.insert(offer);
    }

    public List<Offer> getAllOffers() throws SQLException {
        return dao.getAll();
    }

    public Offer getOfferById(int id){
        return dao.getById(id);
    }

    public void updateOffer(Offer offer){
        dao.update(offer);
    }

    public void deleteOffer(int id){
        dao.delete(id);
    }
}