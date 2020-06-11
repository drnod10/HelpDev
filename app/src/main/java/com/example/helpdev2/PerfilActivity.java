package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PerfilActivity extends AppCompatActivity {

    EditText nome;
    Button btcancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        btcancelar = findViewById(R.id.btcancelarperfil);
        nome = findViewById(R.id.nomeperfil);

        btcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        try {



        }catch (Exception e){

        }
    }
}
