package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TelaAdminActivity extends AppCompatActivity {

    ImageView noticias,codigo,perfil,sair,inserir;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_admin_acvitivty);

        noticias = findViewById(R.id.imageView6);
        codigo = findViewById(R.id.imageView7);
        perfil = findViewById(R.id.imageView8);
        sair = findViewById(R.id.imageView11);
        inserir = findViewById(R.id.imageView10);

        db = openOrCreateDatabase("banco_dados",
                Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists " +
                "noticias(id integer primary key " +
                "autoincrement, titulo text not null, texto text " +
                "not null)");
        System.out.println("Banco de Dados Criado com Sucesso!");

        noticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaAdminActivity.this, NoticiasActivity.class);
                startActivity(intent);
            }
        });

        codigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente c = getIntent().getExtras().getParcelable("cliente");

                Integer cd = c.getCodigo();
                String nome = c.getNome();


                Cliente cliente = new Cliente(cd,nome);

                System.out.println(cd);
                System.out.println(nome);

                Intent it = new Intent(TelaAdminActivity.this, CodigoActivity.class);

                it.putExtra("cliente", cliente);

                startActivity(it);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cliente c = getIntent().getExtras().getParcelable("cliente");

                Integer cd = c.getCodigo();
                String nome = c.getNome();


                Cliente cliente = new Cliente(cd,nome);

                System.out.println(cd);

                Intent it = new Intent(TelaAdminActivity.this, PerfilActivity.class);

                it.putExtra("cliente", cliente);

                startActivity(it);

            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaAdminActivity.this, InsereNoticiaActivity.class);
                startActivity(it);
            }
        });

    }
}
