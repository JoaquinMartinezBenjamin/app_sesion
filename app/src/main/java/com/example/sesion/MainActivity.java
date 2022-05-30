package com.example.sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrarse (View view){
        Intent i = new Intent (this, Registrarse.class);
        startActivity(i);

    }

    public void iniciar_sesion (View view){
        Intent i = new Intent (this, Sesion.class);
        startActivity(i);

    }

}