package com.gavilan.sqliteapp.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.gavilan.sqliteapp.models.Usuario;

public class DbUsuario extends DbHelper {
    Context context;
    public DbUsuario(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public Usuario login( String email, String clave ){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase base = helper.getReadableDatabase();
        Usuario userLog = null;
        Cursor cursor;
        cursor = base.rawQuery("SELECT * FROM usuarios WHERE email = ? and clave = ?",
                new String[]{ email, clave });
        if( cursor.moveToFirst() ){
            userLog = new Usuario();
            userLog.setId( cursor.getInt(0) );
            userLog.setNombres( cursor.getString(1) );
            userLog.setApellidos( cursor.getString(2) );
            userLog.setEmail( cursor.getString(3) );
            userLog.setClave( cursor.getString(4) );
            userLog.setTipo( cursor.getString(5) );
        }
        return userLog;

    }

}
