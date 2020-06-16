package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsereNoticiaActivity extends AppCompatActivity {

    Button postar, cancelar;
    SQLiteDatabase db;
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_noticia);

        postar = findViewById(R.id.btpostarnoticia);
        cancelar = findViewById(R.id.btcancelarnoticia);
        texto = findViewById(R.id.escrevanoticia);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        postar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
