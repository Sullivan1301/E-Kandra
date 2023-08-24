package com.example.examenfinal.repository;

import java.sql.SQLException;
import java.util.List;
import com.example.examenfinal.entity.Offer;

public interface OfferDAOInterface {
    Offer insert(Offer toInsert);
    List<Offer> getAll() throws SQLException;
    Offer getById(int id);
    void update(Offer offer);
    void delete(int id);
}