package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.SQLOutput;

public class NoticiasActivity extends AppCompatActivity {

    Button btvoltar,btprox,btant;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        btvoltar = findViewById(R.id.btvoltar);
        btant = findViewById(R.id.btanterior);
        btprox = findViewById(R.id.btproximo);


        try {
            db = openOrCreateDatabase("banco_dados",
                    Context.MODE_PRIVATE, null);
            db.execSQL("create table if not exists "+
                    "noticias(id integer primary key " +
                    "autoincrement, titulo text not null, texto text " +
                    "not null, " + "comentarios text not null)");
            System.out.println("Banco de Dados Criado com Sucesso!");


            String apelido = "PROJEÇÃO MORREU DPS QUE O AKL SAIU !!!";
            String email = "ESTUPIDOS !";
            String com = "";

            System.out.println(apelido);
            System.out.println(email);



            db.execSQL("insert into noticias(id, titulo, texto, comentarios) values (null,'"+apelido+"','"+email+"','"+com+"')");


            btvoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }catch (Exception e) {
            System.out.println(e.toString());
        }





    }
}
