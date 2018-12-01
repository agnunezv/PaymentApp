package com.github.agnunezv.paymentapp.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class PaymentMethodModel implements Parcelable {

    private String id;
    private String name;
    private String status;
    private String thumbnail;

    protected PaymentMethodModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        status = in.readString();
        thumbnail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(status);
        dest.writeString(thumbnail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PaymentMethodModel> CREATOR = new Creator<PaymentMethodModel>() {
        @Override
        public PaymentMethodModel createFromParcel(Parcel in) {
            return new PaymentMethodModel(in);
        }

        @Override
        public PaymentMethodModel[] newArray(int size) {
            return new PaymentMethodModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public boolean isActive() {
        return "active".equals(getStatus());
    }
}
