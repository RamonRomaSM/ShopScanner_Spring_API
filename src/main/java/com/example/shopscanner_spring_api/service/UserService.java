package com.example.shopscanner_spring_api.service;

import com.example.shopscanner_spring_api.api.model.ShoppingList;
import com.example.shopscanner_spring_api.api.model.User;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class UserService extends GenericService{
    public UserService(){
        super();
    }
    //NOTE: I don't want the products of a list until the app wants to show a specific list
    public User getUser(String nombre, String passw){
        try {
            //First we ask for the basic user info
            String sql="SELECT \"ID\", \"NAME\", \"MAIL\" FROM USERS WHERE NAME = ? AND PASSW = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, passw);
            ResultSet rs = ps.executeQuery();

            String userId = rs.getString("ID");
            String name = rs.getString("NAME");
            String email = rs.getString("MAIL");

            ps.close();
            rs.close();

            //Now we ask for the Shopping lists
            ArrayList<ShoppingList> shoppingLists = new ArrayList<>();
            String sql2 = "SELECT * FROM SHOPPING_LISTS WHERE USER_ID = ?";
            ps = this.connection.prepareStatement(sql2);
            rs = ps.executeQuery();
            while (rs.next()) {

                String listId = rs.getString("LIST_ID");
                String listName = rs.getString("NAME");
                String lastModified = rs.getString("LAST_MODIFIED");
                double totalPrice = rs.getDouble("TOTAL_PRICE");
                ShoppingList act = new ShoppingList(listId,userId,listName,null,totalPrice,lastModified);

                shoppingLists.add(act);
            }
            ps.close();
            rs.close();
            return new User(userId,name,"",email,shoppingLists);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean registerUser(String nombre, String passw, String email){
        try {
            String sql = "INSERT INTO USERS (NAME, PASSW, MAIL) VALUES (?, ?, ?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2,passw);
            ps.setString(3,email);
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
