package com.gavilan.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gavilan.sqliteapp.models.Categoria;
import com.gavilan.sqliteapp.sqlite.DbCategoria;

public class FormCategoria extends AppCompatActivity {

    EditText txtNombreCat;
    Button btnCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_categoria);

        txtNombreCat = findViewById(R.id.txtNombreCat);
        btnCat = findViewById(R.id.btnCat);

        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombreCat.getText().toString();
                Categoria c = new Categoria(nombre);
                DbCategoria dbcat = new DbCategoria(getApplicationContext());
                long id =  dbcat.insertarCategoria(c);
                if( id >= 0 ){
                    Toast.makeText(FormCategoria.this,
                            nombre+" insertado", Toast.LENGTH_LONG).show();
                    txtNombreCat.setText("");
                }else{
                    Toast.makeText(FormCategoria.this,
                            "Error al insertar", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}