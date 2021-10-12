package com.gavilan.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gavilan.sqliteapp.models.Usuario;
import com.gavilan.sqliteapp.sqlite.DbUsuario;

public class LoginActivity extends AppCompatActivity {
    EditText txtClaveLogin, txtEmailLogin;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtClaveLogin = findViewById(R.id.txtClaveLogin);
        txtEmailLogin = findViewById(R.id.txtEmailLogin);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmailLogin.getText().toString();
                String clave = txtClaveLogin.getText().toString();

                DbUsuario bduser = new DbUsuario(LoginActivity.this);

                Usuario user = bduser.login(email, clave);

                if( user == null ){
                    Toast.makeText(LoginActivity.this,
                            "Credenciales no validas", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this,
                            "Bienvenid@ "+user.getNombres(), Toast.LENGTH_LONG).show();

                    if( user.getTipo().equals("admin") ){
                        // abrir pantalla de admin
                    }else if( user.getTipo().equals("cliente") ){
                        // abrir pantalla de cliente
                    }

                }


            }
        });


    }
}