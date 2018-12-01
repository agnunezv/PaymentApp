package com.github.agnunezv.paymentapp.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.agnunezv.paymentapp.R;
import com.github.agnunezv.paymentapp.data.pojo.BankModel;
import com.github.agnunezv.paymentapp.presentation.BanksListViewHolder;
import com.github.agnunezv.paymentapp.presentation.PaymentInterface;

import java.util.List;

public class BanksListAdapter extends RecyclerView.Adapter<BanksListViewHolder> {

    private List<BankModel> banksList;
    private PaymentInterface listener;

    public BanksListAdapter(List<BankModel> bankslist, PaymentInterface listener) {
        this.banksList = bankslist;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BanksListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reyclerview_bank_option, viewGroup, false);
        return new BanksListViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BanksListViewHolder banksListViewHolder, int i) {
        banksListViewHolder.updateViewHolder(banksList.get(i));
    }

    @Override
    public int getItemCount() {
        return banksList.size();
    }
}
