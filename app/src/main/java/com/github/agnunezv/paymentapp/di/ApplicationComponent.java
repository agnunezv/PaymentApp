package com.github.agnunezv.paymentapp.di;

import com.github.agnunezv.paymentapp.PaymentApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface ApplicationComponent {

    void inject(PaymentApplication paymentApplication);

    PaymentComponent newPaymentComponent(PaymentModule paymentModule);
}
