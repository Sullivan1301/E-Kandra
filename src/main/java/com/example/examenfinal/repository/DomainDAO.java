package com.example.examenfinal.repository;

import com.example.examenfinal.entity.Domain;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DomainDAO implements DomainDAOInterface{
    private Connection connection;

    public DomainDAO(Connection connection){
        this.connection = connection;
    }
    @Override
    public Domain insert(Domain domain) {
        String sql= "INSERT INTO domain (name) VALUES (?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, domain.getName());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                domain.setId(generatedKeys.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return domain;
    }

    @Override
    public List<Domain> getAll() {
        List<Domain> allDomains = new ArrayList<>();
        String sql = "SELECT * FROM domain";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                Domain domain = convertToDomain(result);
                allDomains.add(domain);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return allDomains;
    }

    @Override
    public Domain getById(int id) {
        String sql = "SELECT * FROM domain WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()){
                return convertToDomain(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Domain convertToDomain(ResultSet resultSet) throws SQLException{
        return new Domain(
                resultSet.getInt("id"),
                resultSet.getString("name")
        );
    }
}
