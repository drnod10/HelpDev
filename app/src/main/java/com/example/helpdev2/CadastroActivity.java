package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    Button btcadastrar, btcancelar;
    EditText ednome,edapelido,edemail,edsenha;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btcancelar = findViewById(R.id.btcancelar);
        ednome = (EditText) findViewById(R.id.nome);
        edapelido = (EditText) findViewById(R.id.apelido);
        edemail = (EditText) findViewById(R.id.email);
        edsenha = (EditText) findViewById(R.id.senha);

        try {
            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
        } catch (Exception e) {
        //mensagem de erro
        }

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nome = ednome.getText().toString();
                String apelido = edapelido.getText().toString();
                String email = edemail.getText().toString();
                String senha = edsenha.getText().toString();
                try {
                    db.execSQL("insert into usuarios(nome, apelido, email, senha) values ('nome', 'apelido', 'email', 'senha')");
                    System.out.println("Dados Cadastrados Com Sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro ao Cadastrar Dados!");
                }
            }
        });

        btcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
