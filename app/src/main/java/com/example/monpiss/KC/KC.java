package com.example.monpiss.KC;

import android.os.Parcel;
import android.os.Parcelable;

public class KC implements Parcelable {

    private String KCname;

    public KC(String KCname) {
        this.KCname = KCname;
    }

    public KC() {

    }

    protected KC(Parcel in) {
        KCname = in.readString();
    }

    public static final Creator<KC> CREATOR = new Creator<KC>() {
        @Override
        public KC createFromParcel(Parcel in) {
            return new KC(in);
        }

        @Override
        public KC[] newArray(int size) {
            return new KC[size];
        }
    };

    public String getKCname() {
        return KCname;
    }

    public void setKCname(String KCname) {
        this.KCname = KCname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(KCname);
    }
}
