package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class CodigoActivity extends AppCompatActivity {

    Button btvoltar;
    ImageView gerais,pessoais,nova;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo);

        btvoltar = findViewById(R.id.voltarduvida);
        gerais = findViewById(R.id.duvidasgerais);
        pessoais = findViewById(R.id.duvidaspessoais);
        nova = findViewById(R.id.novaduvida);

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        gerais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CodigoActivity.this, DuvidasGeraisActivity.class);
                startActivity(intent);
            }
        });

        pessoais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CodigoActivity.this, DuvidasPessoaisActivity.class);
                startActivity(intent);
            }
        });

        nova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CodigoActivity.this, PostarDuvidaActivity.class);
                startActivity(intent);
            }
        });
    }
}
