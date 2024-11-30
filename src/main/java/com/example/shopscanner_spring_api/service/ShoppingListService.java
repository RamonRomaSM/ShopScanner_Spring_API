package com.example.shopscanner_spring_api.service;

import com.example.shopscanner_spring_api.api.model.ShoppingList;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Service
public class ShoppingListService {
    Connection connection;
    Properties properties;

    public ShoppingListService (){

        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream("ConnectionData.properties");
            properties.load(input);
            input.close();
            connection=DriverManager.getConnection(properties.getProperty("CONNECTION_URL"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addShoppingList(ShoppingList shoppingList) {
        return false;
    }
    public boolean removeShoppingList(String idLista) {
        return false;
    }

    public boolean updateShoppingList(ShoppingList shoppingList) {
        return false;
    }
}
