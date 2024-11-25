package com.example.shopscanner_spring_api.api.model;



import java.util.ArrayList;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String email;
    private ArrayList<ShoppingList>shoppingLists;


    public User(String userId, String userName, String password, String email, ArrayList<ShoppingList> shoppingLists) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.shoppingLists = shoppingLists;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(ArrayList<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}
