package com.github.agnunezv.paymentapp.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.agnunezv.paymentapp.R;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentMethodsViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener {

    @BindView(R.id.iv_credit_card)
    ImageView ivCreditCard;

    @BindView(R.id.tv_credit_card)
    TextView tvCreditCard;

    private PaymentInterface listener;

    public PaymentMethodsViewHolder(@NonNull View itemView, PaymentInterface listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void updateViewHolder(PaymentMethodModel paymentMethodModel) {
        itemView.setTag(paymentMethodModel);
        Picasso.get().load(paymentMethodModel.getThumbnail()).into(ivCreditCard);
        tvCreditCard.setText(paymentMethodModel.getName());
    }

    @Override
    public void onClick(View view) {
        listener.fetchBanksList((PaymentMethodModel) view.getTag());
    }
}
