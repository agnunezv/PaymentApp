package com.github.agnunezv.paymentapp.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.agnunezv.paymentapp.R;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;
import com.github.agnunezv.paymentapp.presentation.adapter.PaymentMethodsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentMethodsFragment extends BasePaymentFragment {

    public final static String ARG_PAYMENT_METHODS = "ARG_PAYMENT_METHODS";

    @BindView(R.id.rv_payment_methods)
    RecyclerView rvPaymentMethods;

    public static PaymentMethodsFragment newInstance(ArrayList<PaymentMethodModel> paymentMethodsList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PAYMENT_METHODS, paymentMethodsList);
        PaymentMethodsFragment fragment = new PaymentMethodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paymentmethods, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<PaymentMethodModel> paymentMethodsList = getArguments()
                .getParcelableArrayList(ARG_PAYMENT_METHODS);
        if (paymentMethodsList.isEmpty()) {
            Toast.makeText(getActivity(), getString(R.string.empty_results), Toast.LENGTH_SHORT).show();
        } else {
            rvPaymentMethods.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvPaymentMethods.setAdapter(new PaymentMethodsAdapter(paymentMethodsList, listener));
        }
    }
}
