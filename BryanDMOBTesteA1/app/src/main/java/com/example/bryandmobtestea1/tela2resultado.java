package com.example.bryandmobtestea1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela2resultado extends AppCompatActivity {

    TextView txtResultadoStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2resultado);

        txtResultadoStatus = findViewById(R.id.txtResultadostatus);

        Intent tela2resultado = getIntent();

        String valor_status = tela2resultado.getStringExtra("valor_status");

        if (valor_status != null) {
            txtResultadoStatus.setText(valor_status);
        };
    }
}