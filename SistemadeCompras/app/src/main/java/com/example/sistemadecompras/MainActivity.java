package com.example.sistemadecompras;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox chkarroz, chkleite, chkcarne, chkfeijao;
    Button bttotal;

    Intent iTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chkarroz = (CheckBox) findViewById(R.id.chkarroz);
        chkleite = (CheckBox) findViewById(R.id.chkleite);
        chkcarne = (CheckBox) findViewById(R.id.chkcarne);
        chkfeijao = (CheckBox) findViewById(R.id.chkfeijao);

        bttotal = (Button) findViewById(R.id.bttotal);

        bttotal.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {

                    double total=0;
                    if(chkarroz.isChecked())
                        total += 2.69;

                    if(chkleite.isChecked())
                        total += 5.00;

                    if(chkcarne.isChecked())
                        total += 10.9;

                    if(chkfeijao.isChecked())
                        total += 2.30;


                    AlertDialog.Builder dialogo = new AlertDialog.Builder(
                            MainActivity.this);
                    dialogo.setTitle("Aviso");
                    dialogo.setMessage("Valor total da compra: "+String.valueOf(String.format("%.2f", total)));
                    dialogo.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which){
                            iTela2 = new Intent(MainActivity.this, Pagamento.class);
                            startActivity(iTela2);


                        }

                    });
                    dialogo.show();



        }



        });
    }
}