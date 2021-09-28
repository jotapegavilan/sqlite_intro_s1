package com.gavilan.sqliteapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.gavilan.sqliteapp.models.Producto;

import java.util.ArrayList;

public class DbProducto extends DbHelper {
    Context context;
    public DbProducto(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProducto(Producto producto){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        long res = 0;

        ContentValues valores = new ContentValues();
        valores.put("nombre", producto.getNombre());
        valores.put("marca",producto.getMarca());
        valores.put("modelo",producto.getModelo());
        valores.put("stock",producto.getStock());

        res = db.insert(DbHelper.TABLE_PRODUCTOS,null,
                valores);
        return res;

    }

    public ArrayList<Producto> getProductos(){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<Producto> productos = new ArrayList<>();
        Cursor cursor = null;
        Producto producto = null;
        cursor = db.rawQuery("SELECT * FROM "+DbHelper.TABLE_PRODUCTOS,null);
        if( cursor.moveToFirst() ){
            do{
                producto = new Producto(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4)
                );
                productos.add(producto);
            }while( cursor.moveToNext() );
        }
        return productos;
    }
}
