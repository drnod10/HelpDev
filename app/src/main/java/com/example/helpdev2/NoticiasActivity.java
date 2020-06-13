package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLOutput;

public class NoticiasActivity extends AppCompatActivity {

    Button btvoltar, btprox, btant;
    SQLiteDatabase db;
    TextView titulo, texto;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        btvoltar = findViewById(R.id.btvoltar);
        btant = findViewById(R.id.btanterior);
        btprox = findViewById(R.id.btproximo);
        titulo = findViewById(R.id.titulonoticia);
        texto = findViewById(R.id.textonoticia);

        try {

            db = openOrCreateDatabase("banco_dados",
                    Context.MODE_PRIVATE, null);
            db.execSQL("create table if not exists " +
                    "noticias(id integer primary key " +
                    "autoincrement, titulo text not null, texto text " +
                    "not null, " + "comentarios text not null)");
            System.out.println("Banco de Dados Criado com Sucesso!");

            String apelido = "PROJEÇÃO MORREU DPS QUE O AKL SAIU !!!";
            String email = "ESTUPIDOS !";
            String com = "";

            System.out.println(apelido);
            System.out.println(email);

            db.execSQL("insert into noticias(id, titulo, texto, comentarios) values (null,'" + apelido + "','" + email + "','" + com + "')");

            Cursor res = db.rawQuery("select titulo,texto from noticias", null);

            if (res.getCount() > 0) {

                res.moveToFirst();

                titulo.setText(res.getString(0));
                texto.setText(res.getString(1));
            }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

                btant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contador--;
                    }
                });

                btvoltar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                btprox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contador++;
                    }
                });
            }
    }

