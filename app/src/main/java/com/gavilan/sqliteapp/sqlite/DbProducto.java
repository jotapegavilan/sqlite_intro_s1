package com.gavilan.sqliteapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.gavilan.sqliteapp.models.Categoria;
import com.gavilan.sqliteapp.models.Producto;

import java.util.ArrayList;

public class DbProducto extends DbHelper {
    Context context;
    public DbProducto(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public int eliminarProducto(int id){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        int res = db.delete(TABLE_PRODUCTOS,"id = ?",new String[]{ String.valueOf(id) });
        return res;
    }

    public int actualizarProducto(int id, String nombre,
                                  String marca, String modelo, int stock){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("nombre",nombre);
        values.put("marca",marca);
        values.put("modelo",modelo);
        values.put("stock",stock);

        int resultado = db.update(TABLE_PRODUCTOS,values,
                "id = ?", new String[] { String.valueOf(id) } );

        return resultado;

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
        valores.put("precio", producto.getPrecio());
        valores.put("categoria", producto.getCategoria().getId());

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
        DbCategoria dbcat = new DbCategoria(context);
        cursor = db.rawQuery("SELECT * FROM "+DbHelper.TABLE_PRODUCTOS,null);
        if( cursor.moveToFirst() ){
            do{
                Categoria cat = dbcat.getCategoria(cursor.getInt(6));
                producto = new Producto(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cat
                );
                productos.add(producto);
            }while( cursor.moveToNext() );
        }
        return productos;
    }

}
