package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoticiasActivity extends AppCompatActivity {

    Button btvoltar,btprox,btant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        btvoltar = findViewById(R.id.btvoltar);
        btant = findViewById(R.id.btanterior);
        btprox = findViewById(R.id.btproximo);

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
