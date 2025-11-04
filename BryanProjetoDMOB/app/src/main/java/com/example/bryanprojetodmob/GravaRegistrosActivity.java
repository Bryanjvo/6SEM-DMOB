package com.example.bryanprojetodmob;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GravaRegistrosActivity extends AppCompatActivity {
    Button btcadastrar, btvoltar;
    EditText ednome, edestoque, edpreco;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grava_registros);
        btcadastrar = (Button) findViewById(R.id.btcadastrar);
        ednome = (EditText) findViewById(R.id.ednome);
        edestoque = (EditText) findViewById(R.id.edestoque);
        edpreco = (EditText) findViewById(R.id.edpreco);
        btvoltar = (Button)findViewById(R.id.btvoltar);
        try {
            db = openOrCreateDatabase("banco_dados",
                    Context.MODE_PRIVATE, null);
        } catch (Exception e) {
            MostraMensagem("Erro: "+e.toString());
        }

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma Intent para a MainActivity
                Intent intent = new Intent(GravaRegistrosActivity.this, MainActivity.class);
                startActivity(intent);
                // Finaliza a Activity atual
                finish();
            }
        });

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nome = ednome.getText().toString();
                String estoque = edestoque.getText().toString();
                String preco = edpreco.getText().toString();
                try {
                    db.execSQL("insert into mudas(nome, estoque, preco) " +
                            "values ('"+nome+"','"+estoque+"','"+preco+"')");
                    MostraMensagem("Dados cadastrados com sucesso");
            } catch (Exception e) {
                    MostraMensagem("Erro: "+e.toString());
                }
        };

        });
    }

    public void MostraMensagem(String str)
    {
        AlertDialog.Builder dialogo = new
                AlertDialog.Builder(GravaRegistrosActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage(str);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }

}