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
            String sql="SELECT \"id\", \"name\", \"mail\" FROM \"ShopScanner_Schema\".users WHERE name = ? AND passw = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, passw);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()){return new User(null,null,null,null,null);}//In case user does not exist

            String userId = rs.getString("id");
            String name = rs.getString("name");
            String email = rs.getString("mail");

            ps.close();
            rs.close();

            //Now we ask for the Shopping lists
            ArrayList<ShoppingList> shoppingLists = new ArrayList<>();
            String sql2 = "SELECT * FROM \"ShopScanner_Schema\".shopping_lists WHERE user_id = ?";
            ps = this.connection.prepareStatement(sql2);
            ps.setInt(1, Integer.parseInt(userId));
            rs = ps.executeQuery();
            while (rs.next()) {

                String listId = rs.getString("list_id");
                String listName = rs.getString("name");
                String lastModified = rs.getString("last_modified");
                double totalPrice = rs.getDouble("total_price");
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
            String sql = "INSERT INTO \"ShopScanner_Schema\".users (name, passw, mail) VALUES (?, ?, ?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2,passw);
            ps.setString(3,email);

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
