package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PostarDuvidaActivity extends AppCompatActivity {

    Button btcancelar, btpostar;
    TextView txttitulo,txttext;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postar_duvida);

        btcancelar = findViewById(R.id.btcancelarnova);
        btpostar = findViewById(R.id.btpostarnova);
        txttitulo = findViewById(R.id.tituloduvida);
        txttext = findViewById(R.id.textoduvida);

        final String titulo = txttitulo.getText().toString();
        final String texto = txttext.getText().toString();

        try {

            db.execSQL("create table if not exists " +
                    "postagem(id integer primary key " +
                    "autoincrement, titulo text not null, texto text " +
                    "not null)");
            System.out.println("Banco de Dados Criado com Sucesso!");

            btpostar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("clicou");
                    db.execSQL("insert into postagem(titulo, texto) values ('"+titulo+"','"+texto+"')");
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(PostarDuvidaActivity.this);
                    dialogo.setTitle("Aviso");
                    dialogo.setMessage("Dúvida Postada com Sucesso !")
                            .setNeutralButton("OK",null)
                            .show();

                }
            });
            btcancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Dados!");
        }



    }
}
