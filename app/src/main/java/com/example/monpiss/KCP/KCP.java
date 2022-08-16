package com.example.monpiss.KCP;

import android.os.Parcel;
import android.os.Parcelable;

public class KCP implements Parcelable {
    private String nameKCP;

    public KCP(String KCPname){
        this.nameKCP = KCPname;
    }

    public KCP() {

    }
    protected KCP(Parcel in) {
        nameKCP = in.readString();
    }

    public static final Creator<KCP> CREATOR = new Creator<KCP>() {
        @Override
        public KCP createFromParcel(Parcel in) {
            return new KCP(in);
        }

        @Override
        public KCP[] newArray(int size) {
            return new KCP[size];
        }
    };


    public String getNameKCP() {
        return nameKCP;
    }

    public void setNameKCP(String nameKCP) {
        this.nameKCP = nameKCP;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameKCP);
    }
}
