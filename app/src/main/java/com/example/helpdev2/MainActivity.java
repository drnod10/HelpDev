package com.example.helpdev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //private Activity getActivity;

    Button btlogar, btcadastrar, btcancelar;
    EditText edlogin, edsenha;

    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btlogar = findViewById(R.id.btlogar);
        btcadastrar = findViewById(R.id.btcadastro);
        edlogin = findViewById(R.id.edlogin);
        edsenha = findViewById(R.id.edsenha);


        try{

            db = openOrCreateDatabase("banco_dados",
                    Context.MODE_PRIVATE, null);
            db.execSQL("create table if not exists "+
                    "usuarios(id integer primary key " +
                    "autoincrement, nome text not null, apelido text " +
                    "not null, " + "email text not null," + "telefone text not null," + "senha text not null)");
            System.out.println("Banco de Dados Criado com Sucesso!");



            btcadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                    startActivity(intent);
                }
            });

            btlogar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TelaInicialActivity.class);
                    startActivity(intent);
                    c = db.query("usuarios",new String[]{"apelido","senha"},
                            null,null,null,null,null);




                }
            });

        } catch (Exception e) {
            System.out.println("Erro ao Criar Banco de Dados!");
        }

    }
}
