package com.example.shopscanner_spring_api.service;

import com.example.shopscanner_spring_api.api.model.ShoppingList;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;


@Service
public class ShoppingListService extends GenericService{

    public ShoppingListService (){
        super();
    }

    public boolean getShoppingList(ShoppingList shoppingList) {
        String sql="";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);



        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public boolean addShoppingList(ShoppingList shoppingList) {
        String sql="";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);



        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }
    public boolean removeShoppingList(String idLista) {
        return false;
    }

    public boolean updateShoppingList(ShoppingList shoppingList) {
        return false;
    }
}
