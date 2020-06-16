package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TelaAdminActivity extends AppCompatActivity {

    ImageView btnoticias,btcodigo,btperfil,btsair,btinserir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        btnoticias = findViewById(R.id.imageView6);
        btcodigo = findViewById(R.id.imageView7);
        btperfil = findViewById(R.id.imageView8);
        btsair = findViewById(R.id.imageView11);
        btinserir = findViewById(R.id.imageView10);

        btnoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaAdminActivity.this, NoticiasActivity.class);
                startActivity(intent);
            }
        });

        btcodigo.setOnClickListener(new View.OnClickListener() {
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

        btperfil.setOnClickListener(new View.OnClickListener() {
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

        btsair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btinserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaAdminActivity.this, InsereNoticiaActivity.class);
                startActivity(it);
            }
        });

    }
}
