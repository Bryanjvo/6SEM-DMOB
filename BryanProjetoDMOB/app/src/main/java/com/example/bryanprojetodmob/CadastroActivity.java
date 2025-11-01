package com.example.bryanprojetodmob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnRegistrar, btnLogin;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // 1. Inicialização das Views e do Helper
        etUsername = findViewById(R.id.et_username_cadastro);
        etPassword = findViewById(R.id.et_password_cadastro);
        btnRegistrar = findViewById(R.id.btn_registrar);
        btnLogin = findViewById(R.id.btnLogin);

        dbHelper = new DatabaseHelper(this);

        // 2. Listener do Botão de Registro
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUsername.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();

                // 3. Validações Simples
                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(CadastroActivity.this,
                            "Preencha o nome de usuário e a senha.",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // 4. Inserção no Banco de Dados
                boolean isInserted = dbHelper.insertUser(user, pass);

                if (isInserted) {
                    Toast.makeText(CadastroActivity.this,
                            "Usuário cadastrado com sucesso!",
                            Toast.LENGTH_LONG).show();

                    // Opcional: Limpar campos após o sucesso
                    etUsername.setText("");
                    etPassword.setText("");

                    // Redireciona de volta para a tela de Login
                    finish();

                } else {
                    // Isso geralmente ocorre se o username não for único (Constraint UNIQUE)
                    Toast.makeText(CadastroActivity.this,
                            "Erro ao cadastrar. O nome de usuário já existe.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redireciona para a tela de Cadastro
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}