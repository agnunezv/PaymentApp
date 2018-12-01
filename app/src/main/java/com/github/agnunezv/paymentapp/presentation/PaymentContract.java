package com.github.agnunezv.paymentapp.presentation;

import com.github.agnunezv.paymentapp.data.pojo.BankModel;
import com.github.agnunezv.paymentapp.data.pojo.InstallmentModel;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;

import java.util.ArrayList;
import java.util.List;

public interface PaymentContract {

    interface View {

        void showPaymentMethods(List<PaymentMethodModel> paymentMethods);

        void showBanksList(ArrayList<BankModel> banksList);

        void showInstallments(ArrayList<InstallmentModel> installmentsList);

        void onError(Throwable throwable);

    }

    interface Presenter {

        void fetchPaymentMethods(Double amountInput);

        void fetchBanksList(String paymentMethodId);

        void fetchInstallmentsList(String bankId);
    }
}
