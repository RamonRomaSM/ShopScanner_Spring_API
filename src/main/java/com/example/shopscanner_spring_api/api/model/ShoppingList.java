package com.example.shopscanner_spring_api.api.model;

import java.util.ArrayList;

public class ShoppingList {
    private String listaId;//userId + nombre
    private String userId;
    private String name;
    private ArrayList<Product>productos;
    private double precio;
    private String ultimaModificacion;//TODO: modificar en updates e inserts

    public ShoppingList (String listaId, String userId, String name, ArrayList<Product> productos, double precio, String ultimaModificacion){
        this.listaId = listaId;
        this.userId = userId;
        this.name = name;
        this.productos = productos;
        this.precio = precio;
        this.ultimaModificacion = ultimaModificacion;
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

    public ArrayList<Product> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Product> productos) {
        this.productos = productos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getultimaModificacion() {
        return ultimaModificacion;
    }

    public void setultimaModificacion(String ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }
}
