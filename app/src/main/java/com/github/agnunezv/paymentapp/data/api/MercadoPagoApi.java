package com.github.agnunezv.paymentapp.data.api;

import com.github.agnunezv.paymentapp.data.pojo.BankModel;
import com.github.agnunezv.paymentapp.data.pojo.InstallmentModel;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import static com.github.agnunezv.paymentapp.data.network.Constants.CARD_ISSUERS;
import static com.github.agnunezv.paymentapp.data.network.Constants.INSTALLMENTS;
import static com.github.agnunezv.paymentapp.data.network.Constants.PAYMENT_METHODS;
import static com.github.agnunezv.paymentapp.data.network.Constants.VERSION;

public interface MercadoPagoApi {

    @GET(VERSION + PAYMENT_METHODS)
    Single<ArrayList<PaymentMethodModel>> getPaymentMethods(@QueryMap Map<String, Object> params);

    @GET(VERSION + PAYMENT_METHODS + CARD_ISSUERS)
    Single<ArrayList<BankModel>> getBanksList(@QueryMap Map<String, Object> params);

    @GET(VERSION + PAYMENT_METHODS + INSTALLMENTS)
    Single<ArrayList<InstallmentModel>> getInstallments(@QueryMap Map<String, Object> params);
}
