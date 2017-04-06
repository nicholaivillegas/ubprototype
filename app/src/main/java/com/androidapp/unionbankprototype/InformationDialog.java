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

/**
 * Created by Nico on 3/31/2017.
 */

public class InformationDialog extends DialogFragment {

    private TextView textTitle, textLocation, textPhone, textBankingHours, textDescription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_information, container, false);
        textTitle = (TextView) view.findViewById(R.id.text_title);
        textLocation = (TextView) view.findViewById(R.id.text_location);
        textPhone = (TextView) view.findViewById(R.id.text_phone);
        textBankingHours = (TextView) view.findViewById(R.id.text_banking);
        textDescription = (TextView) view.findViewById(R.id.text_description);
        setDialogWindow();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments().getString("title").equals("UnionBank Plaza")) {
            textTitle.setText("UnionBank Plaza");
            textLocation.setText("UnionBank Plaza Bldg., Meralco Ave. corner Onyx St., Ortigas Center, Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)944 8041-43; (02)944 8128-29; (02)634 1602 / 7907; (02)585 1019; Local: 8129 / 8042 / 8128; Mobile: 0917 8270559\n" +
                    "Fax: (02)633-7929; (02)944-8043");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Greenhills")) {
            textTitle.setText("Greenhills");
            textLocation.setText("9th Avenue near corner Rizal Avenue, Grace Park, Kalookan City (ATM: On-site)");
            textPhone.setText("Tel: (02)361-1165; (02)366-9785; (02)623-6365; Mobile: 0917-8270396; 0917-8270560\n" +
                    "Fax: (02)361-3755");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Tomas Morato")) {
            textTitle.setText("Tomas Morato");
            textLocation.setText("Tomas Morato cor. Sct. Lozano, Quezon City (ATM: On-site)");
            textPhone.setText("Tel: (02)928-5801; Mobile: 0917 8270498\n" +
                    "Fax: (02)928 5811");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Shaw Boulevard")) {
            textTitle.setText("Shaw Boulevard");
            textLocation.setText("131-133 Shaw Boulevard, Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)585-1017; (02)632-9817; (02)747-8088; Mobile: (0917)8270558\n" +
                    "Fax: (02)632-9814");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Sucat")) {
            textTitle.setText("Sucat");
            textLocation.setText("8200 Dr A Santos Avenue Sucat, Parañaque City");
            textPhone.setText("Tel: (02)820 2338-39; (02)820 4030\n" +
                    "Fax: (02)820 2381");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");


        } else if (getArguments().getString("title").equals("The Medical City")) {
            textTitle.setText("The Medical City");
            textLocation.setText("The New Medical City Hospital, MATI Bldg. B1, Ortigas, Pasig City");
            textPhone.setText("Tel: (02)633 3863; (02)506 5061; (02)633 3862; Local: 3160; Mobile: 0917 8275826\n" +
                    "Fax: (02)633 3862");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Shaw Pasig")) {
            textTitle.setText("Shaw Pasig");
            textLocation.setText("Chipeco Bldg., Shaw Blvd. corner Meralco Ave., Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)631 3957; (02)502 2669; Local: 3179; Mobile: 0917-8275832\n" +
                    "Fax: (02)631 3955");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm ");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Tektite")) {
            textTitle.setText("Tektite");
            textLocation.setText("G/F PSE Center, Ortigas Complex, Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)637-3280; (02)636-3532; (02)636-3529; Mobile: 0917-8270996\n" +
                    "Fax: (02)636 3531");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Ortigas Center")) {
            textTitle.setText("Ortigas Center");
            textLocation.setText("21 San Miguel Ave., Ortigas Center, Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)633 6443; (02)635-9028; (02)585 1013; Local: 3168; Mobile: 0917-8270556\n" +
                    "Fax: (02)633 6445");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Renaissance Tower")) {
            textTitle.setText("Renaissance Tower");
            textLocation.setText("G/F Renaissance Center, Meralco Ave., Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)584-8396; (02)217-7210; Mobile: 0917-8270461\n" +
                    "Fax: (02)584-8397");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Julia Vargas")) {
            textTitle.setText("Julia Vargas");
            textLocation.setText("Centerpoint Condominium, Doña Julia Vargas Ave. cor. Garnet St. Ortigas Center, Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)633 5597; (02)975 8398; Local: 3145; Mobile: 0917-8276165\n" +
                    "Fax: (02)633 5595");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Exchange Regency")) {
            textTitle.setText("Exchange Regency");
            textLocation.setText("G/F, The Exchange Regency along Exchange Road cor. Meralco Avenue and Jade Drive, Ortigas Center, Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)310-5627; (02)623-9569; Mobile: 0917-827-1336\n" +
                    "Fax: (02)310-5631");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Emerald")) {
            textTitle.setText("Emerald");
            textLocation.setText("G/F Wynsum Corp. Plaza, Ortigas Center, Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)633-7604; (02)585-1008; Mobile: 0917-8270552");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("ADB Avenue")) {
            textTitle.setText("ADB Avenue");
            textLocation.setText("Ground floor Unit 101 AIC Burgundy Empire Tower, ADB Ave., Ortigas Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)633-1097; (02)622-1031; (02)571-8394; Mobile: 0917-8275992\n" +
                    "Fax: (02)633-1097");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Frontera Verde")) {
            textTitle.setText("Frontera Verde");
            textLocation.setText("G/F Transcom Bldg., Frontera Verde, E. Rodriguez Jr. Avenue., Brgy. Ugong Pasig City (ATM: On-site)");
            textPhone.setText("Tel: (02)451-1590; (02)451-1001; (02)502-2476; Mobile: +63917-827-6172");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Las Piñas - Pamplona")) {
            textTitle.setText("Las Piñas - Pamplona");
            textLocation.setText("Alabang Zapote Rd. cor. Crispina Ave., Pamplona, Las Piñas City (ATM: On-site)");
            textPhone.setText("Tel: (02)874-3696; (02)874-3698; Mobile: 0917-8270467\n" +
                    "Fax: (02)874 8075");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Richville Corporate Tower")) {
            textTitle.setText("Richville Corporate Tower");
            textLocation.setText("Upper G/F Richville Corporate Tower, Alabang-Zapote Rd.,  Madrigal Bus. Park, Muntinlupa City (ATM: On-site)");
            textPhone.setText("Tel: (02)850-5280; (02)850-5164; (02)850-5636; Local: 3716\n" +
                    "Fax: (02)850 5636");
            textBankingHours.setText("Monday to Friday, 9:00 am - 4:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Muntinlupa")) {
            textTitle.setText("Muntinlupa");
            textLocation.setText("12 Jason's Bldg., National Road Putatan, Muntinlupa (ATM: On-site)");
            textPhone.setText("Tel: (02)862-4667; (02)623-2038; (02)862-1368; Mobile: 0917-8270971\n" +
                    "Fax: (02)862 1368");
            textBankingHours.setText("Monday to Friday, 9:00 am - 4:00 pm ");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Ayala Alabang (NOL)")) {
            textTitle.setText("Ayala Alabang (NOL)");
            textLocation.setText("G/F Nol Bldg. Commerce Ave., Madrigal Business Park, Alabang, Muntinlupa City (ATM: On-site)");
            textPhone.setText("Tel: (02)809 0689-91; (02)585-1038; Mobile: 0917-8270361\n" +
                    "Fax: (02)809 0694");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Alabang Town Center")) {
            textTitle.setText("Alabang Town Center");
            textLocation.setText("Makati Supermart Alabang, Alabang Town Center, Muntinlupa City (ATM: On-site)");
            textPhone.setText("Tel: (02)842-0488; (02)842-0496;(02) 623-2027; Mobile: 0917-8270970\n" +
                    "Fax: (02)842 0496");
            textBankingHours.setText("Monday to Sunday, 10:00 am - 6:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Dasmarinas GACU")) {
            textTitle.setText("Dasmarinas GACU");
            textLocation.setText("G.A.Cu-Unjieng Bldg., Q. Paredes St. corner Dasmarinas St., Binondo, Manila (ATM: On-site)");
            textPhone.setText("Tel: (02)243-8204; (02)245-7191; (02)585-9839; Mobile: 0917-8270352\n" +
                    "Fax: (02)242 9372");
            textBankingHours.setText("Monday to Friday, 9:00 am - 5:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Ayala-SSS")) {
            textTitle.setText("Ayala-SSS");
            textLocation.setText("SSS Bldg., Ayala Avenue, Makati City (ATM: On-site)");
            textPhone.setText("Tel: (02)848-6805; (02)848-6806; Local: 3120; Mobile: 0917 8270296\n" +
                    "Fax: (02)813 4620");
            textBankingHours.setText("Monday to Friday, 9:00 am - 5:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Cebu - Insular Life")) {
            textTitle.setText("Cebu - Insular Life");
            textLocation.setText("G/F Insular Bldg., Mindanao Ave., cor Biliran Road, Cebu Business Park, Cebu City (ATM: On-site)");
            textPhone.setText("Tel: (032)417 1632; (032)266 1166; Local: 3354\n" +
                    "Fax: (032)417 1632");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Century City")) {
            textTitle.setText("Century City");
            textLocation.setText("G/f Unit 3 The Gramercy Residences Century City, Salamanca St., cor Kalayaan Ave., Brgy. Poblacion, Makati City (ATM: On-site)");
            textPhone.setText("Tel: (02)894-3144; (02)894-4700 Mobile: DUO 0917-827-8341 \n" +
                    "Fax: (02)894-4700");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Alabang Country Club")) {
            textTitle.setText("Alabang Country Club");
            textLocation.setText("Alabang Country Club Lounge, Ayala Alabang Village, Alabang, Muntinlupa City");
            textPhone.setText("Tel: (02)833-9067; (02)833-9071");
            textBankingHours.setText("Tuesday to Sunday, 9:00 am - 5:00 pm");
            textDescription.setText("n/a");

        } else if (getArguments().getString("title").equals("Luxe Residence")) {
            textTitle.setText("Luxe Residence");
            textLocation.setText("G/F, Shop 3, The Luxe Residences, 28th St. corner 4th Avenue, Bonifacio Global City, Taguig City");
            textPhone.setText("Phone Number: 865-6932 / 865-6869 0917-3094779 Globe Duo 504-7620");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");


        } else if (getArguments().getString("title").equals("Angeles")) {
            textTitle.setText("Angeles");
            textLocation.setText("G/F, Building 1, Unit 1 & 2, Central Town Mall, 263 Fil Am Friendship Highway, Brgy Cutcut, Angeles City, Pampanga (ATM: On-site)");
            textPhone.setText("Tel: (045)625 9858; (045)888 3862\n" +
                    "Fax: (045)888 3781");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Baliwag")) {
            textTitle.setText("Baliwag");
            textLocation.setText("G/F, 3006 St Augustine Square, Dona Remedios Trinidad Highway, Pinagbarilan Baliuag, Bulacan (ATM: On-site)");
            textPhone.setText("Tel: (044)766 2442; Local: 3114\n" +
                    "Fax: (044)766 2847");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm  ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Meycauayan")) {
            textTitle.setText("Meycauayan");
            textLocation.setText("Gr. Floor, Marian Bldg., McArthur Hi-way, Calvario, Meycauayan City, Bulacan (ATM: On-site)");
            textPhone.setText("Tel: (044)815 2346; (044)769 6072");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Cabanatuan")) {
            textTitle.setText("Cabanatuan");
            textLocation.setText("P. Burgos St., Cabanatuan City (ATM: On-site)");
            textPhone.setText("Tel: (044)463 0489; Local: 3118\n" +
                    "Fax: (044)463 0490");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm   ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Tarlac")) {
            textTitle.setText("Tarlac");
            textLocation.setText("Jaral Bldg. McArthur Ave. cor. Juan Luna St., Tarlac City (ATM: On-site)");
            textPhone.setText("Tel: (045)982 6485; Local: 3182\n" +
                    "Fax: (045)982 6489");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Baguio")) {
            textTitle.setText("Baguio");
            textLocation.setText("A10 Annex A Antipolo Bldg., Upper Session Road, Baguio City (ATM: On-site)");
            textPhone.setText("Tel: (074)443 5660; Local: 3113\n" +
                    "Fax: (074)443 5658");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm  ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Tuguegarao")) {
            textTitle.setText("Tuguegarao");
            textLocation.setText("106 A.Bonifacio St., Tuguegarao City, Cagayan (ATM: On-site)");
            textPhone.setText("Tel: (078)846 9179; Local: 3184\n" +
                    "Fax: (078)844 3170");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm  ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Vigan")) {
            textTitle.setText("Vigan");
            textLocation.setText("Jose Singson St., Vigan City, Ilocos Sur (ATM: On-site)");
            textPhone.setText("Tel: (077)722-2369; Local: 3187\n" +
                    "Fax: (077)722-2046");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Santiago")) {
            textTitle.setText("Santiago");
            textLocation.setText("Maharlika Highway, Santiago City, Isabela (ATM: On-site)");
            textPhone.setText("Tel: (078)305 9940; Local: 3178\n" +
                    "Fax: (078)305 9956");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Laoag")) {
            textTitle.setText("Laoag");
            textLocation.setText("JP Rizal St. cor Guerrero St., Laoag City (ATM: On-site)");
            textPhone.setText("Tel: (077)770-3771; Local: 3148\n" +
                    "Fax: (077)771-5260");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Lipa")) {
            textTitle.setText("Lipa");
            textLocation.setText("B. Morada Avenue, Lipa City (ATM: On-site)");
            textPhone.setText("Tel: (043)756-4370; (043)312-2622 Local: 8810\n" +
                    "Fax: (043) 756-3882");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm  ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Cainta")) {
            textTitle.setText("Cainta");
            textLocation.setText("F. Felix Ave. corner Karangalan Drive, Cainta, Rizal (ATM: On-site)");
            textPhone.setText("Tel: (02)646 0295; Local: 3119; Mobile: 0917 8270991\n" +
                    "Fax: (02)646 0295");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Bacoor")) {
            textTitle.setText("Bacoor");
            textLocation.setText("Addio Bldg., Aguinaldo Highway, Talaba, Bacoor City, Cavite (ATM: On-site)");
            textPhone.setText("Tel: (046)417-1606; (046)417-1705; Local: 3111");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm   ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Dagupan")) {
            textTitle.setText("Dagupan");
            textLocation.setText("Insular Life Building, Arellano St., Dagupan City (ATM: On-site)");
            textPhone.setText("Tel: (075)523 5575; Local: 3128\n" +
                    "Fax: (075)523 6086");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Legaspi")) {
            textTitle.setText("Legaspi");
            textLocation.setText("Sia Ko Pio Bldg., Rizal St., Legaspi City (ATM: On-site)");
            textPhone.setText("Tel: (052)820 0598; Local: 3152\n" +
                    "Fax: (052)480 6059");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm  ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Cebu - Asiatown IT park")) {
            textTitle.setText("Cebu - Asiatown IT park");
            textLocation.setText("G/F TGU Tower, Asiatown I.T. Park, Lahug, Cebu City (ATM: On-site)");
            textPhone.setText("Tel: (032)479 9980; (032)236 7897; Local: 3366\n" +
                    "Fax: (032)479 9981");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Cebu - Banilad")) {
            textTitle.setText("Cebu - Banilad");
            textLocation.setText("Gaisano Country Mall, Talamban Road, Banilad, Cebu City (ATM: On-site)");
            textPhone.setText("Tel: (032)416 2883; (032)231 2734; Local: 3352\n" +
                    "Fax: (032)231 2734");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Cebu - Borromeo")) {
            textTitle.setText("Cebu - Borromeo");
            textLocation.setText("Door 8 Plaza Borromeo Bldg., Borromeo Street, Kalubihan, Cebu City (ATM: On-site)");
            textPhone.setText("Tel: (032)253 0446; (032)412 3401; Local: 3353");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Cebu - Fuente")) {
            textTitle.setText("Cebu - Fuente");
            textLocation.setText("G/F Rajah Park Hotel, Fuente Osmeña Circle, Cebu City (ATM: On-site)");
            textPhone.setText("Tel: (032)412 5133; (032)253 3865; Local: 3356\n" +
                    "Fax: (032)253 3865");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Cebu - Maxilom")) {
            textTitle.setText("Cebu - Maxilom");
            textLocation.setText("G/F Ong Tiak Bldg., Gen Maxilom Ave., Cebu City (ATM: On-site)");
            textPhone.setText("Tel: (032)255 6225; (032)412 6419; (032)255 6224; Local: 8890\n" +
                    "Fax: (032)255 6224");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Davao - Magsaysay")) {
            textTitle.setText("Davao - Magsaysay");
            textLocation.setText("R. Magsaysay Ave. cor. E. Jacinto St., Davao City");
            textPhone.setText("Tel: (082)221 6426; (082)221 6726; (082)222 3928; Local: 3461 / 3454\n" +
                    "Fax: (082)221 6319");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Davao - Monteverde")) {
            textTitle.setText("Davao - Monteverde");
            textLocation.setText("G/F Mintrade Bldg. Monteverde Ave. cor. Sales St., Davao City (ATM: On-site)");
            textPhone.setText("Tel: (082)222 3411-13; Local: 8838\n" +
                    "Fax: (082)222 3413");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Davao - Quirino")) {
            textTitle.setText("Davao - Quirino");
            textLocation.setText("Quirino Avenue cor San Pedro St., Davao City (ATM: On-site)");
            textPhone.setText("Tel: (082)225 1701; Local: 8839");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Davao - Victoria Plaza")) {
            textTitle.setText("Davao - Victoria Plaza");
            textLocation.setText("Victoria Plaza Complex, J.P. Laurel Ave., Davao City (ATM: On-site)");
            textPhone.setText("Tel: (082)221 4776; (082)222 2508; Local: 3455");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Davao - Recto/Rizal")) {
            textTitle.setText("Davao - Recto/Rizal");
            textLocation.setText("G/F Quibod Commercial Center, Rizal Avenue, Davao City (ATM: On-site)");
            textPhone.setText("Tel: (082)221 6489; (082)225 3004; Local: 3453\n" +
                    "Fax: (082)222 4793");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Tacloban")) {
            textTitle.setText("Tacloban");
            textLocation.setText("Josmar Bldg., M.H. del Pilar St. corner Zamora St., Tacloban City (ATM: On-site)");
            textPhone.setText("Tel: (053)832 7724; Local: 3363; Mobile: 0917 8275962");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Tagbiliran")) {
            textTitle.setText("Tagbiliran");
            textLocation.setText("J.S. Torralba St. corner CPG Avenue, Tagbilaran City, Bohol (ATM: On-site)");
            textPhone.setText("Tel: (038)501 9909; (038)412 3775; Local: 3364");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Bacolod - Araneta")) {
            textTitle.setText("Bacolod - Araneta");
            textLocation.setText("1st Provincial Finance Corp. Bldg., Corner Rosario-Araneta Sts., Bacolod City (ATM: On-site)");
            textPhone.setText("Tel: (034)435 0664; (034)435 0665; (034)709 0253; Local: 3361\n" +
                    "Fax: (034)709 0253");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Dumaguete - Negros Oriental")) {
            textTitle.setText("Dumaguete - Negros Oriental");
            textLocation.setText("UnionBank Building, Ramon Pastor Sr. Street corner San Juan Street Dumaguete City 6200, Negros Oriental (ATM: On-site)");
            textPhone.setText("Tel: (035)422 5038; Local: 8298\n" +
                    "Fax: (035)422 4036");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm ");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Iligan")) {
            textTitle.setText("Iligan");
            textLocation.setText("Quezon Avenue, Iligan City (ATM: On-site)");
            textPhone.setText("Tel: (063)221 5395; (063)221 3008; Local: 3458");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("General Santos")) {
            textTitle.setText("General Santos");
            textLocation.setText("G/F Laiz Building, Pioneer Avenue, General Santos City (ATM: On-site)");
            textPhone.setText("Tel: (083)553 6026; (083)552 5076; (083)301 1168; Local: 8876 / 3457\n" +
                    "Fax: (083)553 3218");
            textBankingHours.setText("Monday to Friday, 9:00 am - 3:00 pm");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Pagadian")) {
            textTitle.setText("Pagadian");
            textLocation.setText("Rizal Ave., Pagadian City (ATM: On-site)");
            textPhone.setText("Tel: (062)214 1841; Local: 3459\n" +
                    "Fax: (062)214 1332");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Butuan")) {
            textTitle.setText("Butuan");
            textLocation.setText("G/F CAP Bldg. J. Rosales Avenue corner JC Aquino St., Butuan City (ATM: On-site)");
            textPhone.setText("Tel: (085)342 8981; (085)342 8982; Local: 3464");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
        } else if (getArguments().getString("title").equals("Cagayan de Oro - Lapasan")) {
            textTitle.setText("Cagayan de Oro - Lapasan");
            textLocation.setText("Lapasan National Highway, Cagayan de Oro City (ATM: On-site)");
            textPhone.setText("Tel: (062)991 4899; (062)991 4499; Local: 8878 / 3460\n" +
                    "Fax: (062)991 4499");
            textBankingHours.setText("n/a");
            textDescription.setText("n/a");
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
}
