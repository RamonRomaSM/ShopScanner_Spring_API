package com.example.shopscanner_spring_api.api.model;

import java.util.ArrayList;

public class ShoppingList {//TODO: crear  la tabla
    private String listaId;//userId + nombre
    private String userId;
    private String name;
    private ArrayList<Product>productos;
    private double precio;
    private String fechaCreacion;

    public ShoppingList (String listaId, String userId, String name, ArrayList<Product> productos, double precio, String fechaCreacion){
        this.listaId = listaId;
        this.userId = userId;
        this.name = name;
        this.productos = productos;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
