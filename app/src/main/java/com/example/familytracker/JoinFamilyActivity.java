package com.example.familytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class JoinFamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_family);
        MaterialButton sendbtn = (MaterialButton) findViewById(R.id.botonEnviar);

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMenu();
            }

        });
    }
    public void goToMenu(){
        Intent intent = new Intent(this,UserMenu.class);
        startActivity(intent);
    }
}