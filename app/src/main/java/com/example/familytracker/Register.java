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

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView username =  (TextView) findViewById(R.id.usuarioRegistro);
        TextView password =  (TextView) findViewById(R.id.contrasenaRegistro);
        TextView name =  (TextView) findViewById(R.id.nombreRegistro);
        TextView age =  (TextView) findViewById(R.id.edadRegistro);
        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.botonRegistroEnvio);
        MaterialButton homebtn = (MaterialButton) findViewById(R.id.botonVolverEnvio);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }

        });
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validateUserName();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateUserName();
            }
            @Override
            public void afterTextChanged(Editable s) {
                validateUserName();
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
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                validateAge();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateAge();
            }
            @Override
            public void afterTextChanged(Editable s) {
                validateAge();
            }
        });
        name.addTextChangedListener(new TextWatcher() {
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
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateName() && validatePassword() && validateAge() && validateUserName()) {
                    Toast.makeText(Register.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    goToHome();
                }
                else{
                    validateUserName();
                    validatePassword();
                    validateAge();
                    validateName();
                    Toast.makeText(Register.this, "Por favor rellene los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Boolean validateUserName(){
        TextView username =  (TextView) findViewById(R.id.usuarioRegistro);
        String user = username.getText().toString();
        if (user.isEmpty()){
            username.setError("Usuario no puede estar vacio");
            return false;
        }
        else{
            return true;
        }
    }
    private Boolean validateName(){
        TextView Name =  (TextView) findViewById(R.id.nombreRegistro);
        String user = Name.getText().toString();
        if (user.isEmpty()){
            Name.setError("Nombre no puede estar vacio");
            return false;
        }
        else{
            return true;
        }
    }private Boolean validateAge(){
        TextView age =  (TextView) findViewById(R.id.edadRegistro);
        String user = age.getText().toString();
        if (user.isEmpty()){
            age.setError("Edad no puede estar vacio");
            return false;
        }
        else{
            return true;
        }
    }

    private Boolean validatePassword(){
        TextView password =  (TextView) findViewById(R.id.contrasenaRegistro);
        String pass = password.getText().toString();
        if (pass.isEmpty()){
            password.setError("Contraseña no puede estar vacia");
            return false;
        }
        else{
            return true;
        }
    }
    public void goToHome(){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}