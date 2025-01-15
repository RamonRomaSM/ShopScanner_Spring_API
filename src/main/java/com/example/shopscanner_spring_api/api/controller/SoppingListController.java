package com.example.shopscanner_spring_api.api.controller;

import com.example.shopscanner_spring_api.api.model.ShoppingList;
import com.example.shopscanner_spring_api.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoppingListController {

    private ShoppingListService shoppingListService;

    @Autowired
    public SoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }
    @GetMapping("/modifyList")
    public void modifycaList(@RequestParam ShoppingList lista){
        shoppingListService.updateShoppingList(lista);
    }
    @GetMapping("/deleteList")
    public void deleteList(@RequestParam String idLista){
        shoppingListService.removeShoppingList(idLista);
    }
    @GetMapping("/addList")
    public void addList(@RequestParam ShoppingList lista){
        shoppingListService.addShoppingList(lista);
    }
    @GetMapping("/getList")
    public void getList(@RequestParam String idLista){
        shoppingListService.getShoppingList(idLista);
    }

}
