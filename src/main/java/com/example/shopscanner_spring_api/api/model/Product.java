package com.example.shopscanner_spring_api.api.model;

public class Product {
    private String idProducto;
    private String nombre;
    private double precio;
    private String supermercado;
    private String oferta;
    private String url;
    private String imagen; //Retrieves an URL not a blob

    public Product(String idProducto, String nombre, double precio, String supermercado, String oferta, String url, String imagen) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.supermercado = supermercado;
        this.oferta = oferta;
        this.url = url;
        this.imagen =imagen;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(String supermercado) {
        this.supermercado = supermercado;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
