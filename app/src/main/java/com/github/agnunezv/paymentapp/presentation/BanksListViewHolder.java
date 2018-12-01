package com.github.agnunezv.paymentapp.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.agnunezv.paymentapp.R;
import com.github.agnunezv.paymentapp.data.pojo.BankModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BanksListViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener {

    @BindView(R.id.iv_bank)
    ImageView ivBank;

    @BindView(R.id.tv_bank)
    TextView tvBank;

    private PaymentInterface listener;

    public BanksListViewHolder(@NonNull View itemView, PaymentInterface listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void updateViewHolder(BankModel bankModel) {
        itemView.setTag(bankModel);
        Picasso.get().load(bankModel.getThumbnail()).into(ivBank);
        tvBank.setText(bankModel.getName());
    }

    @Override
    public void onClick(View view) {
        listener.fetchInstallmentsList((BankModel) view.getTag());
    }
}
