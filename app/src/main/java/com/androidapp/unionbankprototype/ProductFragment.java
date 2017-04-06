package com.androidapp.unionbankprototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Nico on 4/6/2017.
 */

public class ProductFragment extends Fragment {

    @BindView(R.id.image_bills_payment)
    ImageView imageBillsPayment;
    @BindView(R.id.image_check_collection)
    ImageView imageCheckCollection;
    @BindView(R.id.image_business_check_online)
    ImageView imageBusinessCheckOnline;
    @BindView(R.id.image_payroll_suite)
    ImageView imagePayrollSuite;
    @BindView(R.id.image_onehub)
    ImageView imageOnehub;
    @BindView(R.id.image_mmcm)
    ImageView imageMmcm;
    @BindView(R.id.image_ictsi)
    ImageView imageIctsi;
    @BindView(R.id.image_check_writer)
    ImageView imageCheckWriter;
    @BindView(R.id.image_epayroll)
    ImageView imageEpayroll;
    @BindView(R.id.image_electronic_funds_transfer)
    ImageView imageElectronicFundsTransfer;
    @BindView(R.id.image_ecrediting)
    ImageView imageEcrediting;
    @BindView(R.id.image_business_check)
    ImageView imageBusinessCheck;
    @BindView(R.id.image_voucher_payout)
    ImageView imageVoucherPayout;
    @BindView(R.id.image_ushare)
    ImageView imageUshare;
    @BindView(R.id.image_ubiz)
    ImageView imageUbiz;
    @BindView(R.id.image_expanded_check_collections)
    ImageView imageExpandedCheckCollections;
    @BindView(R.id.image_checkhouse)
    ImageView imageCheckhouse;
    @BindView(R.id.image_branch_checkhouse)
    ImageView imageBranchCheckhouse;
    @BindView(R.id.image_electronic_invoice_payment)
    ImageView imageElectronicInvoicePayment;
    @BindView(R.id.image_cash_mobilization)
    ImageView imageCashMobilization;
    @BindView(R.id.image_unioncollect)
    ImageView imageUnioncollect;
    @BindView(R.id.image_corporate_online_banking)
    ImageView imageCorporateOnlineBanking;
    @BindView(R.id.scrollview)
    ScrollView scrollview;
    @BindView(R.id.button_calculate)
    Button buttonCalculate;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        unbinder = ButterKnife.bind(this, view);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.image_bills_payment, R.id.image_check_collection, R.id.image_business_check_online, R.id.image_payroll_suite, R.id.image_onehub, R.id.image_mmcm, R.id.image_ictsi, R.id.image_check_writer, R.id.image_epayroll, R.id.image_electronic_funds_transfer, R.id.image_ecrediting, R.id.image_business_check, R.id.image_voucher_payout, R.id.image_ushare, R.id.image_ubiz, R.id.image_expanded_check_collections, R.id.image_checkhouse, R.id.image_branch_checkhouse, R.id.image_electronic_invoice_payment, R.id.image_cash_mobilization, R.id.image_unioncollect, R.id.image_corporate_online_banking, R.id.scrollview, R.id.button_calculate})
    public void onViewClicked(View view) {
        ProductInformationDialog informationDialog = new ProductInformationDialog();
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.image_bills_payment:
                bundle.putString("title", "Bills Payment");
                break;
            case R.id.image_check_collection:
                bundle.putString("title", "Check Collection");
                break;
            case R.id.image_business_check_online:
                bundle.putString("title", "Business Check Online");
                break;
            case R.id.image_payroll_suite:
                bundle.putString("title", "Payroll Suite");
                break;
            case R.id.image_onehub:
                bundle.putString("title", "OneHub");
                break;
            case R.id.image_mmcm:
                bundle.putString("title", "MMCM");
                break;
            case R.id.image_ictsi:
                bundle.putString("title", "ICTSI Community Card");
                break;
            case R.id.image_check_writer:
                bundle.putString("title", "Check Writer");
                break;
            case R.id.image_epayroll:
                bundle.putString("title", "ePayroll");
                break;
            case R.id.image_electronic_funds_transfer:
                bundle.putString("title", "Electronic Funds Transfer");
                break;
            case R.id.image_ecrediting:
                bundle.putString("title", "eCrediting");
                break;
            case R.id.image_business_check:
                bundle.putString("title", "Business Check");
                break;
            case R.id.image_voucher_payout:
                bundle.putString("title", "Voucher Payout");
                break;
            case R.id.image_ushare:
                bundle.putString("title", "UShare");
                break;
            case R.id.image_ubiz:
                bundle.putString("title", "UBiz");
                break;
            case R.id.image_expanded_check_collections:
                bundle.putString("title", "Expanded Check Collections");
                break;
            case R.id.image_checkhouse:
                bundle.putString("title", "Checkhouse");
                break;
            case R.id.image_branch_checkhouse:
                bundle.putString("title", "Branch Checkhouse");
                break;
            case R.id.image_electronic_invoice_payment:
                bundle.putString("title", "Electronic and Invoice Payment and Presentment (EIPP)");
                break;
            case R.id.image_cash_mobilization:
                bundle.putString("title", "Cash Mobilization");
                break;
            case R.id.image_unioncollect:
                bundle.putString("title", "UnionCollect");
                break;
            case R.id.image_corporate_online_banking:
                bundle.putString("title", "Corporate Online Banking");
                break;
        }
        informationDialog.setArguments(bundle);
        informationDialog.show(getActivity().getFragmentManager(), "Product Information Dialog");
    }
}
