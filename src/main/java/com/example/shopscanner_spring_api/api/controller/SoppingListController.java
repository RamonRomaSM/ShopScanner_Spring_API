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
    public void modificaLista(@RequestParam String userId, @RequestParam ShoppingList lista){

    }
    @GetMapping("/deleteList")
    public void eliminaLista(@RequestParam String userId, @RequestParam ShoppingList lista){

    }
    @GetMapping("/addList")
    public void addLista(@RequestParam String userId){

    }



}
