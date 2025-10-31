package com.example.bryanprojetodmob;

import android.content.Context;
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
    Button btcadastrar;
    EditText ednome, edtelefone, edemail;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grava_registros);
        btcadastrar = (Button) findViewById(R.id.btcadastrar);
        ednome = (EditText) findViewById(R.id.ednome);
        edtelefone = (EditText) findViewById(R.id.edtelefone);
        edemail = (EditText) findViewById(R.id.edemail);
        try {
            db = openOrCreateDatabase("banco_dados",
                    Context.MODE_PRIVATE, null);
        } catch (Exception e) {
            MostraMensagem("Erro: "+e.toString());
        }
        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nome = ednome.getText().toString();
                String telefone = edtelefone.getText().toString();
                String email = edemail.getText().toString();
                try {
                    db.execSQL("insert into usuarios(nome, telefone, email) " +
                            "values ('"+nome+"','"+telefone+"','"+email+"')");
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