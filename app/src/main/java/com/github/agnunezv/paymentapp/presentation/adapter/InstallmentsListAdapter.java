package com.github.agnunezv.paymentapp.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.agnunezv.paymentapp.R;
import com.github.agnunezv.paymentapp.data.pojo.InstallmentModel;
import com.github.agnunezv.paymentapp.data.pojo.PayerCost;
import com.github.agnunezv.paymentapp.presentation.InstallmentsListViewHolder;
import com.github.agnunezv.paymentapp.presentation.PaymentInterface;

import java.util.List;

public class InstallmentsListAdapter extends RecyclerView.Adapter<InstallmentsListViewHolder> {

    private List<PayerCost> payerCostList;
    private PaymentInterface listener;

    public InstallmentsListAdapter(InstallmentModel installmentModel, PaymentInterface listener) {
        this.payerCostList = installmentModel.getPayer_costs();
        this.listener = listener;
    }

    @NonNull
    @Override
    public InstallmentsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reyclerview_installment_option, viewGroup, false);
        return new InstallmentsListViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull InstallmentsListViewHolder installmentsListViewHolder, int i) {
        installmentsListViewHolder.updateViewHolder(payerCostList.get(i));
    }

    @Override
    public int getItemCount() {
        return payerCostList.size();
    }
}
