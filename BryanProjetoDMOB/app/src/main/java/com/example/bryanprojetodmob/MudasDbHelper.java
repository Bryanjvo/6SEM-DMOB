package com.example.bryanprojetodmob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MudasDbHelper extends SQLiteOpenHelper {

    // Nome e versão do banco de dados
    private static final String DATABASE_NAME = "banco_dados";
    private static final int DATABASE_VERSION = 1;

    // Constantes para a tabela 'mudas'
    public static final String TABLE_NAME = "mudas";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_PRECO = "preco";
    public static final String COLUMN_ESTOQUE = "estoque";

    // Comando SQL para criar a tabela 'mudas'
    private static final String SQL_CREATE_MUDAS_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOME + " TEXT NOT NULL, " +
                    COLUMN_PRECO + " REAL NOT NULL, " +
                    COLUMN_ESTOQUE + " INTEGER NOT NULL)";

    // Construtor
    public MudasDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Método chamado na primeira vez que o banco de dados é acessado
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Cria a sua tabela de 'usuarios' (se ela ainda for usada)
        // Você pode mover o SQL de 'usuarios' para cá ou chamar o método do seu helper de usuários.
        // Vou incluir o SQL que você usou na InicioActivity, apenas para referência:
        db.execSQL("CREATE TABLE IF NOT EXISTS usuarios (numreg INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, telefone TEXT NOT NULL, email TEXT NOT NULL)");

        // Cria a nova tabela 'mudas'
        db.execSQL(SQL_CREATE_MUDAS_TABLE);
    }

    // Método chamado quando a versão do banco de dados for alterada
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Simplesmente descarta a tabela e recria (para desenvolvimento)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}