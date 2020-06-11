package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    Button btcadastrar, btcancelar;
    EditText ednome,edapelido,edemail,edsenha;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btcancelar = findViewById(R.id.btcancelarperfil);
        btcadastrar = findViewById(R.id.btatualizarperfil);
        ednome = (EditText) findViewById(R.id.nomeperfil);
        edapelido = (EditText) findViewById(R.id.apelidoperfil);
        edemail = (EditText) findViewById(R.id.emailperfil);
        edsenha = (EditText) findViewById(R.id.senhaperfil);

        try {
            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nome = ednome.getText().toString();
                String apelido = edapelido.getText().toString();
                String email = edemail.getText().toString();
                String senha = edsenha.getText().toString();
                try {
                    db.execSQL("insert into usuarios(nome, apelido, email, senha) values ('nome', 'apelido', 'email', 'senha')");
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(CadastroActivity.this);
                    dialogo.setTitle("Aviso");
                    dialogo.setMessage("Usuario Cadastrado com Sucesso !")
                            .setNeutralButton("OK",null)
                            .show();
                } catch (Exception e) {
                    System.out.println("Erro ao Cadastrar Dados!");
                }
            }
        });

        btcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
