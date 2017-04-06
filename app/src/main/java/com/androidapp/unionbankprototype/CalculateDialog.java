package com.androidapp.unionbankprototype;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Nico on 4/6/2017.
 */

public class CalculateDialog extends DialogFragment {


    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.text_bill_payment_requirement)
    TextView textBillPaymentRequirement;
    @BindView(R.id.text_onehub_requirement)
    TextView textOnehubRequirement;
    @BindView(R.id.text_payroll_suite_requirements)
    TextView textPayrollSuiteRequirements;
    @BindView(R.id.text_adb)
    TextView textAdb;
    Unbinder unbinder;
    @BindView(R.id.text_bills)
    TextView textBills;
    @BindView(R.id.text_payroll)
    TextView textPayroll;
    @BindView(R.id.text_onehub)
    TextView textOnehub;
    String accountType;
    Integer employeeCount;
    Double adb = 0.00;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_calculate, container, false);
        unbinder = ButterKnife.bind(this, view);
        setDialogWindow();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        double classic, customized, premier, premierChecking;
        if (getArguments().getBoolean("bills")) {
            textBills.setVisibility(View.VISIBLE);
            textBills.setText("Bills Payment : 1,000,000 PHP ");
            textBillPaymentRequirement.setText("CMS Master Agreement\n" +
                    "Bills Payment Addendum\n" + "Bills Payment ODS\n");
            textBillPaymentRequirement.setVisibility(View.VISIBLE);
            adb = adb + 1000000.00;
        }
        if (getArguments().getBoolean("payroll")) {
            accountType = getArguments().getString("account");
            employeeCount = getArguments().getInt("count");

            textPayroll.setVisibility(View.VISIBLE);
            textPayrollSuiteRequirements.setText("Corporate:\n" +
                    "CMS Master Agreement\n" +
                    "Payroll Suite Addendum\n" +
                    "Authorized Representatives Form\n" +
                    "Ecrediting Enrollment Form\n" +
                    "Epayonline Enrollment Form (if availing)\n" +
                    "Payroll Suite Operations Data Sheet\n" +
                    "Customized Epaycard Approval Form (if customized)\n" +
                    "\n" +
                    "Employee:\n" +
                    "Customer Account Opening Form\n" +
                    "Photocopy of valid ID");
            textPayrollSuiteRequirements.setVisibility(View.VISIBLE);
            switch (accountType) {
                case "CLASSIC":
                    if (employeeCount > 49) {
                        classic = 9000 * employeeCount;
                        textPayroll.setText("Payroll Suite for " + employeeCount + " " + accountType + ": " + classic);
                        adb = adb + classic;
                    } else {
                        Toast.makeText(getActivity(), "Insufficient Employee", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "CUSTOMIZED":
                    if (employeeCount > 49) {
                        customized = 10000 * employeeCount;
                        textPayroll.setText("Payroll Suite for " + employeeCount + " " + accountType + ": " + customized);
                        adb = adb + customized;
                    } else {
                        Toast.makeText(getActivity(), "Insufficient Employee", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "PREMIER":
                    if (employeeCount > 49) {
                        premier = 12000 * employeeCount;
                        textPayroll.setText("Payroll Suite for " + employeeCount + " " + accountType + ": " + premier);
                        adb = adb + premier;
                    } else {
                        Toast.makeText(getActivity(), "Insufficient Employee", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "PREMIER CHECKING":
                    if (employeeCount > 39) {
                        premierChecking = 20000 * employeeCount;
                        textPayroll.setText("Payroll Suite for " + employeeCount + " " + accountType + ": " + premierChecking + "PHP");
                        adb = adb + premierChecking;
                    } else {
                        Toast.makeText(getActivity(), "Insufficient Employee", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            //adb = adb + 1000000.00;
        }
        if (getArguments().getBoolean("onehub")) {
            textOnehub.setVisibility(View.VISIBLE);
            textOnehubRequirement.setText("OneHub Requirements : n/a");
            textOnehubRequirement.setVisibility(View.VISIBLE);
            if (getArguments().getBoolean("bills") || getArguments().getBoolean("payroll")) {
                textOnehub.setText("OneHub : Free ");
                adb = adb + 0;
            } else {
                textOnehub.setText("OneHub : 1,000,000 PHP ");
                adb = adb + 1000000;
            }

        }

        double amount = Double.parseDouble(String.format("%.2f", adb));
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        textAdb.setText(formatter.format(amount));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setDialogWindow() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = View.MeasureSpec.UNSPECIFIED;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_corner);
        getDialog().getWindow().setDimAmount(0.8f);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimationFromBottom;
    }
}
