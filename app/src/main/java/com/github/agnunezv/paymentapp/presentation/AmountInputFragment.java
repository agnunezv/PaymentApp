package com.github.agnunezv.paymentapp.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.github.agnunezv.paymentapp.R;

import org.apache.commons.lang3.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AmountInputFragment extends BasePaymentFragment {

    @BindView(R.id.et_amount_input)
    EditText etAmountInput;

    public static AmountInputFragment newInstance() {
        return new AmountInputFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amountinput, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_continue)
    public void continueButtonTapped() {
        if (StringUtils.isEmpty(etAmountInput.getText().toString().trim())) {
            etAmountInput.setError(getString(R.string.amount_input_error));
        } else {
            listener.fetchPaymentMethods(etAmountInput.getText().toString());
        }
    }
}
