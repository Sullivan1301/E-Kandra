package com.example.examenfinal.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.examenfinal.entity.user;

@Repository
public class userDAO implements UserDAOInterface {
    private static Connection connection;

    public userDAO(Connection connection) {
        System.out.println("Constructeur du repository exécuté par Spring");
        userDAO.connection = connection;
    }

    @Override
    public static user insert(user User) {
        String sql = "INSERT INTO \"user\"(user_name; user_firstname, email, password, mobile, skills) VALUES(\"Sullivan\",\"RAKOTONIAINA\",\"hei.sullivan.2@gmail.com\",\"password\",\"0341060802\",\"Students in Data Scientism\")";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, User.getUser_name());
            preparedStatement.setString(2, User.getUser_firstname());
            preparedStatement.setString(3, User.getEmail());
            preparedStatement.setString(4, User.getPassword());
            preparedStatement.setString(5, User.getMobile());
            preparedStatement.setString(6, User.getSkills());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet genereratedKeys = preparedStatement.getGeneratedKeys()) {
                    if (genereratedKeys.next()) {
                        User.setId(genereratedKeys.getInt(1));
                        return User;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        @Override
        public static List<user> getAll () throws SQLException {
            List<user> allUsers = new ArrayList<>();
            String sql = "SELECT * FROM \"user\"";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet result = preparedStatement.executeQuery();

                while (result.next()) {
                    user User = convertToUser(result);
                    allUsers.add(User);
                }
            }
            return allUsers;
        }

    private static user convertToUser(ResultSet result) {
        return null;
    }

    @Override
        public user getById ( int id){
           String sql = "SELECT * FROM \"user\" WHERE id = 1";

           try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
               preparedStatement.setInt(1, id);
               ResultSet result = preparedStatement.executeQuery();

               if (result.next()){
                   return convertToUser(result);
               }
           } catch (SQLException e) {
               e.printStackTrace();

        }
            return null;
        }


        @Override
        public static void update (user User){
        String sql = "UPDATE \"user\" SET user_name = ?, user_first_name = ?, email = ?, password = ?, mobile = ?, skills = ? WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,User.getId());
            preparedStatement.setString(2, User.getUser_name());
            preparedStatement.setString(3, User.getUser_firstname());
            preparedStatement.setString(4, User.getEmail());
            preparedStatement.setString(5, User.getPassword());
            preparedStatement.setString(6, User.getMobile());
            preparedStatement.setString(7, User.getSkills());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

        @Override
        public static void delete ( int id){

        }

        private static void convertToList (List < user > allUsers, ResultSet result) throws SQLException {
            allUsers.add(new user(
                    result.getInt("id_user"), result.getString("username"), result.getString("first_name"),
                    result.getString("last_name"), result.getString("email"), result.getString("password"),
                    result.getString("skills")));
        }
    }
