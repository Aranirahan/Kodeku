package com.example.aran.intentku;

import android.os.Parcel;

/**
 * Created by aran on 22/11/17.
 */

public class Parcelable implements android.os.Parcelable {
    int nimMahasiswa;
    String namaMahasiswa;
    String jurusanMahasiswa;
    float ipkMahasiswa;


    public int getNimMahasiswa() {
        return nimMahasiswa;
    }

    public void setNimMahasiswa(int nimMahasiswa) {
        this.nimMahasiswa = nimMahasiswa;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getJurusanMahasiswa() {
        return jurusanMahasiswa;
    }

    public void setJurusanMahasiswa(String jurusanMahasiswa) {
        this.jurusanMahasiswa = jurusanMahasiswa;
    }

    public float getIpkMahasiswa() {
        return ipkMahasiswa;
    }

    public void setIpkMahasiswa(float ipkMahasiswa) {
        this.ipkMahasiswa = ipkMahasiswa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.nimMahasiswa);
        dest.writeString(this.namaMahasiswa);
        dest.writeString(this.jurusanMahasiswa);
        dest.writeFloat(this.ipkMahasiswa);
    }

    public Parcelable() {
    }

    protected Parcelable(Parcel in) {
        this.nimMahasiswa = in.readInt();
        this.namaMahasiswa = in.readString();
        this.jurusanMahasiswa = in.readString();
        this.ipkMahasiswa = in.readFloat();
    }

    public static final android.os.Parcelable.Creator<Parcelable> CREATOR = new android.os.Parcelable.Creator<Parcelable>() {
        @Override
        public Parcelable createFromParcel(Parcel source) {
            return new Parcelable(source);
        }

        @Override
        public Parcelable[] newArray(int size) {
            return new Parcelable[size];
        }
    };
}
