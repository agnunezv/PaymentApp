package com.github.agnunezv.paymentapp.presentation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.github.agnunezv.paymentapp.PaymentApplication;
import com.github.agnunezv.paymentapp.R;
import com.github.agnunezv.paymentapp.data.pojo.BankModel;
import com.github.agnunezv.paymentapp.data.pojo.InstallmentModel;
import com.github.agnunezv.paymentapp.data.pojo.PayerCost;
import com.github.agnunezv.paymentapp.data.pojo.PaymentMethodModel;
import com.github.agnunezv.paymentapp.di.PaymentModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class PaymentActivity extends AppCompatActivity
        implements PaymentContract.View, PaymentInterface {

    @Inject
    PaymentPresenter paymentPresenter;

    private MaterialDialog dialog;
    private ResultsViewModel resultsViewModel = new ResultsViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((PaymentApplication) getApplication())
                .getApplicationComponent()
                .newPaymentComponent(new PaymentModule(this))
                .inject(this);

        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        dialog = new MaterialDialog.Builder(this)
                .cancelable(false).content(R.string.dialog_message).build();

        handleShownFragment(AmountInputFragment.newInstance(), false);
    }

    @Override
    public void fetchPaymentMethods(String amount) {
        dialog.show();
        paymentPresenter.fetchPaymentMethods(Double.valueOf(amount));
        resultsViewModel.setAmountInput(amount);
    }

    @Override
    public void showPaymentMethods(List<PaymentMethodModel> paymentMethods) {
        dialog.hide();
        handleShownFragment(PaymentMethodsFragment.newInstance(new ArrayList<>(paymentMethods)), true);
    }

    @Override
    public void fetchBanksList(PaymentMethodModel paymentMethodModel) {
        dialog.show();
        paymentPresenter.fetchBanksList(paymentMethodModel.getId());
        resultsViewModel.setPaymentMethodModel(paymentMethodModel);
    }

    @Override
    public void showBanksList(ArrayList<BankModel> banksList) {
        dialog.hide();
        handleShownFragment(BanksListFragment.newInstance(banksList), true);
    }

    @Override
    public void fetchInstallmentsList(BankModel bankModel) {
        dialog.show();
        paymentPresenter.fetchInstallmentsList(bankModel.getId());
        resultsViewModel.setBankModel(bankModel);
    }

    @Override
    public void showInstallments(ArrayList<InstallmentModel> installmentsList) {
        dialog.hide();
        handleShownFragment(InstallmentsListFragment.newInstance(installmentsList.get(0)), true);
    }

    @Override
    public void showResults(PayerCost payerCost) {
        resultsViewModel.setPayerCost(payerCost);
        handleShownFragment(ResultsFragment.newInstance(resultsViewModel), true);
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(this, getString(R.string.toast_error_message), Toast.LENGTH_SHORT).show();
    }

    private void handleShownFragment(Fragment fragmentToBeShown, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragments_container,
                fragmentToBeShown);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void goBackToFirstStep() {
        getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        handleShownFragment(AmountInputFragment.newInstance(), false);
    }
}
