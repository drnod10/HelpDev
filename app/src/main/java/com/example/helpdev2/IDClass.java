package com.example.helpdev2;

import android.os.Parcel;
import android.os.Parcelable;

public class IDClass implements Parcelable{

    private int codigo;
    private String nome;


    public IDClass(int codigo) {
        this.codigo = codigo;
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private IDClass(Parcel p){
        codigo = p.readInt();
    }

    public static final Parcelable.Creator
            CREATOR = new Parcelable.Creator() {

        public IDClass createFromParcel(Parcel in) {
            return new IDClass(in);
        }

        public IDClass[] newArray(int size) {
            return new IDClass[size];
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
