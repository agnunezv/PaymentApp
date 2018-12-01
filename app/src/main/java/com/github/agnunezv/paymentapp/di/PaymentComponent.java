package com.github.agnunezv.paymentapp.di;

import com.github.agnunezv.paymentapp.di.scope.PaymentScope;
import com.github.agnunezv.paymentapp.presentation.PaymentActivity;

import dagger.Subcomponent;

@PaymentScope
@Subcomponent(modules = {PaymentModule.class})
public interface PaymentComponent {
    void inject(PaymentActivity paymentActivity);
}
