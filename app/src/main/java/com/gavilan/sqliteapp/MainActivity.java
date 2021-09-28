package com.gavilan.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.gavilan.sqliteapp.models.Producto;
import com.gavilan.sqliteapp.sqlite.DbHelper;
import com.gavilan.sqliteapp.sqlite.DbProducto;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        /*
        Producto newProducto =
                new Producto("notebook","hp","XZ-123",50);

        DbProducto dbprod = new DbProducto(this);
        long resultado =  dbprod.insertarProducto(newProducto);

        if( resultado > 0 ){
            Toast.makeText(this, "Insertado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Error al insertar", Toast.LENGTH_SHORT).show();
        }
        */

        DbProducto db = new DbProducto(this);
        ArrayAdapter<Producto> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, db.getProductos() );
        spinner.setAdapter(adapter);



    }
}