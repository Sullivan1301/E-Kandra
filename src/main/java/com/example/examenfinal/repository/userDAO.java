package com.example.examenfinal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.examenfinal.entity.User;

@Repository
public class UserDAO implements UserDAOInterface {
    private Connection connection;

    public UserDAO(Connection connection) {
        System.out.println("Constructeur du repository exécuté par Spring");
        this.connection = connection;
    }

    @Override
    public User insert(User toInsert) {
        // Implémentation de l'insertion d'un utilisateur
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM \"user\"";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allUsers, result);
            }
        }
        return allUsers;
    }

    @Override
    public User getById(int id) {
        // Implémentation pour obtenir un utilisateur par son identifiant
        return null;
    }

    private void convertToList(List<User> allUsers, ResultSet result) throws SQLException {
        allUsers.add(new User(
                result.getInt("id_user"), result.getString("username"), result.getString("first_name"),
                result.getString("last_name"), result.getString("email"), result.getString("password"),
                result.getString("skills")));
    }
}
