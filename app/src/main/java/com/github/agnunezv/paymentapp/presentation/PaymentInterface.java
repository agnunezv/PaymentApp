package com.github.agnunezv.paymentapp.presentation;

import com.github.agnunezv.paymentapp.data.pojo.BankModel;
import com.github.agnunezv.paymentapp.data.pojo.PayerCost;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;

public interface PaymentInterface {

    void fetchPaymentMethods(String amount);

    void fetchBanksList(PaymentMethodModel paymentMethodModel);

    void fetchInstallmentsList(BankModel bankModel);

    void showResults(PayerCost payerCost);

    void goBackToFirstStep();
}
