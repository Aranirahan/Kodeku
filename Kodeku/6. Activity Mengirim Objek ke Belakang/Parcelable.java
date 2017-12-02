package com.ngoding.aran.activitymengirimobjekkebelakang;

import android.os.Parcel;

/**
 * Created by aran on 01/12/17.
 */

public class Parcelable implements android.os.Parcelable {
    private String data1;
    private String data2;
    private int data3;
    private int data4;

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public int getData3() {
        return data3;
    }

    public void setData3(int data3) {
        this.data3 = data3;
    }

    public int getData4() {
        return data4;
    }

    public void setData4(int data4) {
        this.data4 = data4;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.data1);
        dest.writeString(this.data2);
        dest.writeInt(this.data3);
        dest.writeInt(this.data4);
    }

    public Parcelable() {
    }

    protected Parcelable(Parcel in) {
        this.data1 = in.readString();
        this.data2 = in.readString();
        this.data3 = in.readInt();
        this.data4 = in.readInt();
    }

    public static final Creator<Parcelable> CREATOR = new Creator<Parcelable>() {
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
