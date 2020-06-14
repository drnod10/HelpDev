package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComentarioGeralActivity extends AppCompatActivity {

    Button btcancelar,btpostar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario_geral);

        btcancelar = findViewById(R.id.cancelarcomentariog);
        btpostar = findViewById(R.id.postarcomentariog);

        btcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btpostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
