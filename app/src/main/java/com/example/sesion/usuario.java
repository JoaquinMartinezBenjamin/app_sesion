package com.example.sesion;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;

public class usuario extends AppCompatActivity {

    private FirebaseAuth mAuth;   // <------

    private TextView email;
    private TextView id;
    private TextView verificado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        mAuth = FirebaseAuth.getInstance();  // <------
        email= findViewById(R.id.email_user);
        id= findViewById(R.id.id_user);
        verificado= findViewById(R.id.verificado_user);
        obtener_datos ();
    }

    @Override
    public void onStart() {  // <------
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void obtener_datos (){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String e_mail = user.getEmail();
            String uid = user.getUid();
            boolean emailVerified = user.isEmailVerified();

            email.setText(e_mail + "");
            id.setText(uid + "");
            verificado.setText(emailVerified + "");


        }

    }

    public void cerrar_sesion (View view) {
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

    }

}