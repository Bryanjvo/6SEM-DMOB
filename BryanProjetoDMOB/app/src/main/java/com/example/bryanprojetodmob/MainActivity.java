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

public class MainActivity extends AppCompatActivity {

    Button btcriarbanco;
    Button btcadastrardados;
    SQLiteDatabase db;
    Button btcadastrardados2;

    Button btconsultardados;

    Button btalterardados;

    Button btexcluirdados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btcriarbanco = findViewById(R.id.btcriarbanco);
        btcadastrardados = findViewById(R.id.btcadastrardados);

        btexcluirdados = findViewById(R.id.btexcluirdados);

        btexcluirdados.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent excluirDadosActivity = new Intent(MainActivity.this,

                        ExcluirDadosActivity.class);

                MainActivity.this.startActivity(excluirDadosActivity);

            }

        });

        btalterardados = findViewById(R.id.btalterardados);
        btalterardados.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View args0){

                Intent alterarDadosActivity = new Intent (MainActivity.this,

                        AlterarDadosActivity.class);

                MainActivity.this.startActivity(alterarDadosActivity);

            }

        });

        btconsultardados = findViewById(R.id.btconsultardados);
        btconsultardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                Intent consultaDadosActivity = new Intent(MainActivity.this,
                        ConsultaDadosActivity.class);
                MainActivity.this.startActivity(consultaDadosActivity);
            }
        });

        btcadastrardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                Intent gravaRegistroActivity = new Intent(MainActivity.this,
                        GravaRegistrosActivity.class);
                        MainActivity.this.startActivity(gravaRegistroActivity);

            }
        });

        btcriarbanco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    db = openOrCreateDatabase("banco_dados",
                            Context.MODE_PRIVATE, null);
                    db.execSQL("create table if not exists mudas (id integer primary key " +
                            "autoincrement, nome text not null, estoque integer not null, " +
                            "preco real not null)");
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(MainActivity.this);
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
