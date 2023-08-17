package com.example.examenfinal.repository;

import com.example.examenfinal.entity.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDAO implements userDAOInterface{
    private Connection connection;

    public userDAO(Connection connection){
        System.out.println('Constructeur du repository execute par Spring');
        this.connection = connection;
    }

    @Override
    public user insert(user to) {
        return null;
    }

    @Override
    public List<user> getAll() throws SQLException{
        List<user> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM \"user\"";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                convertToList(allUsers, result);
            }
        }
        return allUsers;
    }

    @Override
    public user insert(user toInsert) {
        return null;
    }

    private void convertToList(List<user> allUsers, ResultSet result) throws SQLException{
        allUsers.add(new user(
                result.getInt("id_user"), result.getString("username"), result.getString("first_name"), result.getString("last_name"), result.getString("email"), result.getString("password"), result.getString("skills")));
    }

    @Override
    public user getById(int id){
        return null;
    }
}
