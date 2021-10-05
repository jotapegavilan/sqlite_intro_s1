package com.gavilan.sqliteapp.models;

public class Categoria {
    private int id;
    private String nombre;

    public Categoria() {
    }
    // crear categoria
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    // desde bd
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString(){
        return this.nombre;
    }
}
