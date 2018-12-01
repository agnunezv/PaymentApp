package com.github.agnunezv.paymentapp.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.agnunezv.paymentapp.R;
import com.github.agnunezv.paymentapp.data.pojo.PayerCost;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstallmentsListViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener {

    @BindView(R.id.tv_installment_value)
    TextView tvInstallmentValue;

    @BindView(R.id.tv_installment_description_value)
    TextView tvInstallmentDescription;

    private PaymentInterface listener;

    public InstallmentsListViewHolder(@NonNull View itemView, PaymentInterface listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void updateViewHolder(PayerCost payerCost) {
        itemView.setTag(payerCost);
        tvInstallmentValue.setText(payerCost.getInstallments().toString());
        tvInstallmentDescription.setText(payerCost.getRecommended_message());
    }

    @Override
    public void onClick(View view) {
        listener.showResults((PayerCost) view.getTag());
    }
}
