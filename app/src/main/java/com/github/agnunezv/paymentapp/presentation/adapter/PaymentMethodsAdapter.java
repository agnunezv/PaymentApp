package com.github.agnunezv.paymentapp.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.agnunezv.paymentapp.R;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;
import com.github.agnunezv.paymentapp.presentation.PaymentInterface;
import com.github.agnunezv.paymentapp.presentation.PaymentMethodsViewHolder;

import java.util.List;

public class PaymentMethodsAdapter extends RecyclerView.Adapter<PaymentMethodsViewHolder> {

    private List<PaymentMethodModel> paymentMethodsList;
    private PaymentInterface listener;

    public PaymentMethodsAdapter(List<PaymentMethodModel> paymentMethodsList, PaymentInterface listener) {
        this.paymentMethodsList = paymentMethodsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PaymentMethodsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reyclerview_paymentmethod_option, viewGroup, false);
        return new PaymentMethodsViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMethodsViewHolder paymentMethodsViewHolder, int i) {
        paymentMethodsViewHolder.updateViewHolder(paymentMethodsList.get(i));
    }

    @Override
    public int getItemCount() {
        return paymentMethodsList.size();
    }
}
