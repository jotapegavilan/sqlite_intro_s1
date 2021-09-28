package com.gavilan.sqliteapp.models;

public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private int stock;

    public Producto() {
    }

    public Producto(String nombre, String marca, String modelo, int stock) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
    }

    public Producto(int id, String nombre, String marca, String modelo, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return this.nombre + " - "+ this.marca;
    }
}
