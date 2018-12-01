package com.github.agnunezv.paymentapp.data.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class InstallmentModel implements Parcelable {

    private List<PayerCost> payer_costs;

    protected InstallmentModel(Parcel in) {
        payer_costs = in.createTypedArrayList(PayerCost.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(payer_costs);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<InstallmentModel> CREATOR = new Creator<InstallmentModel>() {
        @Override
        public InstallmentModel createFromParcel(Parcel in) {
            return new InstallmentModel(in);
        }

        @Override
        public InstallmentModel[] newArray(int size) {
            return new InstallmentModel[size];
        }
    };

    public List<PayerCost> getPayer_costs() {
        return payer_costs;
    }
}
