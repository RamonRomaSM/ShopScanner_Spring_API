package com.example.shopscanner_spring_api.service;

import com.example.shopscanner_spring_api.api.model.Product;
import com.example.shopscanner_spring_api.api.model.ShoppingList;
import com.example.shopscanner_spring_api.api.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    public User getUser(String nombre, String passw){
        Product a= new Product("0","producto 1",12.2,"mercadona","no","URL","imagen");
        ArrayList<Product> products = new ArrayList<>();
        products.add(a);

        ArrayList<ShoppingList> shoppingLists = new ArrayList<>();
        ShoppingList aa = new ShoppingList("0","0","lista 1",products,12.2,"20241125");
        shoppingLists.add(aa);

        return new User("0","Rasdfsdmon","1234","email",shoppingLists);
    }

    public boolean registerUser(String nombre, String passw, String email){
        return true;
    }

}
