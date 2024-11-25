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
        ArrayList<ShoppingList> shoppingLists = new ArrayList<>();
        ShoppingList aa = new ShoppingList("0","0","lista 1",null,12.2,"20241125");
        Product a= new Product("0","producto 1",12.2,"mercadona","no","URL","imagen");


        shoppingLists.add(aa);
        return new User("0","Ramon","1234","email",shoppingLists);
    }
}
