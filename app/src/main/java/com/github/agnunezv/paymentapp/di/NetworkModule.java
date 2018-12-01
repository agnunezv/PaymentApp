package com.github.agnunezv.paymentapp.di;

import com.github.agnunezv.paymentapp.data.api.MercadoPagoApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.github.agnunezv.paymentapp.data.network.Constants.BASE_URL;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    MercadoPagoApi getMercadoPagoApi(Retrofit retrofit) {
        return retrofit.create(MercadoPagoApi.class);
    }
}
