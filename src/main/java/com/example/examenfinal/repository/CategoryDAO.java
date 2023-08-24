package com.example.examenfinal.repository;

import com.example.examenfinal.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements CategoryDAOInterface{
    private Connection connection;

    public CategoryDAO(Connection connection){
        this.connection = connection;
    }
    @Override
    public Category insert(Category category) {
        String sql = "INSERT INTO category (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                category.setId(generatedKeys.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getAll() {
        List<Category> allCategories = new ArrayList<>();
        String sql = "SELECT * FROM category";

        try (PreparedStatement preparedStatement =connection.prepareStatement(sql)){
            ResultSet result= preparedStatement.executeQuery();

            while (result.next()){
                Category category = convertToCategory(result);
                allCategories.add(Category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allCategories;
    }

    @Override
    public Category getById(int id) {
        String sql = "SELECT * FROM category WHERe id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()){
                return convertToCategory(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Category convertToCategory(ResultSet result) throws SQLException{
        return new Category(
                result.getInt("id"),
                result.getString("name")
        );
    }
}
