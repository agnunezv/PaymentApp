package com.github.agnunezv.paymentapp;

import android.app.Application;

import com.github.agnunezv.paymentapp.di.ApplicationComponent;
import com.github.agnunezv.paymentapp.di.DaggerApplicationComponent;
import com.github.agnunezv.paymentapp.di.NetworkModule;

public class PaymentApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule())
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
