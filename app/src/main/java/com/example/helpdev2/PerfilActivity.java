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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nome = findViewById(R.id.nomeperfil);
        apelido = findViewById(R.id.apelidoperfil);
        email = findViewById(R.id.emailperfil);
        telefone = findViewById(R.id.telefoneperfil);

        btcancelar = findViewById(R.id.btcancelarperfil);
        btdeletar = findViewById(R.id.btdeletar);

        try {

            Cliente c = getIntent().getExtras().getParcelable("cliente");
            Integer codigo = c.getCodigo();

            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE,null);
            System.out.println(codigo);
            Cursor res = db.rawQuery("select nome,apelido,email,telefone from usuarios WHERE id = "+codigo+"", null);

            if (res.getCount() > 0) {
                res.moveToFirst();
                System.out.println(res.getString(0));
                nome.setText(res.getString(0));
                apelido.setText(res.getString(1));
                email.setText(res.getString(2));
                telefone.setText(res.getString(3));

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

            }else {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(PerfilActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Erro ao listar perfil")
                        .show();
            }

            }catch(Exception e) {
            System.out.println(e.toString());
            }

    }
}
