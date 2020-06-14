package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DuvidasGeraisActivity extends AppCompatActivity {

    Button btcomentarios, btvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duvidas_gerais);

        btcomentarios = findViewById(R.id.btcomentariosgeral);
        btvoltar = findViewById(R.id.voltargeral);

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btcomentarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuvidasGeraisActivity.this, ComentarioGeralActivity.class);
                startActivity(intent);
            }
        });

    }
}
