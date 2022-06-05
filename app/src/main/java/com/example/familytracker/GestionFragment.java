package com.example.familytracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

public class GestionFragment extends Fragment {

    Activity context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        return inflater.inflate(R.layout.fragment_gestion, container, false);
    }
    public void onStart(){
        super.onStart();
        MaterialButton unirseFamilia;
        unirseFamilia = getView().findViewById(R.id.unirteFamilia);
        unirseFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUnirte();
            }

        });
    }
    public void goToUnirte(){
        Intent intent = new Intent(context,JoinFamilyActivity.class);
        startActivity(intent);
    }

}