package com.example.examenfinal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.examenfinal.entity.Offer;

import static sun.net.InetAddressCachePolicy.get;

@Repository
public class offerDAO implements OfferDAOInterface {
    private Connection connection;

    public offerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Offer insert(Offer offer) {
        String sql = "INSERT INTO offers (titre, description, entreprise, salary, city, remote, offer_domain)" +  "VALUES (?,?,?,?,?,?,?) RETURNING id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, offer.getTitre());
            preparedStatement.setString(2, offer.getDescription());
            preparedStatement.setString(3, offer.getEntreprise());
            preparedStatement.setBigDecimal(4, offer.getSalary());
            preparedStatement.setString(5, offer.getCity());
            preparedStatement.setBoolean(6,offer.isRemote());
            preparedStatement.setInt(7, offer.getDomainId());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                offer.setId(resultSet.getInt("id"));
                return offer;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Offer> getAll() throws SQLException {
        List<Offer> allOffers = new ArrayList<>();
        String sql = "SELECT * FROM offers";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Offer offer = convertToOffer(result);
                allOffers.add(offer);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw e;
        }
        return allOffers;
    }

    @Override
    public Offer getById(int id) {
        String sql = "SELECT * FROM offers WHERE ID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                return converToOffer(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Offer offer) {

    }

    @Override
    public void delete(int id) {

    }
}