package com.example.familytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username =  (TextView) findViewById(R.id.usuario);
        TextView password =  (TextView) findViewById(R.id.contrasena);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.botonInicio);
        MaterialButton registernbtn = (MaterialButton) findViewById(R.id.botonRegistro);


        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validateName();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateName();
            }
            @Override
            public void afterTextChanged(Editable s) {
                validateName();
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validatePassword();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validatePassword();
            }
            @Override
            public void afterTextChanged(Editable s) {
                validatePassword();
            }
        });
        registernbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegister();
            }

        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateName() && validatePassword()) {
                    Toast.makeText(Login.this, "Inicio de sesion exitoso", Toast.LENGTH_SHORT).show();
                }
                else{
                    validateName();
                    validatePassword();
                    Toast.makeText(Login.this, "Por favor rellene los campos", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
    private Boolean validateName(){
        TextView username =  (TextView) findViewById(R.id.usuario);
        String user = username.getText().toString();
        if (user.isEmpty()){
            username.setError("Usuario no puede estar vacio");
             return false;
        }
        else{
            return true;
        }
    }

    private Boolean validatePassword(){
        TextView password =  (TextView) findViewById(R.id.contrasena);
        String pass = password.getText().toString();
        if (pass.isEmpty()){
            password.setError("Contraseña no puede estar vacia");
            return false;
        }
        else{
            return true;
        }
    }
    public void goToRegister(){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
