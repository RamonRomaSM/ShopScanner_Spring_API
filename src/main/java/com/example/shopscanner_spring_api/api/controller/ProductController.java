package com.example.shopscanner_spring_api.api.controller;

import com.example.shopscanner_spring_api.api.model.Product;
import com.example.shopscanner_spring_api.api.model.ShoppingList;
import com.example.shopscanner_spring_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getPage")
        public ArrayList<Product> getPage(@RequestParam int page, @RequestParam int size, @RequestParam(required = false, defaultValue = "%") String search, @RequestParam(required = false, defaultValue = "id") String sort, @RequestParam(required = false, defaultValue = "ANY") String seller) {
        return productService.getPage(page, size, search, sort, seller);
    }

    @GetMapping("/getPoduct")
    public Product getPoduct(@RequestParam String id) {
        return productService.getProduct(id);
    }

    @GetMapping("/getListProducts")
    public void getList(@RequestParam int listId){
        productService.getShoppingListProducts(listId);
    }
}
