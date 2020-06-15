package com.example.helpdev2;

import android.os.Parcel;
import android.os.Parcelable;

public class IDClass implements Parcelable{
    private int codigo;


    public IDClass(int codigo) {
        this.codigo = codigo;

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

    }
}
