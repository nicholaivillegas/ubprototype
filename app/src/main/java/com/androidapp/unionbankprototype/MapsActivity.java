package com.androidapp.unionbankprototype;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnInfoWindowCloseListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    private Spinner spinnerAreas, spinnerCities;
    private ImageButton buttonWaze;
    private String addressWaze;
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private double currentLatitude;
    private double currentLongitude;
    Location myLocation = new Location("");
    private Marker previousMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        spinnerAreas = (Spinner) findViewById(R.id.spinner_areas);
        spinnerCities = (Spinner) findViewById(R.id.spinner_city);
        buttonWaze = (ImageButton) findViewById(R.id.button_waze);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        buttonWaze.setOnClickListener(this);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                // The next two lines tell the new client that “this” current class will handle connection stuff
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                //fourth line adds the LocationServices API endpoint from GooglePlayServices
                .addApi(LocationServices.API)
                .build();

        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1000); // 1 second, in milliseconds

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(this, "Please Enable GPS.", Toast.LENGTH_SHORT).show();
            return;
        }

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);


        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnInfoWindowCloseListener(this);
        spinnerAreas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinnerAreas.getSelectedItem().toString().equals("METRO MANILA")) {
                    spinnerCities.setVisibility(View.VISIBLE);
                    moveCamera(14.609054, 121.022257, 11);
                } else if (spinnerAreas.getSelectedItem().toString().equals("CENTRAL LUZON")) {
                    spinnerCities.setVisibility(View.GONE);
                    moveCamera(15.482772, 120.712002, 8);
                } else if (spinnerAreas.getSelectedItem().toString().equals("NORTH LUZON")) {
                    spinnerCities.setVisibility(View.GONE);
                    moveCamera(16.566232, 121.262637, 8);
                } else if (spinnerAreas.getSelectedItem().toString().equals("SOUTH LUZON")) {
                    spinnerCities.setVisibility(View.GONE);
                    moveCamera(14.342266, 121.049904, 8);
                } else if (spinnerAreas.getSelectedItem().toString().equals("METRO CEBU")) {
                    spinnerCities.setVisibility(View.GONE);
                    moveCamera(10.317633, 123.903681, 8);
                } else if (spinnerAreas.getSelectedItem().toString().equals("METRO DAVAO")) {
                    spinnerCities.setVisibility(View.GONE);
                    moveCamera(7.095010, 125.613136, 8);
                } else if (spinnerAreas.getSelectedItem().toString().equals("VISAYAS")) {
                    spinnerCities.setVisibility(View.GONE);
                    moveCamera(11.000000, 123.500000, 7);
                } else if (spinnerAreas.getSelectedItem().toString().equals("MINDANAO")) {
                    spinnerCities.setVisibility(View.GONE);
                    moveCamera(8.496130, 123.303406, 7);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinnerCities.getSelectedItem().toString().equals("ALL")) {
                    moveCamera(14.609054, 121.022257, 10);
                } else if (spinnerCities.getSelectedItem().toString().equals("PASIG CITY")) {
                    moveCamera(14.576377, 121.085110, 13);
                } else if (spinnerCities.getSelectedItem().toString().equals("LAS PIÑAS CITY")) {
                    moveCamera(14.444546, 120.993874, 13);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_waze:
                try {
                    String url = "waze://?q=" + addressWaze + " unionbank";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    Intent intent =
                            new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.waze"));
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Disconnect from API onPause()
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        InformationDialog informationDialog = new InformationDialog();
        Bundle bundle = new Bundle();
        switch (marker.getTitle()) {
            case "UnionBank Plaza":
                bundle.putString("title", "UnionBank Plaza");
                break;
            case "Greenhills":
                bundle.putString("title", "Greenhills");
                break;

            case "Tomas Morato":
                bundle.putString("title", "Tomas Morato");
                break;

            case "Shaw Boulevard":
                bundle.putString("title", "Shaw Boulevard");
                break;

            case "Sucat":
                bundle.putString("title", "Sucat");
                break;

            case "Angeles":
                bundle.putString("title", "Angeles");
                break;

            case "Baliwag":
                bundle.putString("title", "Baliwag");
                break;

            case "Meycauayan":
                bundle.putString("title", "Meycauayan");
                break;

            case "Cabanatuan":
                bundle.putString("title", "Cabanatuan");
                break;

            case "Tarlac":
                bundle.putString("title", "Tarlac");
                break;

            case "Baguio":
                bundle.putString("title", "Baguio");
                break;

            case "Tuguegarao":
                bundle.putString("title", "Tuguegarao");
                break;

            case "Vigan":
                bundle.putString("title", "Vigan");
                break;

            case "Santiago":
                bundle.putString("title", "Santiago");
                break;

            case "Laoag":
                bundle.putString("title", "Laoag");
                break;

            case "Lipa":
                bundle.putString("title", "Lipa");
                break;

            case "Cainta":
                bundle.putString("title", "Cainta");
                break;

            case "Bacoor":
                bundle.putString("title", "Bacoor");
                break;

            case "Dagupan":
                bundle.putString("title", "Dagupan");
                break;

            case "Legaspi":
                bundle.putString("title", "Legaspi");
                break;

            case "Cebu - Asiatown IT park":
                bundle.putString("title", "Cebu - Asiatown IT park");
                break;

            case "Cebu - Banilad":
                bundle.putString("title", "Cebu - Banilad");
                break;

            case "Cebu - Borromeo":
                bundle.putString("title", "Cebu - Borromeo");
                break;

            case "Cebu - Fuente":
                bundle.putString("title", "Cebu - Fuente");
                break;

            case "Cebu - Maxilom":
                bundle.putString("title", "Cebu - Maxilom");
                break;

            case "Davao - Magsaysay":
                bundle.putString("title", "Davao - Magsaysay");
                break;

            case "Davao - Monteverde":
                bundle.putString("title", "Davao - Monteverde");
                break;

            case "Davao - Quirino":
                bundle.putString("title", "Davao - Quirino");
                break;

            case "Davao - Victoria Plaza":
                bundle.putString("title", "Davao - Victoria Plaza");
                break;

            case "Davao - Recto/Rizal":
                bundle.putString("title", "Davao - Recto/Rizal");
                break;

            case "Tacloban":
                bundle.putString("title", "Tacloban");
                break;

            case "Tagbiliran":
                bundle.putString("title", "Tagbiliran");
                break;

            case "Bacolod - Araneta":
                bundle.putString("title", "Bacolod - Araneta");
                break;

            case "Bacolod - Lacson":
                bundle.putString("title", "Bacolod - Lacson");
                break;

            case "Dumaguete - Negros Oriental":
                bundle.putString("title", "Dumaguete - Negros Oriental");
                break;

            case "Iligan":
                bundle.putString("title", "Iligan");
                break;

            case "General Santos":
                bundle.putString("title", "General Santos");
                break;

            case "Pagadian":
                bundle.putString("title", "Pagadian");
                break;

            case "Butuan":
                bundle.putString("title", "Butuan");
                break;

            case "Cagayan de Oro - Lapasan":
                bundle.putString("title", "Cagayan de Oro - Lapasan");
                break;
        }
        informationDialog.setArguments(bundle);
        informationDialog.show(getFragmentManager(), "Information Dialog");
    }

    @Override
    public void onInfoWindowClose(Marker marker) {
        buttonWaze.setVisibility(View.GONE);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (previousMarker != null) {
            previousMarker.setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot));
        }
        marker.setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ub));
        previousMarker = marker; //Now the clicked marker becomes previousMarker

        buttonWaze.setVisibility(View.VISIBLE);
        addressWaze = marker.getTitle();
        int zoom = (int) mMap.getCameraPosition().zoom;
        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(marker.getPosition().latitude + (double) 90 / Math.pow(2, zoom), marker.getPosition().longitude), zoom);
        mMap.animateCamera(cu);
        return false;
    }

    public void moveCamera(double latitude, double longitude, float zoomCount) {
//        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(14.6091, 121.0223));
//        CameraUpdate zoom = CameraUpdateFactory.zoomTo(11);
        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(zoomCount);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }

    public void setMarkers() {
        myLocation.setLatitude(currentLatitude);
        myLocation.setLongitude(currentLongitude);
        //metro manila markers
        LatLng unionBankPlaza = new LatLng(14.587058, 121.063474);
        Location unionBankPlaza1 = new Location("");
        unionBankPlaza1.setLatitude(14.587058);
        unionBankPlaza1.setLongitude(121.063474);
        mMap.addMarker(new MarkerOptions().position(unionBankPlaza).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("UnionBank Plaza").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(unionBankPlaza1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(unionBankPlaza));

        LatLng greenhills = new LatLng(14.604358, 121.052173);
        Location greenhills1 = new Location("");
        greenhills1.setLatitude(14.604358);
        greenhills1.setLongitude(121.052173);
        mMap.addMarker(new MarkerOptions().position(greenhills).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Greenhills").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(greenhills1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(greenhills));

        LatLng tomasMorato = new LatLng(14.629487, 121.034228);
        Location tomasMorato1 = new Location("");
        tomasMorato1.setLatitude(14.629487);
        tomasMorato1.setLongitude(121.034228);
        mMap.addMarker(new MarkerOptions().position(tomasMorato).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Tomas Morato").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(tomasMorato1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tomasMorato));

        LatLng shawBoulevard = new LatLng(14.572419, 121.064330);
        Location shawBoulevard1 = new Location("");
        shawBoulevard1.setLatitude(14.572419);
        shawBoulevard1.setLongitude(121.064330);
        mMap.addMarker(new MarkerOptions().position(shawBoulevard).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Shaw Boulevard").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(shawBoulevard));

        LatLng sucat = new LatLng(14.465207, 121.019390);
        Location sucat1 = new Location("");
        sucat1.setLatitude(14.465207);
        sucat1.setLongitude(121.019390);
        mMap.addMarker(new MarkerOptions().position(sucat).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Sucat").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(sucat1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sucat));

        //PASIG CITY
        LatLng medicalCity = new LatLng(14.590217, 121.069474);
        Location medicalCity1 = new Location("");
        medicalCity1.setLatitude(14.590217);
        medicalCity1.setLongitude(121.069474);
        mMap.addMarker(new MarkerOptions().position(medicalCity).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("The Medical City").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(medicalCity));

        LatLng shawPasig = new LatLng(14.575843, 121.060211);
        Location shawPasig1 = new Location("");
        shawPasig1.setLatitude(14.575843);
        shawPasig1.setLongitude(121.060211);
        mMap.addMarker(new MarkerOptions().position(shawPasig).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Shaw Pasig").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(shawPasig));

        LatLng tektite = new LatLng(14.582574, 121.061630);
        Location tektite1 = new Location("");
        tektite1.setLatitude(14.582574);
        tektite1.setLongitude(121.061630);
        mMap.addMarker(new MarkerOptions().position(tektite).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Tektite").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tektite));

        LatLng ortigasCenter = new LatLng(14.580371, 121.059239);
        Location ortigasCenter1 = new Location("");
        ortigasCenter1.setLatitude(14.580371);
        ortigasCenter1.setLongitude(121.059239);
        mMap.addMarker(new MarkerOptions().position(ortigasCenter).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Ortigas Center").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ortigasCenter));

        LatLng renasissanceTower = new LatLng(14.581483, 121.064005);
        Location renasissanceTower1 = new Location("");
        renasissanceTower1.setLatitude(14.581483);
        renasissanceTower1.setLongitude(121.064005);
        mMap.addMarker(new MarkerOptions().position(renasissanceTower).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Renaissance Tower").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(renasissanceTower));

        LatLng juliaVargas = new LatLng(14.584368, 121.066795);
        Location juliaVargas1 = new Location("");
        juliaVargas1.setLatitude(14.584368);
        juliaVargas1.setLongitude(121.066795);
        mMap.addMarker(new MarkerOptions().position(juliaVargas).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Julia Vargas").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(juliaVargas));

        LatLng exchangeRegency = new LatLng(14.583168, 121.063398);
        Location exchangeRegency1 = new Location("");
        exchangeRegency1.setLatitude(14.572419);
        exchangeRegency1.setLongitude(121.064330);
        mMap.addMarker(new MarkerOptions().position(exchangeRegency).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Exchange Regency").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(exchangeRegency));

        LatLng emerald = new LatLng(14.585712, 121.061362);
        Location emerald1 = new Location("");
        emerald1.setLatitude(14.585712);
        emerald1.setLongitude(121.061362);
        mMap.addMarker(new MarkerOptions().position(emerald).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Emerald").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(emerald));

        LatLng adbAvenue = new LatLng(14.589802, 121.060887);
        Location adbAvenue1 = new Location("");
        adbAvenue1.setLatitude(14.589802);
        adbAvenue1.setLongitude(121.060887);
        mMap.addMarker(new MarkerOptions().position(adbAvenue).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("ADB Avenue").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(adbAvenue));

        LatLng fronteraVerde = new LatLng(14.587127, 121.078901);
        Location fronteraVerde1 = new Location("");
        fronteraVerde1.setLatitude(14.587127);
        fronteraVerde1.setLongitude(121.078901);
        mMap.addMarker(new MarkerOptions().position(fronteraVerde).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Frontera Verde").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(fronteraVerde));
        //LAS PINAS CITY
        LatLng lasPinasPamplona = new LatLng(14.449477, 120.982010);
        Location lasPinasPamplona1 = new Location("");
        lasPinasPamplona1.setLatitude(14.449477);
        lasPinasPamplona1.setLongitude(120.982010);
        mMap.addMarker(new MarkerOptions().position(lasPinasPamplona).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Las Piñas - Pamplona").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(shawBoulevard1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lasPinasPamplona));

        //central luzon
        LatLng angeles = new LatLng(15.135746, 120.591858);
        Location angeles1 = new Location("");
        angeles1.setLatitude(15.135746);
        angeles1.setLongitude(120.591858);
        mMap.addMarker(new MarkerOptions().position(angeles).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Angeles").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(angeles1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(angeles));

        LatLng baliwag = new LatLng(14.955594, 120.886853);
        Location baliwag1 = new Location("");
        baliwag1.setLatitude(14.955594);
        baliwag1.setLongitude(120.886853);
        mMap.addMarker(new MarkerOptions().position(baliwag).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Baliwag").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(baliwag1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(baliwag));

        LatLng meycauayan = new LatLng(14.736482, 120.961197);
        Location meycauayan1 = new Location("");
        meycauayan1.setLatitude(14.736482);
        meycauayan1.setLongitude(120.961197);
        mMap.addMarker(new MarkerOptions().position(meycauayan).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Meycauayan").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(meycauayan1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(meycauayan));

        LatLng cabanatuan = new LatLng(15.489167, 120.965740);
        Location cabanatuan1 = new Location("");
        cabanatuan1.setLatitude(15.489167);
        cabanatuan1.setLongitude(120.965740);
        mMap.addMarker(new MarkerOptions().position(cabanatuan).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Cabanatuan").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(cabanatuan1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cabanatuan));

        LatLng tarlac = new LatLng(15.487228, 120.596132);
        Location tarlac1 = new Location("");
        tarlac1.setLatitude(15.487228);
        tarlac1.setLongitude(120.596132);
        mMap.addMarker(new MarkerOptions().position(tarlac).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Tarlac").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(tarlac1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tarlac));

        //north luzon
        LatLng baguio = new LatLng(16.414577, 120.596990);
        Location baguio1 = new Location("");
        baguio1.setLatitude(16.414577);
        baguio1.setLongitude(120.596990);
        mMap.addMarker(new MarkerOptions().position(baguio).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Baguio").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(baguio1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(baguio));

        LatLng tuguegarao = new LatLng(17.612720, 121.728531);
        Location tuguegarao1 = new Location("");
        tuguegarao1.setLatitude(17.612720);
        tuguegarao1.setLongitude(121.728531);
        mMap.addMarker(new MarkerOptions().position(tuguegarao).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Tuguegarao").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(tuguegarao1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tuguegarao));

        LatLng vigan = new LatLng(17.569163, 120.385583);
        Location vigan1 = new Location("");
        vigan1.setLatitude(17.569163);
        vigan1.setLongitude(120.385583);
        mMap.addMarker(new MarkerOptions().position(vigan).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Vigan").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(vigan1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(vigan));

        LatLng santiago = new LatLng(16.688776, 121.551447);
        Location santiago1 = new Location("");
        santiago1.setLatitude(16.688776);
        santiago1.setLongitude(121.551447);
        mMap.addMarker(new MarkerOptions().position(santiago).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Santiago").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(santiago1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(santiago));

        LatLng laoag = new LatLng(18.191525, 120.607539);
        Location laoag1 = new Location("");
        laoag1.setLatitude(18.191525);
        laoag1.setLongitude(120.607539);
        mMap.addMarker(new MarkerOptions().position(laoag).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Laoag").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(laoag1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(laoag));
        //south luzon
        LatLng lipa = new LatLng(13.940613, 121.159569);
        Location lipa1 = new Location("");
        lipa1.setLatitude(13.940613);
        lipa1.setLongitude(121.159569);
        mMap.addMarker(new MarkerOptions().position(lipa).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Lipa").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(lipa1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lipa));

        LatLng cainta = new LatLng(14.610079, 121.103861);
        Location cainta1 = new Location("");
        cainta1.setLatitude(14.610079);
        cainta1.setLongitude(121.103861);
        mMap.addMarker(new MarkerOptions().position(cainta).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Cainta").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(cainta1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cainta));

        LatLng bacoor = new LatLng(14.431729, 120.943771);
        Location bacoor1 = new Location("");
        bacoor1.setLatitude(14.431729);
        bacoor1.setLongitude(120.943771);
        mMap.addMarker(new MarkerOptions().position(bacoor).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Bacoor").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(bacoor1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bacoor));

        LatLng dagupan = new LatLng(16.046692, 120.342633);
        Location dagupan1 = new Location("");
        dagupan1.setLatitude(16.046692);
        dagupan1.setLongitude(120.342633);
        mMap.addMarker(new MarkerOptions().position(dagupan).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Dagupan").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(dagupan1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dagupan));

        LatLng legaspi = new LatLng(13.146803, 123.752586);
        Location legaspi1 = new Location("");
        legaspi1.setLatitude(13.146803);
        legaspi1.setLongitude(123.752586);
        mMap.addMarker(new MarkerOptions().position(legaspi).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Legaspi").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(legaspi1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(legaspi));
        //metro cebu
        LatLng cebuAsiaTown = new LatLng(10.327584, 123.905783);
        Location cebuAsiaTown1 = new Location("");
        cebuAsiaTown1.setLatitude(10.327584);
        cebuAsiaTown1.setLongitude(123.905783);
        mMap.addMarker(new MarkerOptions().position(cebuAsiaTown).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Cebu - Asiatown IT park").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(cebuAsiaTown1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cebuAsiaTown));

        LatLng cebuBanilad = new LatLng(10.338663, 123.911166);
        Location cebuBanilad1 = new Location("");
        cebuBanilad1.setLatitude(10.338663);
        cebuBanilad1.setLongitude(123.911166);
        mMap.addMarker(new MarkerOptions().position(cebuBanilad).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Cebu - Banilad").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(cebuBanilad1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cebuBanilad));

        LatLng cebuBorromeo = new LatLng(10.294776, 123.897335);
        Location cebuBorromeo1 = new Location("");
        cebuBorromeo1.setLatitude(10.294776);
        cebuBorromeo1.setLongitude(123.897335);
        mMap.addMarker(new MarkerOptions().position(cebuBorromeo).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Cebu - Borromeo").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(cebuBorromeo1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cebuBorromeo));

        LatLng cebuFuente = new LatLng(10.310215, 123.893835);
        Location cebuFuente1 = new Location("");
        cebuFuente1.setLatitude(10.310215);
        cebuFuente1.setLongitude(123.893835);
        mMap.addMarker(new MarkerOptions().position(cebuFuente).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Cebu - Fuente").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(cebuFuente1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cebuFuente));

        LatLng cebuMaxilom = new LatLng(10.311189, 123.897751);
        Location cebuMaxilom1 = new Location("");
        cebuMaxilom1.setLatitude(10.311189);
        cebuMaxilom1.setLongitude(123.897751);
        mMap.addMarker(new MarkerOptions().position(cebuMaxilom).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Cebu - Maxilom").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(cebuMaxilom1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cebuMaxilom));
        //metro davao
        LatLng davaoMagsaysay = new LatLng(7.073482, 125.613084);
        Location davaoMagsaysay1 = new Location("");
        davaoMagsaysay1.setLatitude(7.073482);
        davaoMagsaysay1.setLongitude(125.613084);
        mMap.addMarker(new MarkerOptions().position(davaoMagsaysay).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Davao - Magsaysay").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(davaoMagsaysay1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(davaoMagsaysay));

        LatLng davaoMonteverde = new LatLng(7.075564, 125.619339);
        Location davaoMonteverde1 = new Location("");
        davaoMonteverde1.setLatitude(7.075564);
        davaoMonteverde1.setLongitude(125.619339);
        mMap.addMarker(new MarkerOptions().position(davaoMonteverde).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Davao - Monteverde").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(davaoMonteverde1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(davaoMonteverde));

        LatLng davaoQuirino = new LatLng(7.068908, 125.603177);
        Location davaoQuirino1 = new Location("");
        davaoQuirino1.setLatitude(7.068908);
        davaoQuirino1.setLongitude(125.603177);
        mMap.addMarker(new MarkerOptions().position(davaoQuirino).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Davao - Quirino").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(davaoQuirino1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(davaoQuirino));

        LatLng davaoVictoriaPlaza = new LatLng(7.086946, 125.611733);
        Location davaoVictoriaPlaza1 = new Location("");
        davaoVictoriaPlaza1.setLatitude(7.086946);
        davaoVictoriaPlaza1.setLongitude(125.611733);
        mMap.addMarker(new MarkerOptions().position(davaoVictoriaPlaza).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Davao - Victoria Plaza").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(davaoVictoriaPlaza1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(davaoVictoriaPlaza));

        LatLng davaoRecto = new LatLng(7.073482, 125.613084);
        Location davaoRecto1 = new Location("");
        davaoRecto1.setLatitude(7.073482);
        davaoRecto1.setLongitude(125.613084);
        mMap.addMarker(new MarkerOptions().position(davaoRecto).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Davao - Recto/Rizal").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(davaoRecto1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(davaoRecto));
        //visayas
        LatLng tacloban = new LatLng(11.244585, 125.002734);
        Location tacloban1 = new Location("");
        tacloban1.setLatitude(11.244585);
        tacloban1.setLongitude(125.002734);
        mMap.addMarker(new MarkerOptions().position(tacloban).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Tacloban").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(tacloban1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tacloban));

        LatLng tagbiliran = new LatLng(9.640405, 123.855705);
        Location tagbiliran1 = new Location("");
        tagbiliran1.setLatitude(9.640405);
        tagbiliran1.setLongitude(123.855705);
        mMap.addMarker(new MarkerOptions().position(tagbiliran).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Tagbiliran").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(tagbiliran1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tagbiliran));

        LatLng bacolodAraneta = new LatLng(10.664980, 122.943899);
        Location bacolodAraneta1 = new Location("");
        bacolodAraneta1.setLatitude(10.664980);
        bacolodAraneta1.setLongitude(122.943899);
        mMap.addMarker(new MarkerOptions().position(bacolodAraneta).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Bacolod - Araneta").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(bacolodAraneta1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bacolodAraneta));

        LatLng bacolodLacson = new LatLng(10.669912, 122.950598);
        Location bacolodLacson1 = new Location("");
        bacolodLacson1.setLatitude(10.669912);
        bacolodLacson1.setLongitude(122.950598);
        mMap.addMarker(new MarkerOptions().position(bacolodLacson).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Bacolod - Lacson").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(bacolodLacson1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bacolodLacson));

        LatLng dumagueteNegrosOriental = new LatLng(9.309165, 123.305682);
        Location dumagueteNegrosOriental1 = new Location("");
        dumagueteNegrosOriental1.setLatitude(9.309165);
        dumagueteNegrosOriental1.setLongitude(123.305682);
        mMap.addMarker(new MarkerOptions().position(dumagueteNegrosOriental).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Dumaguete - Negros Oriental").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(dumagueteNegrosOriental1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dumagueteNegrosOriental));

        //mindanao
        LatLng iligan = new LatLng(8.229232, 124.235126);
        Location iligan1 = new Location("");
        iligan1.setLatitude(8.229232);
        iligan1.setLongitude(124.235126);
        mMap.addMarker(new MarkerOptions().position(iligan).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Iligan").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(iligan1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(iligan));

        LatLng genSan = new LatLng(6.107530, 125.171478);
        Location genSan1 = new Location("");
        genSan1.setLatitude(6.107530);
        genSan1.setLongitude(125.171478);
        mMap.addMarker(new MarkerOptions().position(genSan).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("General Santos").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(genSan1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(genSan));

        LatLng pagadian = new LatLng(7.823834, 123.440613);
        Location pagadian1 = new Location("");
        pagadian1.setLatitude(7.823834);
        pagadian1.setLongitude(123.440613);
        mMap.addMarker(new MarkerOptions().position(pagadian).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Pagadian").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(pagadian1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pagadian));

        LatLng butuan = new LatLng(8.945985, 125.532059);
        Location butuan1 = new Location("");
        butuan1.setLatitude(8.945985);
        butuan1.setLongitude(125.532059);
        mMap.addMarker(new MarkerOptions().position(butuan).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Butuan").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(butuan1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(butuan));

        LatLng cagayan = new LatLng(8.484657, 124.657815);
        Location cagayan1 = new Location("");
        cagayan1.setLatitude(8.484657);
        cagayan1.setLongitude(124.657815);
        mMap.addMarker(new MarkerOptions().position(cagayan).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_dot)).title("Cagayan de Oro - Lapasan").snippet("(" + String.format(Locale.US, "%.2f", myLocation.distanceTo(cagayan1) / 1000) + "km)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cagayan));
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

        } else {
            //If everything went fine lets get latitude and longitude
            currentLatitude = location.getLatitude();
            currentLongitude = location.getLongitude();
            Toast.makeText(this, "Nearest UnionBank Branch is UnionBank Plaza Branch", Toast.LENGTH_LONG).show();
            setMarkers();
//            processClosest();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    /*
             * Google Play services can resolve some errors it detects.
             * If the error has a resolution, try sending an Intent to
             * start a Google Play services activity that can resolve
             * error.
             */
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
                    /*
                     * Thrown if Google Play services canceled the original
                     * PendingIntent
                     */
            } catch (IntentSender.SendIntentException e) {
                // Log the error
                e.printStackTrace();
            }
        } else {
                /*
                 * If no resolution is available, display a dialog to the
                 * user with the error.
                 */
            Log.e("Error", "Location services connection failed with code " + connectionResult.getErrorCode());
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        currentLatitude = location.getLatitude();
        currentLongitude = location.getLongitude();
    }


}