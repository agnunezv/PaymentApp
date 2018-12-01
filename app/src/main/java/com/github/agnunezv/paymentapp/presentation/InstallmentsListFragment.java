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
import com.github.agnunezv.paymentapp.data.pojo.InstallmentModel;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;
import com.github.agnunezv.paymentapp.presentation.adapter.InstallmentsListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstallmentsListFragment extends BasePaymentFragment {

    public final static String ARG_INSTALLMENTS_LIST = "ARG_INSTALLMENTS_LIST";

    @BindView(R.id.rv_installments_list)
    RecyclerView rvInstallmentsList;

    public static InstallmentsListFragment newInstance(InstallmentModel installmentModel) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_INSTALLMENTS_LIST, installmentModel);
        InstallmentsListFragment fragment = new InstallmentsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_installmentslist, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InstallmentModel installmentModel = getArguments().getParcelable(ARG_INSTALLMENTS_LIST);

        if (installmentModel.getPayer_costs() == null || installmentModel.getPayer_costs().isEmpty()) {
            Toast.makeText(getActivity(), getString(R.string.empty_results), Toast.LENGTH_SHORT).show();
        } else {
            rvInstallmentsList.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvInstallmentsList.setAdapter(new InstallmentsListAdapter(installmentModel, listener));
        }
    }
}
