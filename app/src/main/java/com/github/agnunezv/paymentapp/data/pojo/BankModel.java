package com.github.agnunezv.paymentapp.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class BankModel implements Parcelable {

    private String id;
    private String name;
    private String thumbnail;

    protected BankModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        thumbnail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(thumbnail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BankModel> CREATOR = new Creator<BankModel>() {
        @Override
        public BankModel createFromParcel(Parcel in) {
            return new BankModel(in);
        }

        @Override
        public BankModel[] newArray(int size) {
            return new BankModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
