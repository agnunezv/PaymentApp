package com.github.agnunezv.paymentapp.presentation;

import android.annotation.SuppressLint;

import com.github.agnunezv.paymentapp.data.api.MercadoPagoApi;
import com.github.agnunezv.paymentapp.data.network.Constants;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PaymentPresenter implements PaymentContract.Presenter {

    private PaymentContract.View view;
    private MercadoPagoApi mercadoPagoApi;
    private Map<String, Object> queryMap;
    private Double amountInput;

    public PaymentPresenter(PaymentContract.View view, MercadoPagoApi mercadoPagoApi) {
        this.view = view;
        this.mercadoPagoApi = mercadoPagoApi;
        this.queryMap = new HashMap<>();
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchPaymentMethods(Double amount) {
        this.amountInput = amount;
        queryMap.put(Constants.KEY_PUBLIC_KEY, Constants.PUBLIC_KEY);
        mercadoPagoApi.getPaymentMethods(queryMap).toObservable()
                .flatMapIterable(list -> list)
                .filter(PaymentMethodModel::isActive)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showPaymentMethods, view::onError);
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchBanksList(String paymentMethodId) {
        queryMap.put(Constants.KEY_PAYMENT_METHOD_ID, paymentMethodId);
        mercadoPagoApi.getBanksList(queryMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showBanksList, view::onError);
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchInstallmentsList(String bankId) {
        queryMap.put(Constants.KEY_ISSUER_ID, bankId);
        queryMap.put(Constants.KEY_AMOUNT, amountInput);
        mercadoPagoApi.getInstallments(queryMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showInstallments, view::onError);
    }
}
