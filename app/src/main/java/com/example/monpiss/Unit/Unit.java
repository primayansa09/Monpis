package com.example.monpiss.Unit;

import android.os.Parcel;
import android.os.Parcelable;

public class Unit implements Parcelable {
    private String nameUnit;

    public Unit(String nameUnit) {
        this.nameUnit = nameUnit;
    }

    public Unit() {

    }

    protected Unit(Parcel in) {
        nameUnit = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameUnit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Unit> CREATOR = new Creator<Unit>() {
        @Override
        public Unit createFromParcel(Parcel in) {
            return new Unit(in);
        }

        @Override
        public Unit[] newArray(int size) {
            return new Unit[size];
        }
    };

    public String getNameUnit() {
        return nameUnit;
    }

    public void setNameUnit(String nameUnit) {
        this.nameUnit = nameUnit;
    }

}
