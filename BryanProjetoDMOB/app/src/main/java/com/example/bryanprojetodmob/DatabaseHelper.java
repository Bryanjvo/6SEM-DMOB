package com.example.bryanprojetodmob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor; // Adicionado para evitar erro em outros métodos
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "banco_dados";
    private static final int DATABASE_VERSION = 1;

    // Detalhes da Tabela de Usuários (para Login/Cadastro)
    public static final String TABLE_USERS = "users";
    public static final String COL_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    // Comando SQL para criar a NOVA Tabela de Login
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_USERS + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COL_USERNAME + " TEXT UNIQUE NOT NULL," +
                    COL_PASSWORD + " TEXT NOT NULL" +
                    ")";

    // ----------------------------------------------------
    // CONSTRUTOR OBRIGATÓRIO (SOLUÇÃO DO SEU ERRO)
    // ----------------------------------------------------
    public DatabaseHelper(Context context) {
        // Chama o construtor da superclasse, passando o contexto, nome do banco,
        // Factory (null) e a versão.
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // ----------------------------------------------------
    // MÉTODOS DE CICLO DE VIDA DO BANCO (onCreate e onUpgrade)
    // ----------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Cria a tabela de usuários
        db.execSQL(CREATE_TABLE_USERS);

        // RECOMENDAÇÃO: Adicione aqui a criação da sua tabela 'usuarios' também!
        // db.execSQL("create table if not exists usuarios (numreg integer primary key autoincrement, nome text not null, telefone text not null, email text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // ----------------------------------------------------
    // MÉTODOS insertUser e checkUser (que eu enviei anteriormente)
    // ----------------------------------------------------
    // (Você deve adicioná-los aqui)
    public boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_USERS, null, contentValues);
        db.close();
        return result != -1;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { COL_USERNAME };
        String selection = COL_USERNAME + " = ?" + " AND " + COL_PASSWORD + " = ?";
        String[] selectionArgs = { username, password };

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
}