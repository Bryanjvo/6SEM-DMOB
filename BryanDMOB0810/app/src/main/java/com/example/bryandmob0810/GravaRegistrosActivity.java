package com.example.bryandmob0810;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE,
                    null);
        } catch (Exception e) {
            MostraMensagem("Erro : " + e.toString());
        }

    }
    public void MostraMensagem(String str){
        AlertDialog.Builder dialogo = new
                AlertDialog.Builder(GravaRegistrosActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage(str);
        dialogo.setNeutralButton("Ok", null);
        dialogo.show();
    }

}