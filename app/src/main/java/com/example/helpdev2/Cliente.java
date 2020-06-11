package com.example.helpdev2;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {
    private int codigo;


    public Cliente(int codigo) {
        this.codigo = codigo;

    }

    private Cliente(Parcel p){
        codigo = p.readInt();
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

    }
}
