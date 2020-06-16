package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsereNoticiaActivity extends AppCompatActivity {

    Button postar, cancelar;
    SQLiteDatabase db;
    EditText texto,titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_noticia);

        postar = findViewById(R.id.btpostarnoticia);
        cancelar = findViewById(R.id.btcancelarnoticia);
        texto = findViewById(R.id.escrevanoticia);
        titulo = findViewById(R.id.escrevatitulonoticia);

        db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        postar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txttitulo = titulo.getText().toString();
                String txttexto = texto.getText().toString();
                db.execSQL("insert into noticias(titulo, texto) values " +
                        "('"+txttitulo+"','"+txttexto+"')");
                AlertDialog.Builder dialogo = new AlertDialog.Builder(InsereNoticiaActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Notícia Postada com Sucesso!")
                        .setNeutralButton("OK", null)
                        .show();
                texto.setText("");
                titulo.setText("");
            }
        });

    }
}
