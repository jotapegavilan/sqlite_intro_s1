package com.gavilan.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gavilan.sqliteapp.models.Categoria;
import com.gavilan.sqliteapp.models.Producto;
import com.gavilan.sqliteapp.sqlite.DbCategoria;
import com.gavilan.sqliteapp.sqlite.DbProducto;

import java.util.ArrayList;

public class FormProducto extends AppCompatActivity {

    EditText txtNombrePro, txtMarcaPro, txtModeloPro, txtPrecioPro, txtStockPro;
    Spinner spCat;
    Button btnCat;

    public void cargarSpinner(){
        DbCategoria db = new DbCategoria(this);// instancia
        ArrayList<Categoria> categorias = db.getCategorias();
        if(categorias != null ){ // si categorias no es vacío
            ArrayAdapter<Categoria> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, categorias  );
            spCat.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_producto);

        txtNombrePro = findViewById(R.id.txtNombrePro);
        txtMarcaPro = findViewById(R.id.txtMarcaPro);
        txtModeloPro = findViewById(R.id.txtModeloPro);
        txtPrecioPro = findViewById(R.id.txtPrecioPro);
        txtStockPro = findViewById(R.id.txtStockPro);
        spCat = findViewById(R.id.spCat);
        btnCat = findViewById(R.id.btnPro);

        cargarSpinner();

        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombrePro.getText().toString();
                String marca = txtMarcaPro.getText().toString();
                String modelo = txtModeloPro.getText().toString();
                int precio = Integer.parseInt(txtPrecioPro.getText().toString());
                int stock =  Integer.parseInt(txtStockPro.getText().toString());
                Categoria categoria = (Categoria) spCat.getSelectedItem();

                Producto p = new Producto(nombre,marca,modelo,stock,precio,categoria);

                DbProducto db = new DbProducto(getApplicationContext());

                long id = db.insertarProducto(p);
                if( id >= 0 ){
                    Toast.makeText(FormProducto.this,
                            nombre+" insertado", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(FormProducto.this,
                            "Error al insertar", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}