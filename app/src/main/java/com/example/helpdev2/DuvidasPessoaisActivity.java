package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DuvidasPessoaisActivity extends AppCompatActivity {

    Button btvoltar,btanterior,btproximo;
    TextView txttitulo,txttexto,status;
    SQLiteDatabase db;
    int indice,codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_pessoais);

        btvoltar = findViewById(R.id.btvoltarpessoais);
        btanterior = findViewById(R.id.btanteriorpessoais);
        btproximo = findViewById(R.id.btproximopessoais);

        txttitulo = findViewById(R.id.titulopessoais);
        txttexto = findViewById(R.id.textopessoais);
        status = findViewById(R.id.status);


        final Cliente[] c = {getIntent().getExtras().getParcelable("cliente")};

        try {


            int id = c[0].getCodigo();
            db = openOrCreateDatabase("banco_dados",Context.MODE_PRIVATE, null);
            final Cursor res = db.rawQuery("select * from postagem where id_user ='"+id+"' ", null);

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


        }catch (Exception e) {
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
