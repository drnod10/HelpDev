package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

        final Cliente c = getIntent().getExtras().getParcelable("cliente");
        try {

            btpostar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String titulo = txttitulo.getText().toString();
                    String texto = txttext.getText().toString();
                    int id_user = c.getCodigo();
                    System.out.println(titulo);
                    System.out.println(texto);
                    db.execSQL("insert into postagem(titulo, texto,id_user) values ('"+titulo+"','"+texto+"','"+id_user+"')");
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
                    //db.execSQL("DROP TABLE postagem");
                    finish();
                }
            });

        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar Dados!");
        }
    }
}
