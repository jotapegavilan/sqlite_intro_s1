package com.gavilan.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.gavilan.sqliteapp.models.Producto;
import com.gavilan.sqliteapp.sqlite.DbProducto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

        startActivity(new Intent(this, FormProducto.class));

        DbProducto db = new DbProducto(this);

        ArrayAdapter<Producto> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, db.getProductos() );
        spinner.setAdapter(adapter);



    }
}