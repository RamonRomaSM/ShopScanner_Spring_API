package com.example.shopscanner_spring_api.service;

import com.example.shopscanner_spring_api.api.model.ShoppingList;
import org.springframework.stereotype.Service;




@Service
public class ShoppingListService extends GenericService{

    public ShoppingListService (){
        super();
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
