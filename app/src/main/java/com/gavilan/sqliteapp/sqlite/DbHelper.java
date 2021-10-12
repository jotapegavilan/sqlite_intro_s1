package com.gavilan.sqliteapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "tiendaBD";
    public static final int DB_VERSION = 4;
    public static final String TABLE_PRODUCTOS= "productos";
    public static final String TABLE_CATEGORIAS = "categorias";
    public static final String TABLE_USERS = "usuarios";


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // crear las tablas
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CATEGORIAS+" ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PRODUCTOS+" ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL,"+
                "marca TEXT NOT NULL,"+
                "modelo TEXT NOT NULL,"+
                "stock INTEGER NOT NULL,"+
                "precio INTEGER NOT NULL,"+
                "categoria INTEGER NOT NULL,"+
                "FOREIGN KEY (categoria) REFERENCES categorias(id))");
        // TABLA USUARIOS
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_USERS+" ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombres TEXT NOT NULL,"+
                "apellidos TEXT NOT NULL,"+
                "email TEXT NOT NULL,"+
                "clave TEXT NOT NULL,"+
                "tipo TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //se llama cuando hay nueva versión de la base de datos
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUCTOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_CATEGORIAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
        onCreate(sqLiteDatabase);
    }
}
