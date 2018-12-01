package com.github.agnunezv.paymentapp.di;

import com.github.agnunezv.paymentapp.data.api.MercadoPagoApi;
import com.github.agnunezv.paymentapp.di.scope.PaymentScope;
import com.github.agnunezv.paymentapp.presentation.PaymentContract;
import com.github.agnunezv.paymentapp.presentation.PaymentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PaymentModule {

    private final PaymentContract.View view;

    public PaymentModule(PaymentContract.View view) {
        this.view = view;
    }

    @PaymentScope
    @Provides
    PaymentPresenter provideMovieListPresenter(MercadoPagoApi mercadoPagoApi) {
        return new PaymentPresenter(view, mercadoPagoApi);
    }
}
