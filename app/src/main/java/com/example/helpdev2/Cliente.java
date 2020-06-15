package com.example.helpdev2;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {
    private int codigo;
    private String nome;


    public Cliente(int codigo,String nome) {
        this.codigo = codigo;
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private Cliente(Parcel p){
        codigo = p.readInt();
        nome = p.readString();
    }

    public static final Parcelable.Creator
            CREATOR = new Parcelable.Creator() {

        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(nome);

    }
}
