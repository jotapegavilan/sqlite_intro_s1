package com.gavilan.sqliteapp.models;

public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private int stock;
    private int precio;
    private Categoria categoria;


    public Producto() {
    }
    // Crear nuevos productos
    public Producto(String nombre, String marca, String modelo,
                    int stock, int precio, Categoria categoria) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
        this.precio = precio;
        this.categoria = categoria;
    }
    // Al obtener los productos -> desde la bd
    public Producto(int id, String nombre, String marca,
                    String modelo, int stock, int precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.stock = stock;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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

    // siempre que necesitemos cargar un spinner
    // siempre crear el tostring -> pruebas sobre mis objetos
    @Override
    public String toString() {
        return this.nombre + " - "+ this.marca;
    }
}
