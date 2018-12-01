package com.github.agnunezv.paymentapp.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.agnunezv.paymentapp.data.pojo.BankModel;
import com.github.agnunezv.paymentapp.data.pojo.PayerCost;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;

public class ResultsViewModel implements Parcelable {

    private String amountInput;
    private PaymentMethodModel paymentMethodModel;
    private BankModel bankModel;
    private PayerCost payerCost;

    public ResultsViewModel() {
    }

    protected ResultsViewModel(Parcel in) {
        amountInput = in.readString();
        paymentMethodModel = in.readParcelable(PaymentMethodModel.class.getClassLoader());
        bankModel = in.readParcelable(BankModel.class.getClassLoader());
        payerCost = in.readParcelable(PayerCost.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(amountInput);
        dest.writeParcelable(paymentMethodModel, flags);
        dest.writeParcelable(bankModel, flags);
        dest.writeParcelable(payerCost, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResultsViewModel> CREATOR = new Creator<ResultsViewModel>() {
        @Override
        public ResultsViewModel createFromParcel(Parcel in) {
            return new ResultsViewModel(in);
        }

        @Override
        public ResultsViewModel[] newArray(int size) {
            return new ResultsViewModel[size];
        }
    };

    public String getAmountInput() {
        return amountInput;
    }

    public void setAmountInput(String amountInput) {
        this.amountInput = amountInput;
    }

    public PaymentMethodModel getPaymentMethodModel() {
        return paymentMethodModel;
    }

    public void setPaymentMethodModel(PaymentMethodModel paymentMethodModel) {
        this.paymentMethodModel = paymentMethodModel;
    }

    public BankModel getBankModel() {
        return bankModel;
    }

    public void setBankModel(BankModel bankModel) {
        this.bankModel = bankModel;
    }

    public PayerCost getPayerCost() {
        return payerCost;
    }

    public void setPayerCost(PayerCost payerCost) {
        this.payerCost = payerCost;
    }
}
