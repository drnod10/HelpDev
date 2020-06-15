package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
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

                    final String lg = edlogin.getText().toString();
                    final String pass = edsenha.getText().toString();

                    c = db.rawQuery("select * from usuarios where apelido=? AND senha=?", new String[]{lg , pass});

                    if(c.getCount() > 0) {

                        c.moveToFirst();

                        int cod = c.getInt(0);
                        String nome = c.getString(1);

                        Cliente cliente = new Cliente(cod,nome);

                        System.out.println(cod);
                        System.out.println(nome);

                        Intent it = new Intent(MainActivity.this, TelaInicialActivity.class);

                        it.putExtra("cliente", cliente);

                        startActivity(it);


                    }else {
                            AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                            dialogo.setTitle("Aviso");
                            dialogo.setMessage("Usuário ou Senha Inválidos !")
                                    .setNeutralButton("OK",null)
                                    .show();
                        }

                }
            });

        } catch (Exception e) {
            System.out.println("Erro ao Criar Banco de Dados!");
        }

    }
}
