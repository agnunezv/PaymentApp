package com.github.agnunezv.paymentapp.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class PayerCost implements Parcelable {

    private Integer installments;
    private String recommended_message;

    protected PayerCost(Parcel in) {
        if (in.readByte() == 0) {
            installments = null;
        } else {
            installments = in.readInt();
        }
        recommended_message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (installments == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(installments);
        }
        dest.writeString(recommended_message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PayerCost> CREATOR = new Creator<PayerCost>() {
        @Override
        public PayerCost createFromParcel(Parcel in) {
            return new PayerCost(in);
        }

        @Override
        public PayerCost[] newArray(int size) {
            return new PayerCost[size];
        }
    };

    public Integer getInstallments() {
        return installments;
    }

    public String getRecommended_message() {
        return recommended_message;
    }
}
