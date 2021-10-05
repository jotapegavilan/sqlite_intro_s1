package com.gavilan.sqliteapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.gavilan.sqliteapp.models.Categoria;

import java.util.ArrayList;

public class DbCategoria extends DbHelper {
    Context context;
    public DbCategoria(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public ArrayList<Categoria> getCategorias(){
        DbHelper helper =  new DbHelper(context);
        SQLiteDatabase bd = helper.getReadableDatabase();
        ArrayList<Categoria> categorias = new ArrayList<>();
        Categoria categoriaObtenida;
        Cursor cursor;
        cursor =
                bd.rawQuery("SELECT * FROM "+TABLE_CATEGORIAS,null);
        if(cursor.moveToFirst()){
            do{
                categoriaObtenida = new Categoria(
                        cursor.getInt(0),
                        cursor.getString(1)
                );
                categorias.add(categoriaObtenida);
            }while (cursor.moveToNext());
            return categorias;

        }else{
            return null;
        }
    }


    public Categoria getCategoria(int id){
        DbHelper helper =  new DbHelper(context);
        SQLiteDatabase bd = helper.getReadableDatabase();
        Categoria categoriaObtenida;
        Cursor cursor;
        cursor =
                bd.rawQuery("SELECT * FROM "+TABLE_CATEGORIAS+" WHERE id = ?",
                        new String[] { String.valueOf(id) });
        if(cursor.moveToFirst()){
            categoriaObtenida = new Categoria(
                    cursor.getInt(0),
                    cursor.getString(1)
            );
            return categoriaObtenida;
        }else{
            return null;
        }
    }

    public long insertarCategoria(Categoria newCat){
        DbHelper helper =  new DbHelper(context);
        SQLiteDatabase bd = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", newCat.getNombre());

        return bd.insert(DbHelper.TABLE_CATEGORIAS,null,values);
    }

}
