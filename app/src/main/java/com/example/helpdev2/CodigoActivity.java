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
        final Cliente c = getIntent().getExtras().getParcelable("cliente");

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        gerais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente c = getIntent().getExtras().getParcelable("cliente");

                Integer cd = c.getCodigo();

                Cliente cliente = new Cliente(cd);

                System.out.println(cd);

                Intent it = new Intent(CodigoActivity.this, DuvidasGeraisActivity.class);

                it.putExtra("cliente", cliente);

                startActivity(it);
            }
        });

        pessoais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente c = getIntent().getExtras().getParcelable("cliente");

                Integer cd = c.getCodigo();

                Cliente cliente = new Cliente(cd);

                System.out.println(cd);

                Intent it = new Intent(CodigoActivity.this, DuvidasPessoaisActivity.class);

                it.putExtra("cliente", cliente);

                startActivity(it);
            }
        });

        nova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente c = getIntent().getExtras().getParcelable("cliente");

                Integer cd = c.getCodigo();

                Cliente cliente = new Cliente(cd);

                System.out.println(cd);

                Intent it = new Intent(CodigoActivity.this, PostarDuvidaActivity.class);

                it.putExtra("cliente", cliente);

                startActivity(it);
            }
        });
    }
}
