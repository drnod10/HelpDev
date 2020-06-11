package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PerfilActivity extends AppCompatActivity {

    EditText nome,apelido,email,telefone;
    Button btcancelar,btdeletar;
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        try {
            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE,null);
            Cursor res = db.rawQuery("select nome,apelido,email,telefone from usuarios WHERE id = '1'", null);
            res.moveToFirst();
                nome.setText(c.getString(0));
                apelido.setText(c.getString(1));
                email.setText(c.getString(2));
                telefone.setText(c.getString(3));
            }catch(Exception e) {
            System.out.println(e.toString());
            }

        btcancelar = findViewById(R.id.btcancelarperfil);
        btdeletar = findViewById(R.id.btdeletar);

        nome = findViewById(R.id.nomeperfil);
        apelido = findViewById(R.id.apelidoperfil);
        email = findViewById(R.id.emailperfil);
        telefone = findViewById(R.id.telefoneperfil);


        btcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btdeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(PerfilActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Deseja Excluir Sua Conta?")
                        .setPositiveButton("Sim",null)
                        .setNegativeButton("Não",null)
                        .show();
            }
        });

        try {

        }catch (Exception e){

        }
    }
}
