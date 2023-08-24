package com.example.examenfinal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.examenfinal.entity.Offer;

@Repository
public class offerDAO implements OfferDAOInterface {
    private Connection connection;

    public offerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Offer insert(Offer toInsert) {
        // Implémentation de l'insertion d'une offre
        return null;
    }

    @Override
    public List<Offer> getAll() throws SQLException {
        // Implémentation de la récupération de toutes les offres
        return null;
    }

    @Override
    public Offer getById(int id) {
        // Implémentation pour obtenir une offre par son identifiant
        return null;
    }

    private void convertToList(List<Offer> allOffers, ResultSet result) throws SQLException {
        // Convertir le résultat en liste d'offres
    }
}