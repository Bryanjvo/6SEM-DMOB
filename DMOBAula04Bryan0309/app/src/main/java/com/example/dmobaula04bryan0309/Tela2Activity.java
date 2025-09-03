package com.example.dmobaula04bryan0309;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela2Activity extends AppCompatActivity {

    Button btTelaPrincipal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        btTelaPrincipal = (Button) findViewById(R.id.bttelaprincipal);

        btTelaPrincipal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Tela2Activity.this.finish();
            }
                                           }



        );
        };
    }
