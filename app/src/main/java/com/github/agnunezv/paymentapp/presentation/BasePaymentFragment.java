package com.github.agnunezv.paymentapp.presentation;

import android.content.Context;
import android.support.v4.app.Fragment;

public class BasePaymentFragment extends Fragment {

    protected PaymentInterface listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (PaymentInterface) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement PaymentInterface");
        }
    }
}
