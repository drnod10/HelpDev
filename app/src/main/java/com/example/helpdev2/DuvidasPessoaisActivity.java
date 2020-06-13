package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DuvidasPessoaisActivity extends AppCompatActivity {

    Button btvoltar,btanterior,btproximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_pessoais);

        btvoltar = findViewById(R.id.btvoltarpessoais);
        btanterior = findViewById(R.id.btanteriorpessoais);
        btproximo = findViewById(R.id.btproximopessoais);

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
