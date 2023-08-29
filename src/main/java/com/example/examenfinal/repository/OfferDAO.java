package com.example.examenfinal.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.examenfinal.entity.Offer;
import com.example.examenfinal.entity.Domain;
@Repository
public class OfferDAO implements OfferDAOInterface {
    private Connection connection;

    public OfferDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Offer insert(Offer offer) {
        String sql = "INSERT INTO offers (titre, description, entreprise, salary, city, remote, offer_domain) " +
                "VALUES (?,?,?,?,?,?,?) RETURNING id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, offer.getTitre());
            preparedStatement.setString(2, offer.getDescription());
            preparedStatement.setString(3, offer.getEntreprise());
            preparedStatement.setBigDecimal(4, offer.getSalary());
            preparedStatement.setString(5, offer.getCity());
            preparedStatement.setBoolean(6, offer.isRemote());
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
                Offer offer = convertToOffer(resultSet);
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
        String sql = "SELECT * FROM offers WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                return convertToOffer(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Offer offer) {
        String sql = "UPDATE offers SET titre =? , description=?, entreprise= ?, salary=?, city = ?, remote =?, offer_domain = ? WHERE id = ? " ;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, offer.getTitre());
            preparedStatement.setString(2, offer.getDescription());
            preparedStatement.setString(3, offer.getEntreprise());
            preparedStatement.setBigDecimal(4, offer.getSalary());
            preparedStatement.setString(5, offer.getCity());
            preparedStatement.setBoolean(6,offer.isRemote());
            preparedStatement.setInt(7, offer.getDomainId());
            preparedStatement.setInt(8,offer.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM offers WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private Offer convertToOffer(ResultSet result) throws SQLException{
        int id = result.getInt("id");
        String titre = result.getString("titre");
        String description = result.getString("description");
        String entreprise = result.getString("entreprise");
        BigDecimal salary = result.getBigDecimal("salary");
        String city = result.getString("city");
        boolean remote = result.getBoolean("remote");
        int domainId = result.getInt("domain");

        Domain domain = getDomainById(domainId);
        return new Offer(id, titre, description, entreprise, salary, city, remote, domainId);
    }

    private Domain getDomainById(int id){
        String sql = "SELECT * FROM domain WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()){
                return convertToDomain(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Domain convertToDomain(ResultSet result) throws SQLException{
        int domainId = result.getInt("id");
        String domainName = result.getString("name");

        return new Domain(domainId, domainName);
    }
}
