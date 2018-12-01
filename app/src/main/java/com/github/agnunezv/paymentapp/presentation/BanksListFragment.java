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
import com.github.agnunezv.paymentapp.data.pojo.BankModel;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;
import com.github.agnunezv.paymentapp.presentation.adapter.BanksListAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BanksListFragment extends BasePaymentFragment {

    public final static String ARG_BANKS_LIST = "ARG_BANKS_LIST";

    @BindView(R.id.rv_banks_list)
    RecyclerView rvBanksList;

    public static BanksListFragment newInstance(ArrayList<BankModel> banksList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_BANKS_LIST, banksList);
        BanksListFragment fragment = new BanksListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bankslist, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<BankModel> banksList = getArguments().getParcelableArrayList(ARG_BANKS_LIST);
        if (banksList.isEmpty()) {
            Toast.makeText(getActivity(), getString(R.string.empty_results), Toast.LENGTH_SHORT).show();
        } else {
            rvBanksList.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvBanksList.setAdapter(new BanksListAdapter(banksList, listener));
        }
    }
}
