package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Activity getActivity;
    Button btlogar, btcadastar, btcancelar;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            db = openOrCreateDatabase("banco_dados",
                    Context.MODE_PRIVATE, null);
            db.execSQL("create table if not exists "+
                    "usuarios(numreg integer primary key " +
                    "autoincrement, nome text not null, apelido text " +
                    "not null, " + "email text not null," + "senha text not null)");
            System.out.println("Banco de Dados Criado com Sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao Criar Banco de Dados!");
        }

        btlogar = findViewById(R.id.btlogar);
        btcadastar = findViewById(R.id.btcadastrar);
        btcancelar = findViewById(R.id.btcancelar);

        btcadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }

        });

    }
}
