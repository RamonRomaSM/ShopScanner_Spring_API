package com.example.shopscanner_spring_api.service;

import com.example.shopscanner_spring_api.api.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends GenericService{

    public ProductService() {
        super();
    }

    public Product getProduct(String idProducto) {
        return null;
    }

    public ArrayList<Product> getPage(int page, int size, String searc, String sort) {
        return null;
    }


}
