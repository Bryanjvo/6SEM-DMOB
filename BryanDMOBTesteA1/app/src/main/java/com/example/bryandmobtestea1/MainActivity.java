package com.example.bryandmobtestea1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    TextView txtstatus;
    RatingBar rtbvotacao;

    Intent tela2resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtstatus = (TextView) findViewById(R.id.txtResultadostatus);
        rtbvotacao = (RatingBar) findViewById(R.id.rtbvotacao);
        txtstatus.setText("Status: Ruim");
        rtbvotacao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String status = "";
                if (rating <= 1) {
                    txtstatus.setText("Status: Regular");
                }else if (rating <= 2) {
                    txtstatus.setText("Status: Bom");
                }else if (rating <= 3) {
                    txtstatus.setText("Status: Ótimo");
                }else if (rating <= 4) {
                    txtstatus.setText("Status: Excelente");
                }else if (rating <= 5) {
                    txtstatus.setText("Status: Espetacular");
                }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

                dialogo.setTitle(txtstatus.getText());
                dialogo.setMessage(txtstatus.getText());

                dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tela2resultado = new Intent(MainActivity.this, tela2resultado.class);
                        tela2resultado.putExtra("valor_status", txtstatus.getText().toString());
                        startActivity(tela2resultado);
                    }
                });

                AlertDialog dialog = dialogo.create();
                dialog.show();



            }
        });




        };
    }
