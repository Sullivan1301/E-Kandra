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
        this.connection = connection;
    }

    @Override
    public user insert(user User) {
        String sql = "INSERT INTO \"user\"(user_name; user_firstname, email, password, mobile, skills) VALUES(\"Sullivan\",\"RAKOTONIAINA\",\"hei.sullivan.2@gmail.com\",\"password\",\"0341060802\",\"Students in Data Scientism\")";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, User.getUser_name());
            preparedStatement.setString(2, User.getUser_firstname());
            preparedStatement.setString(3, User.getEmail());
            preparedStatement.setString(4, User.getPassword());
            preparedStatement.setString(5, User.getMobile());
            preparedStatement.setString(6, User.getSkills());

           ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()){
               User.setId(resultSet.getInt("id"));
               return User;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        @Override
        public List<user> getAll () throws SQLException {
            List<user> allUsers = new ArrayList<>();
            String sql = "SELECT * FROM \"user\"";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet result = preparedStatement.executeQuery();

                while (result.next()) {
                    user User = convertToUser(result);
                    allUsers.add(User);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return allUsers;
        }

   @Override
   public user getById(int id){
        String sql = "SELECT * FROM \"user\" WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()){
                return convertToUser(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
   }

        @Override
        public  void update (user User) {
            String sql = "UPDATE \"user\" SET user_name = ?, user_first_name = ?, email = ?, password = ?, mobile = ?, skills = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, User.getId());
                preparedStatement.setString(2, User.getUser_name());
                preparedStatement.setString(3, User.getUser_firstname());
                preparedStatement.setString(4, User.getEmail());
                preparedStatement.setString(5, User.getPassword());
                preparedStatement.setString(6, User.getMobile());
                preparedStatement.setString(7, User.getSkills());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public  void delete ( int id) {
            String sql = "DELETE FROM \"user\" WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private user convertToUser (ResultSet result) throws SQLException {
            return new user(
                    result.getInt("id"),
                    result.getString("user_name"),
                    result.getString("user_firstname"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("mobile"),
                    result.getString("skills")
            );
        }
    }
