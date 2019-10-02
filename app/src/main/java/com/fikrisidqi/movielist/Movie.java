package com.fikrisidqi.movielist;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    public String movName;
    public String movDesc;
    public int imageRes;

    protected Movie(Parcel in) {
        movName = in.readString();
        movDesc = in.readString();
        imageRes = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie() {

    }

    public String getMovName() {
        return movName;
    }

    public void setMovName(String movName) {
        this.movName = movName;
    }

    public String getMovDesc() {
        return movDesc;
    }

    public void setMovDesc(String movDesc) {
        this.movDesc = movDesc;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movName);
        parcel.writeString(movDesc);
        parcel.writeInt(imageRes);
    }
}
