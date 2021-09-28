package com.gavilan.sqliteapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "tiendaBD";
    public static final int DB_VERSION = 1;
    public static final String TABLE_PRODUCTOS= "productos";


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // crear las tablas
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PRODUCTOS+" ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL,"+
                "marca TEXT NOT NULL,"+
                "modelo TEXT NOT NULL,"+
                "stock INTEGER NOT NULL )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //se llama cuando hay nueva versión de la base de datos
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUCTOS);
        onCreate(sqLiteDatabase);
    }
}
