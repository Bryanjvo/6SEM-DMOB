package com.example.bryandmob0810;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btcriarbanco;
    SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btcriarbanco = findViewById(R.id.btcriarbanco);
        btcriarbanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
                    db.execSQL(" create table if not exists " +
                            " usuarios (numreg integer primary key " +
                            " autoincrement, nome text not null, telefone text not null " +
                            ", email text not null) ");
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Aviso").setMessage("Banco de dados criado com sucesso")
                            .setNeutralButton("Ok", null)
                            .show();
                } catch (Exception e) {

                }
            }
        });
    }
}