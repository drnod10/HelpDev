package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ComentarioPessoalActivity extends AppCompatActivity {

    Button btcancelar, btpostar;
    SQLiteDatabase db;
    TextView comentpessoal, escrevacomentario;

    int indice, codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario_pessoal);

        btcancelar = findViewById(R.id.cancelarcomentariop);
        btpostar = findViewById(R.id.postarcomentariop);
        comentpessoal = findViewById(R.id.comentariospessoal);
        escrevacomentario = findViewById(R.id.escrevacomentariop);
        final Cliente c = getIntent().getExtras().getParcelable("cliente");
        final IDClass d = getIntent().getExtras().getParcelable("id_user");
        final Integer cb = d.getCodigo();
        final Integer iup = c.getCodigo();



        db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists " +
                "comentarios(id integer primary key " +
                "autoincrement, nome_comentador text not null, coment text " +
                "not null, id_user_postagem integer not null)");
        System.out.println("Banco de Dados Criado com Sucesso!");
        System.out.println(c.getCodigo());
        System.out.println(d.getCodigo());


        final Cursor res = db.rawQuery("select * from comentarios", null);
        if (res.getCount() > 0) {
            indice = res.getCount();
            res.moveToLast();
            codigo = res.getInt(0);
            String nome = res.getString(1);
            String coment = res.getString(2);
            comentpessoal.setText(nome + ":" + coment);

            comentpessoal.setMovementMethod(new ScrollingMovementMethod());
            //status.setText(indice + " / " + res.getCount());
            }

            btcancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            btpostar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor ress = db.rawQuery("select * from usuarios WHERE id = "+cb+"", null);
                    if (ress.getCount() > 0) {
                        String nome = ress.getString(0);
                        String cm = escrevacomentario.getText().toString();
                        System.out.println(nome);
                        System.out.println(cm);
                        System.out.println(iup);
                        db.execSQL("insert into comentarios(nome_comentador, coment,id_user_postagem) values " +
                                "('" + nome + "','" + cm + "','" + iup + "')");
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(ComentarioPessoalActivity.this);
                        dialogo.setTitle("Aviso");
                        dialogo.setMessage("Comentário Postado com Sucesso !")
                                .setNeutralButton("OK", null)
                                .show();
                    }else{
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(ComentarioPessoalActivity.this);
                        dialogo.setTitle("Aviso");
                        dialogo.setMessage("Erro na consulta")
                                .setNeutralButton("OK", null)
                                .show();

                    }
                }
            });
        }
}

