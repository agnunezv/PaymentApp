package com.github.agnunezv.paymentapp.data.network;

public class Constants {

    public static final String BASE_URL = "https://api.mercadopago.com/";
    public static final String PUBLIC_KEY = "444a9ef5-8a6b-429f-abdf-587639155d88";
    public static final String VERSION = "v1/";

    //Endpoints
    public static final String PAYMENT_METHODS = "payment_methods";
    public static final String CARD_ISSUERS = "/card_issuers";
    public static final String INSTALLMENTS = "/installments";

    public static final String KEY_PUBLIC_KEY = "public_key";
    public static final String KEY_PAYMENT_METHOD_ID = "payment_method_id";
    public static final String KEY_ISSUER_ID = "issuer.id";
    public static final String KEY_AMOUNT = "amount";
}
