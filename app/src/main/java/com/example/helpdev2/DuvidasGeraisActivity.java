package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DuvidasGeraisActivity extends AppCompatActivity {

    Button btvoltar, btanterior, btproximo, btcomentarios;
    TextView txttitulo, txttexto, status;
    SQLiteDatabase db;
    int indice, codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_gerais);

        btcomentarios = findViewById(R.id.btcomentariosgeral);
        btvoltar = findViewById(R.id.voltargeral);
        btanterior = findViewById(R.id.anteriorgeral);
        btproximo = findViewById(R.id.proximogeral);

        txttitulo = findViewById(R.id.titulogeral);
        txttexto = findViewById(R.id.textogeral);
        status = findViewById(R.id.statusg);

        try {
            final Cliente c = getIntent().getExtras().getParcelable("cliente");


            int id = c.getCodigo();
            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
            final Cursor res = db.rawQuery("select * from postagem", null);

            if (res.getCount() > 0) {
                indice = res.getCount();
                res.moveToLast();
                codigo = res.getInt(0);
                txttitulo.setText(res.getString(1));
                txttexto.setText(res.getString(2));
                txttexto.setMovementMethod(new ScrollingMovementMethod());
                status.setText(indice + " / " + res.getCount());
            }

                btanterior.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (res.getCount() > 0) {
                            if (indice >1) {
                                indice--;
                                res.moveToPrevious();
                                codigo = res.getInt(0);
                                txttitulo.setText(res.getString(1));
                                txttexto.setText(res.getString(2));
                                txttexto.setMovementMethod(new ScrollingMovementMethod());
                                status.setText(indice + " / " + res.getCount());
                            }
                        }
                    }
                });

                btproximo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (res.getCount() > 0) {
                            if (indice < res.getCount()) {
                                indice++;
                                res.moveToNext();
                                codigo = res.getInt(0);
                                txttitulo.setText(res.getString(1));
                                txttexto.setText(res.getString(2));
                                txttexto.setMovementMethod(new ScrollingMovementMethod());
                                status.setText(indice + " / " + res.getCount());
                            }
                        }
                    }
                });

            btcomentarios.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Integer cd = codigo;
                    Integer id = c.getCodigo();
                    String nome = c.getNome();
                    System.out.println(id);
                    System.out.println(nome);

                    Cliente cliente = new Cliente(id,nome);
                    IDClass d = new IDClass(cd);

                    Intent it = new Intent(DuvidasGeraisActivity.this, ComentarioGeralActivity.class);

                    it.putExtra("cliente", cliente);
                    it.putExtra("id_user", d);

                    startActivity(it);
                }
            });

        }catch (Exception e){
            System.out.println(e.toString());
        }

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        }
        }


