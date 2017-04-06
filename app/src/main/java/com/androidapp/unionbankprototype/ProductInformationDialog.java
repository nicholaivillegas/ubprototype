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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Nico on 4/6/2017.
 */

public class ProductInformationDialog extends DialogFragment {

    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.text_product_description)
    TextView textProductDescription;
    Unbinder unbinder;
    @BindView(R.id.text_key_features)
    TextView textKeyFeatures;
    @BindView(R.id.text_standard_price)
    TextView textStandardPrice;
    @BindView(R.id.text_standard_onboards)
    TextView textStandardOnboards;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_product_information, container, false);
        unbinder = ButterKnife.bind(this, view);
        setDialogWindow();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments().getString("title").equals("Bills Payment")) {
            textTitle.setText("Bills Payment");
            textKeyFeatures.setText("• Real-time collection report (Customizable)\n" +
                    "• CWT Generation and printing\n" +
                    "• Wide range of channels, partners\n");
            textStandardPrice.setText("ADB: \n1,000,000 PHP\n\n" +
                    "Fees: \n" +
                    "OTC - 15PHP/transaction\n" +
                    "Electronic channels/uMobile - FREE\n" +
                    "Partner Pay (C2B) - 15PHP\n" +
                    "Partner Pay (B2B) - 60PHP\n" +
                    "G-Cash - 20PHP\n" +
                    "Inward Collect - 10USD\n");
            textStandardOnboards.setText("20 banking days");
            textProductDescription.setText("Collection of payments from individuals or other businesses through multiple Unionbank channels -- OTC, uMobile eBanking, AutoDebitArrangement, Batch Bills Payment, PartnerPay\n");
        } else if (getArguments().getString("title").equals("Check Collection")) {
            textTitle.setText("Check Collection");
            textKeyFeatures.setText("• Check Collection and Document Delivery - Reduce / Eliminate admin cost\n" +
                    "• Security of Documents - Used of locked pouch bags while in transit\n");
            textStandardPrice.setText("ADB:\n" +
                    "1,000,000 per pick-up locations\n\n" +
                    "Fees:\n" +
                    "PHP220 / Trip\n");
            textStandardOnboards.setText("7 banking days*\n" +
                    "*Standard servicing");
            textProductDescription.setText("Daily collections of current-dated checks from a designated pick-up location for deposit to Clients UnionBank account\n");
        } else if (getArguments().getString("title").equals("Business Check Online")) {
            textTitle.setText("Business Check Online");
            textKeyFeatures.setText("•Simplifies and automates\n" +
                    "•Saves time and manpower\n" +
                    "•Cuts errors\n");
            textStandardPrice.setText("Per check: 6PHP\n" + "\nADB (BCO): 1,000,000\n");
            textStandardOnboards.setText("n/a");
            textProductDescription.setText("A check writing software which allows you to streamline and simplify your check disbursement process from the comfort of your office.\n");
        } else if (getArguments().getString("title").equals("Payroll Suite")) {
            textTitle.setText("Payroll Suite");
            textKeyFeatures.setText("• Batch account opening: data extraction, BAO template, ePayonline \n" +
                    "• Same day account generation, 3-5 days card production\n" +
                    "• Customizable card design\n" +
                    "• Executive payroll (Business Class)\n" +
                    "• Online bulk crediting\n" +
                    "• Auto enrolled to SMS Payroll alert & uMobile\n" +
                    "• Access in Online Banking\n" +
                    "• Visa functionality for online & POS payments\n" +
                    "• GetGo rewards earning\n" +
                    "• WAP: salary, auto and housing loans\n" +
                    "• SSS UMID ATM activation");
            textStandardPrice.setText("WAIVED ADB Pricing for companies with minimum 100 employees who are VISA transactors (classic & customized variants only)\n" +
                    "\n" +
                    "Classic - P9k per head, minimum P450k\n" +
                    "Customized - P10k per head, minimum P500k\n" +
                    "Premier - P12k per head, minimum P600k\n" +
                    "Premier Checking - P20k per head, minimum P800k\n" +
                    "");
            textStandardOnboards.setText("Classic - 5-7 banking days \n" +
                    "Customized - 1 month (due to internal & Visa approvals)");
            textProductDescription.setText("An end-to-end solution that allows you to disburse payroll to your employees and agents in a convenient and cost efficient way.");
        } else if (getArguments().getString("title").equals("OneHub")) {
            textTitle.setText("OneHub");
            textKeyFeatures.setText("• To access the BIR eFPS, SSS, Philhealth  \n • To file your premium contributions, loan payments, tax returns \n • To view and initiate all pending payments\n");
            textStandardPrice.setText("ADB : \n 1,000,000 PHP \n\n *standalone");
            textStandardOnboards.setText("n/a");
            textProductDescription.setText("OneHub.Gov is the first and only single platform that enables your company to pay its obligations with the BIR, SSS and Philhealth. OneHub.Gov is simple, fast, and an efficient way to settle all your obligations to the government! \n");
        } else if (getArguments().getString("title").equals("MMCM")) {
            textTitle.setText("MMCM");
            textKeyFeatures.setText("Disbursement \n" +
                    "• PowerPay Kit\n" +
                    "• Near time Crediting (2 hours cut off time: 4pm)                                                      \n" +
                    "Collection\n" +
                    "• Customizable reports\n" +
                    "• Pay bills anytime, anywhere with any mobile phone with a globe sim\n" +
                    "• Next day crediting\n");
            textStandardPrice.setText("Disbursement\n" +
                    "• P50/Powerpay kit\n" +
                    "• P10/Credit\n" +
                    "Collection\n" +
                    "• P20/Transaction\n");
            textStandardOnboards.setText("Disbursement\n" +
                    "• 5-10 banking days\n" +
                    "");
            textProductDescription.setText("Mobile money facility of UnionBank in partnership with Globe Gcash. MMCM collection facility can be used for bills payment. Customers pay thru any mobile phone with a globe sim using Globe's USSD Facility. MMCM Disbursement can be used for any payout (loans, payroll) with the use of powerpay kit - Gcash's Bancnet ATM Card");
        } else if (getArguments().getString("title").equals("ICTSI Community Card")) {
            textTitle.setText("ICTSI Community Card");
            textKeyFeatures.setText("•Payments only to ICTSI\n" +
                    "•No withdrawals, Inquiry only\n");
            textStandardPrice.setText("Free\n");
            textStandardOnboards.setText("3-5 banking days");
            textProductDescription.setText("Debit Card that can only be used for ICTSI Payments");
        } else if (getArguments().getString("title").equals("Checkwriter")) {
            textTitle.setText("Check Writer");
            textKeyFeatures.setText("\n• Easy integration with the company's AP system\n" +
                    "• Nationwide printing & releasing\n" +
                    "• System-generated reports\n" +
                    "• Email notifications to company users; Online resetting of passwords");
            textStandardPrice.setText("\nManagers Checks: P20M Disbursement Volume/month with 100 free checks\n" +
                    "Corporate Checks: P5M CASA ADB with 100 free checks\n" +
                    "In excess of the free checks, there's a charge of P25/check (back to client) or P30/check (UnionBank releasing)\n" +
                    "*Please look at sales kit for the detailed pricing list.");
            textStandardOnboards.setText("\n15 banking days");
            textProductDescription.setText("Outsource check printing and releasing to UnionBank. Can be in the form of Manager's Checks or Corporate Checks");
        } else if (getArguments().getString("title").equals("ePayroll")) {
            textTitle.setText("ePayroll");
            textKeyFeatures.setText("•Flexible payroll system - Customizations can be programmed to suit client requirements\n" +
                    "• Automated payroll computation and processing with data entry/upload via front end module\n" +
                    "• Pre-enrolled user access and access rights\n" +
                    "• Password-protected payroll files\n" +
                    "• Generation of Payroll, Accounting, and Government Reports\n" +
                    "• Electronic payslips\n");
            textStandardPrice.setText("1-500 employees - 85/emp/run (standard), 60/emp/run (floor), minimum pricing of 100 employees\n" +
                    "501-1000 employees - 65/emp/run (standard), 50/emp/run (floor)\n" +
                    "1001 or more - 45/emp/run (standard), 35/emp/run (floor)\n");
            textStandardOnboards.setText("1 to 2 months, depending on the client's required setup");
            textProductDescription.setText("An OSP-assisted payroll processing facility that computes net pay, generates payslips, and produces reports for internal use and government payments - Must be bundled with Payroll Suite\n");
        } else if (getArguments().getString("title").equals("Electronic Funds Transfer")) {
            textTitle.setText("Electronic Funds Transfer");
            textKeyFeatures.setText("•ONLINE FACILITY FOR CONVENIENT ACCESS ANYTIME ANYWHERE\n" +
                    "• LOCAL AND INTERNATIONAL FUND TRANSFERS THROUGH EPCS, PDDTS AND SWIFT\n" +
                    "• SEND FUNDS OF DIFFERENT CURRENCIES ONLINE VIA SWIFT\n" +
                    "• CURRENCIES INCLUDED: USD, AUD, EUR, GBP, JPY, SGD, HKD, CAD\n");
            textStandardPrice.setText("ADB - 1M\n" +
                    "Fees:\n" +
                    "EPCS - 100\n" +
                    "PDDTS - 100\n" +
                    "SWIFT-USD, SHA - 10USD\n" +
                    "SWIFT-USD, OUR - 15USD\n" +
                    "SWIFT-THIRDS, SHA - 20USD\n" +
                    "SWIFT-THIRDS, OUR - 30USD\n");
            textStandardOnboards.setText("n/a");
            textProductDescription.setText("A single online platform for various types of fund transfer transactions\n");
        } else if (getArguments().getString("title").equals("eCrediting")) {
            textTitle.setText("eCrediting");
            textKeyFeatures.setText("Online crediting facility\n" +
                    "Multiple payments to your payees\n" +
                    "Efficient and timely\n");
            textStandardPrice.setText("FREE with ePaycard\n" +
                    "ADB: 3M\n" +
                    "Fee: \n" +
                    "-15php for transactions in excess of 500 per month\n" +
                    "-1.5 per credit for SMS notification\n");
            textStandardOnboards.setText("20 banking days\n");
            textProductDescription.setText("A single debit-multiple crediting facility that enables corporate clients of the Bank to credit multiple payments or remittances to its employees/ customers/ or partners in an efficient and timely manner. \n");
        } else if (getArguments().getString("title").equals("Business Check")) {
            textTitle.setText("Business Check");
            textKeyFeatures.setText("•Simplifies and automates\n" +
                    "• Saves time and manpower\n" +
                    "• Cuts errors\n");
            textStandardPrice.setText("Per check: 6PHP\n" +
                    "ADB (BC): 100K\n" +
                    "ADB (BCO): 1M\n");
            textStandardOnboards.setText("n/a");
            textProductDescription.setText("A check writing software which allows you to streamline and simplify your check disbursement process from the comfort of your office.\n");
        } else if (getArguments().getString("title").equals("Voucher Payout")) {
            textTitle.setText("Voucher Payout");
            textKeyFeatures.setText("•Online facility for convenient access anytime, anywhere\n" +
                    "• Realtime encashment\n" +
                    "• Less costly compared to other alternatives\n");
            textStandardPrice.setText("ADB (PHP): 3M\n" +
                    "Fee (PHP): 100PHP\n" +
                    "ADB (USD): 100K\n" +
                    "Fee (USD): 3USD\n");
            textStandardOnboards.setText("n/a");
            textProductDescription.setText("A payout facility that enables clients to outsource dollar and peso disbursements via the UnionBank branches.\n");
        } else if (getArguments().getString("title").equals("UShare")) {
            textTitle.setText("UShare");
            textKeyFeatures.setText("• Real-time web-based integrated dashboard for collections \n" +
                    "• Payment Integration\n" +
                    "• Access to non-UBP payment options (Visa, Mastercard\n");
            textStandardPrice.setText("Button Package - Php 300,000 ADB\n" +
                    "Templated Package - Php 500,000 ADB\n" +
                    "Customized Package - Php 1,000,000 ADB \n" +
                    "\n" +
                    "Fees: \n" +
                    "Credit Cards (Mastercard or VISA) - 5% + 0.5% tax \n" +
                    "Dragon Pay (Local Direct Bank Debit, OTC, or Non-Traditional Banks) - Php 10 (online), Php 15 (bank-OTC), Php 20 (non-bank OTC)\n");
            textStandardOnboards.setText("Button Package - 1 month\n" +
                    "Templated Package - 1-2 months\n" +
                    "Customized Package - 2-3 months ");
            textProductDescription.setText("UShare is an innovative and end-to-end solution, which has been tailor-fitted to address the online payment collection and account information management solutions of non-profit organizations, leveraging on the power of online payment channels to reach potential international and local donors.\n");
        } else if (getArguments().getString("title").equals("UBiz")) {
            textTitle.setText("UBiz");
            textKeyFeatures.setText("• Real-time web-based integrated dashboard for collections \n" +
                    "• Payment Integration\n" +
                    "• Access to non-UBP payment options (Visa, Mastercard) \n");
            textStandardPrice.setText("Standard - Php 1,000,000 ADB\n" +
                    "\n" +
                    "Fees: \n" +
                    "Credit Cards (Mastercard or VISA) - 5% + 0.5% tax (Rate \n" +
                    "Dragon Pay (Local Direct Bank Debit, OTC, or Non-Traditional Banks) - Php 10 (online), Php 15 (bank-OTC), Php 20 (non-bank OTC)\n");
            textStandardOnboards.setText("Standard - 1-2 months ");
            textProductDescription.setText("UBiz is an online payment solution, custom-fitted for eCommerce websites that would like to sell their goods and / or services online, but do not have the secure and reliable platform for it. This service will help online retailers leverage on the power of online payment channels to reach potential customers both local and abroad. \n" +
                    "");
        } else if (getArguments().getString("title").equals("Expanded Check Collections")) {
            textTitle.setText("Expanded Check Collections");
            textKeyFeatures.setText("• Comprehensive Reports - Can be customized based on the requirements of the the Clients\n" +
                    "• Nationwide Collection - Facility can service nationwide\n" +
                    "• Process Flexibility - Can customized the process of collecting based on the requirements of the Client\n");
            textStandardPrice.setText("ADB:\n" +
                    "16,000,000 - 100 Trips\n" +
                    "9,000,000 - 50 Trips\n" +
                    "\n" +
                    "Fees:\n" +
                    "Per Checks - PHP150\n" +
                    "Per OR - PHP55\n" +
                    "Per Invoice - PHP15\n");
            textStandardOnboards.setText("1 week* upon the completion of the following:\n" +
                    "\n" +
                    "-Process Guidelines\n" +
                    "-Operations Data Sheet\n" +
                    "-Remittance of OR booklets\n" +
                    "-Addendum\n" +
                    "-ICR (If any)\n" +
                    "\n" +
                    "*Standard servicing");
            textProductDescription.setText("Check Collections facility with an itinerary management system and consolidated reports\n");
        } else if (getArguments().getString("title").equals("Checkhouse")) {
            textTitle.setText("Checkhouse");
            textKeyFeatures.setText("• Comprehensive Collection Reports - Download multiple types of reports that is based on the preference of the client\n" +
                    "• Check Image Viewing - Checks can be viewed by the Clients once accepted for warehousing\n" +
                    "• Decentralized Warehousing - Caters to the geographical warehousing locations of the Clients\n");
            textStandardPrice.setText("ADB:\n" +
                    "3,000,000 - 100 Checks\n" +
                    "\n" +
                    "Fees:\n" +
                    "Per Check - PHP15\n" +
                    "Per Special Handling - PHP25\n" +
                    "Per Rush Request - PHP100\n");
            textStandardOnboards.setText("15 banking days*\n" +
                    "\n" +
                    "*Standard servicing");
            textProductDescription.setText("Bank outsourced check warehousing facility with an online system to manage and monitor PDCs efficiently\n");
        } else if (getArguments().getString("title").equals("Branch Checkhouse")) {
            textTitle.setText("Branch Checkhouse");
            textKeyFeatures.setText("• Comprehensive Collection Reports - Download multiple types of reports that is based on the preference of the client\n" +
                    "• Check Image Viewing - Checks can be viewed by the Clients once accepted for warehousing\n" +
                    "• Decentralized Warehousing - Caters to the geographical warehousing locations of the Clients\n");
            textStandardPrice.setText("ADB:\n" +
                    "1,000,000 - 50 Checks - Client encoding\n" +
                    "2,000,000 - 50 Checks - Bank encoding\n" +
                    "\n" +
                    "Fees:\n" +
                    "Per Check - PHP15\n" +
                    "Per Special Handling - PHP25\n" +
                    "Per Rush Request - PHP100\n");
            textStandardOnboards.setText("15 banking days*\n" +
                    "\n" +
                    "*Standard servicing");
            textProductDescription.setText("Branch check warehousing facility with an online system to manage and monitor PDCs efficiently\n");
        } else if (getArguments().getString("title").equals("Electronic and Invoice Payment and Presentment (EIPP)")) {
            textTitle.setText("Electronic and Invoice Payment and Presentment (EIPP)");
            textKeyFeatures.setText("• Deductions tagging - Distributors can be tagged on a per invoice level\n" +
                    "• 10 additional fields - Principal / Distributors can capture up to 10 additional fields");
            textStandardPrice.setText("Standard EIPP System: 3,000,000\n" +
                    "Payment Channel: Over-the-Counter - 3,000,000 +15/transaction\n" +
                    "Payment Channel: Expanded Check Collections with 120 free trips (1 Check, 1 OR) - 14,000,000 +165/excess\n" +
                    "\n" +
                    "500,000 per customization\n");
            textStandardOnboards.setText("15 banking days*\n" +
                    "\n" +
                    "*Standard servicing\n");
            textProductDescription.setText("Online invoice presentment with nationwide payment collections and comprehensive reports\n");
        } else if (getArguments().getString("title").equals("Cash Mobilization")) {
            textTitle.setText("Cash Mobilization");
            textKeyFeatures.setText("• Cash is secured in locked bag with 2 security guard escorts and armed driver\n" +
                    "• Nationwide collections thru 7 Cash Centers and 14 Branches\n" +
                    "• Same day posting of cash deposits to your account\n");
            textStandardPrice.setText("Weekday - Fee: P1,000/trip, ADB: P2MM/trip/week\n" +
                    "Weened  - Fee:  P1,500/trip, ADB: 3MM/trip/week\n");
            textStandardOnboards.setText("10 banking days");
            textProductDescription.setText("A secure onsite pick-up of cash for deposit service and/or delivery of cash requirements to your office through an Armored Truck Team\n");
        } else if (getArguments().getString("title").equals("UnionCollect")) {
            textTitle.setText("UnionCollect");
            textKeyFeatures.setText("•Outsourced tellering and cashiering service for high transaction volume periods\n");
            textStandardPrice.setText("Weekday - Fee: P3,000/teller/day, ADB: P8MM/teller/day/week\n" +
                    "Weened  - Fee:  P4.000/teller/dau, ADB: P10MM/teller/day/week\n");
            textStandardOnboards.setText("30 banking days");
            textProductDescription.setText("Deployment of a dedicated bank personnel to corporate client’s office to accept collections directly from client’s payors.\n");
        } else if (getArguments().getString("title").equals("Corporate Online Banking")) {
            textTitle.setText("Corporate Online Banking");
            textKeyFeatures.setText("(1) View accounts and download statements with basic references\n" +
                    "(2) Do transfers to own, other UnionBank accounts, and even peso accounts with other local Banks\n" +
                    "(3) Do bills payment to bank-accredited billers\n" +
                    "(4) Send your payroll file for batch processing\n");
            textStandardPrice.setText("Free\n");
            textStandardOnboards.setText("3-5 banking days");
            textProductDescription.setText("Basic electronic banking service from UnionBank for Corporate or Business Clients.\n");
        }
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
