package com.example.sistemadecompras;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pagamento extends AppCompatActivity {

    Button btpagar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagamento);

        btpagar = (Button) findViewById(R.id.btpagar);

        btpagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(
                        Pagamento.this);
                dialogo.setTitle("Pagamento realizado");
                dialogo.setMessage("Pago com sucesso ");
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }


        });
    }
}