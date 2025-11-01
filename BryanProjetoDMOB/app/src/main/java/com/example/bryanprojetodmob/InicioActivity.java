package com.example.bryanprojetodmob;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {

    Button btcriarbanco;
    SQLiteDatabase db;
    Button btalterardados;

    Button btexcluirdados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        btcriarbanco = findViewById(R.id.btcriarbanco);


        btexcluirdados = findViewById(R.id.btexcluirdados);

        btexcluirdados.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent MainActivity = new Intent(InicioActivity.this,

                        MainActivity.class);

                InicioActivity.this.startActivity(MainActivity);

            }

        });

        btalterardados = findViewById(R.id.btalterardados);
        btalterardados.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View args0){

                Intent produtosActivity = new Intent (InicioActivity.this,

                        ProdutosActivity.class);

                InicioActivity.this.startActivity(produtosActivity);

            }

        });

        btcriarbanco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    db = openOrCreateDatabase("banco_dados",
                            Context.MODE_PRIVATE, null);
                    db.execSQL("create table if not exists usuarios (numreg integer primary key " +
                            "autoincrement, nome text not null, telefone text not null, " +
                            "email text not null)");
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(InicioActivity.this);
                    dialogo.setTitle("Aviso")
                            .setMessage("Banco de dados criado com sucesso!")
                            .setNeutralButton("OK", null)
                            .show();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }




        });


    };
}
