package com.example.familytracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class UserMenu extends AppCompatActivity {

    private BottomNavigationView navBottonView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);
        navBottonView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new MapFragment()).commit();

        navBottonView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                String NameHeader = "";
                switch (item.getItemId()){
                    case R.id.mapa:
                        fragment = new MapFragment();
                        NameHeader = "Mapa";
                        break;
                    case R.id.gestion:
                        fragment = new GestionFragment();
                        NameHeader = "Gestion";
                        break;
                    case R.id.familia:
                        fragment = new FamilyFragment();
                        NameHeader = "Familia";
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();

                return true;
            }
        });

    }

}