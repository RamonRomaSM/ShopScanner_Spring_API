package com.example.shopscanner_spring_api.api.model;

import java.util.ArrayList;

public class ShoppingList {
    private String listaId;//userId + nombre
    private String userId;
    private String name;
    private ArrayList<Product>products;
    private double price;
    private String last_modified;

    public ShoppingList (String listaId, String userId, String name, ArrayList<Product> productos, double precio, String ultimaModificacion){
        this.listaId = listaId;
        this.userId = userId;
        this.name = name;
        this.products = productos;
        this.price = precio;
        this.last_modified = ultimaModificacion;
    }

    public String getListaId() {
        return listaId;
    }

    public void setListaId(String listaId) {
        this.listaId = listaId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }
}
