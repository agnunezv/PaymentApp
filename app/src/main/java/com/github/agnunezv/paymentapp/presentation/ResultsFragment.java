package com.github.agnunezv.paymentapp.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.agnunezv.paymentapp.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultsFragment extends BasePaymentFragment {

    public final static String ARG_RESULTS_VIEWMODEL = "ARG_RESULTS_VIEWMODEL";

    @BindView(R.id.tv_amount_value)
    TextView tvAmountValue;

    @BindView(R.id.iv_credit_card)
    ImageView ivCreditCard;

    @BindView(R.id.tv_credit_card)
    TextView tvCreditCard;

    @BindView(R.id.iv_bank)
    ImageView ivBank;

    @BindView(R.id.tv_bank_value)
    TextView tvBankValue;

    @BindView(R.id.tv_installment_value)
    TextView tvInstallmentValue;

    @BindView(R.id.tv_installment_description_value)
    TextView tvInstallmentDescriptionValue;

    public static ResultsFragment newInstance(ResultsViewModel resultsViewModel) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_RESULTS_VIEWMODEL, resultsViewModel);
        ResultsFragment fragment = new ResultsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ResultsViewModel resultsViewModel = getArguments()
                .getParcelable(ARG_RESULTS_VIEWMODEL);

        tvAmountValue.setText(resultsViewModel.getAmountInput());
        tvCreditCard.setText(resultsViewModel.getPaymentMethodModel().getName());
        tvBankValue.setText(resultsViewModel.getBankModel().getName());
        tvInstallmentValue.setText(String.valueOf(resultsViewModel.getPayerCost().getInstallments()));
        tvInstallmentDescriptionValue.setText(resultsViewModel.getPayerCost().getRecommended_message());

        Picasso.get().load(resultsViewModel.getPaymentMethodModel().getThumbnail()).into(ivCreditCard);
        Picasso.get().load(resultsViewModel.getBankModel().getThumbnail()).into(ivBank);
    }

    @OnClick(R.id.btn_back)
    public void backButtonTapped() {
        listener.goBackToFirstStep();
    }
}
