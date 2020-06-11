package com.example.helpdev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PerfilActivity extends AppCompatActivity {

    EditText nome,apelido,email,telefone;
    Button btcancelar,btdeletar,btatualizar;
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
        btatualizar = findViewById(R.id.btcadastro);
        final DialogInterface.OnClickListener AtualizarUsuario,encerrapagina;

        final Cliente c = getIntent().getExtras().getParcelable("cliente");
        final Integer codigo = c.getCodigo();

        try {

            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE,null);

            Cursor res = db.rawQuery("select nome,apelido,email,telefone from usuarios WHERE id = "+codigo+"", null);

            if (res.getCount() > 0) {
                res.moveToFirst();

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

                encerrapagina = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try{
                            finish();
                        }catch(Exception e){
                            AlertDialog.Builder dialogo = new AlertDialog.Builder(PerfilActivity.this);
                            dialogo.setTitle("Aviso");
                            dialogo.setMessage("Eroor !")
                                    .setNeutralButton("OK",null)
                                    .show();
                        }
                    }
                };

                AtualizarUsuario = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        try{
                            String nom = nome.getText().toString();
                            String apel = apelido.getText().toString();
                            String em = email.getText().toString();
                            String tel = telefone.getText().toString();

                            db.execSQL("update usuarios set nome ='"+nom+"' , apelido ='"+apel+"' , email ='"+em+"', telefone ='"+tel+"' where id = " + codigo);
                            AlertDialog.Builder dialogo = new AlertDialog.Builder(PerfilActivity.this);
                            dialogo.setTitle("Aviso");
                            dialogo.setMessage("Usuario Atualizado com Sucesso !")
                                    .setNeutralButton("OK",encerrapagina)
                                    .show();
                        }catch(Exception e){
                            AlertDialog.Builder dialogo = new AlertDialog.Builder(PerfilActivity.this);
                            dialogo.setTitle("Aviso");
                            dialogo.setMessage("Eroor !")
                                    .setNeutralButton("OK",null)
                                    .show();
                        }
                    }
                };


                btatualizar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        AlertDialog.Builder dialogo = new AlertDialog.Builder(PerfilActivity.this);
                        dialogo.setTitle("Aviso");
                        dialogo.setMessage("Deseja Alterar os Dados?")
                                .setPositiveButton("Sim", AtualizarUsuario)
                                .setNegativeButton("Não",null)
                                .show();
                    }
                });


            }else {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(PerfilActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Problema interno ao listar !")
                        .setNeutralButton("OK",null)
                        .show();
            }

            }catch(Exception e) {
            System.out.println(e.toString());
            }

    }

}
