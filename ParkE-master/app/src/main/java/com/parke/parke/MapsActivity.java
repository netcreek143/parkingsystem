package com.parke.parke;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import android.Manifest;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Switch;

import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MapsActivity extends AppCompatActivity implements
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    final static int PERMISSION_ALL = 1;
    final static String[] PERMISSIONS={android.Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 2;
    private boolean mPermissionDenied = false;

    //private static final int COLOR_GREEN_ARGB=0xff388E3C;
    //private static final int COLOR_PURPLE_ARGB = 0xff81C784;
    //private static final int COLOR_ORANGE_ARGB = 0xffF57F17;
    //private static final int COLOR_BLUE_ARGB = 0xffF9A825;


    //private static final int POLYGON_STROKE_WIDTH_PX=8;
    //private static final int PATTERN_DASH_LENGTH_PX=20;
    //private static final int PATTERN_GAP_LENGTH_PX = 20;
    //private static final PatternItem DOT = new Dot();

    //private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);

    // Create a stroke pattern of a gap followed by a dot.


    private GoogleMap mMap;
    FusedLocationProviderClient mFusedLocationClient;
    LocationManager locationManager;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;
    private Location mCurrentLocation;
    Boolean mRequestingLocationUpdates;

    /* ID channel and keys for thingspeak */
    //private static final String THINGSPEAK_CHANNEL_ID="362604";
    //private static final String THINGSPEAK_API_KEY="VL6SAY1VR0HW7SC9";
    private static final String THINGSPEAK_CHANNEL_ID="348369";
    private static final String THINGSPEAK_API_KEY="WRORASZXUYFTN7UM";
    private static final String THINGSPEAK_API_KEY_STRING="api_key";

    /* strings for which fieal to read from thingspeak*/
    private static final String THINGSPEAK_FIELD1="field1";
    private static final String THINGSPEAK_FIELD2="field2";
    private static final String THINGSPEAK_FIELD3="field3";
    private static final String THINGSPEAK_FIELD4="field4";
    private static final String THINGSPEAK_FIELD5="field5";

    private static final String THINGSPEAK_CHANNEL_URL="https://api.thingspeak.com/channels/";
    private static final String THINGSPEAK_FEEDS_LAST="/feeds/last?";

    /* Initializing Integers that will hold data from thingspeak/cloud */
    int parkESensor1;
    int parkESensor2;
    int parkESensor3;
    int parkESensor4;
    int parkESensor5;
    int parkESensor6;
    int parkESensor7;
    int parkESensor8;
    int parkESensor9;
    int parkESensor10;
    int parkESensor11;
    int parkESensor12;
    int parkESensor13;
    int parkESensor14;
    int parkESensor15;
    int parkESensor16;
    int parkESensor17;
    int parkESensor18;
    int parkESensor19;
    int parkESensor20;
    int parkESensor21;
    int parkESensor22;
    int parkESensor23;
    int parkESensor24;
    int parkESensor25;
    int parkESensor26;
    int parkESensor27;
    int parkESensor28;
    int parkESensor29;
    int parkESensor30;
    int parkESensor31;
    int parkESensor32;
    int parkESensor33;
    int parkESensor34;
    int parkESensor35;
    int parkESensor36;
    int parkESensor37;
    int parkESensor38;
    int parkESensor39;
    int parkESensor40;
    int parkESensor41;
    int parkESensor42;
    int parkESensor43;
    int parkESensor44;
    int parkESensor45;
    int parkESensor46;
    int parkESensor47;
    int parkESensor48;
    int parkESensor49;
    int parkESensor50;

    /* Initializing Polygons (more like rectangles here) for the map*/
    Polygon polygon1;
    Polygon polygon2;
    Polygon polygon3;
    Polygon polygon4;
    Polygon polygon5;
    Polygon polygon6;
    Polygon polygon7;
    Polygon polygon8;
    Polygon polygon9;
    Polygon polygon10;
    Polygon polygon11;
    Polygon polygon12;
    Polygon polygon13;
    Polygon polygon14;
    Polygon polygon15;
    Polygon polygon16;
    Polygon polygon17;
    Polygon polygon18;
    Polygon polygon19;
    Polygon polygon20;
    Polygon polygon21;
    Polygon polygon22;
    Polygon polygon23;
    Polygon polygon24;
    Polygon polygon25;
    Polygon polygon26;
    Polygon polygon27;
    Polygon polygon28;
    Polygon polygon29;
    Polygon polygon30;
    Polygon polygon31;
    Polygon polygon32;
    Polygon polygon33;
    Polygon polygon34;
    Polygon polygon35;
    Polygon polygon36;
    Polygon polygon37;
    Polygon polygon38;
    Polygon polygon39;
    Polygon polygon40;
    Polygon polygon41;
    Polygon polygon42;
    Polygon polygon43;
    Polygon polygon44;
    Polygon polygon45;
    Polygon polygon46;
    Polygon polygon47;
    Polygon polygon48;
    Polygon polygon49;
    Polygon polygon50;
    /*Polygons for looks*/
    Polygon polygonA1;
    Polygon polygonA2;
    Polygon polygonA3;
    Polygon polygonA4;
    Polygon polygonA5;
    Polygon polygonA6;
    Polygon polygonA7;
    Polygon polygonA8;
    Polygon polygonA9;
    Polygon polygonA10;
    Polygon polygonA11;
    Polygon polygonA12;
    Polygon polygonA13;
    Polygon polygonA14;
    Polygon polygonA15;
    Polygon polygonA16;
    Polygon polygonA17;
    Polygon polygonA18;
    Polygon polygonA19;
    Polygon polygonA20;
    Polygon polygonA21;
    Polygon polygonA22;
    Polygon polygonA23;
    Polygon polygonA24;
    Polygon polygonA25;
    Polygon polygonA26;
    Polygon polygonA27;


    Handler mHandler = new Handler();
    Runnable mRunnable;



    /* This function is used to connect and 'Fetch' data from thingspeak/cloud only */
    @SuppressLint("StaticFieldLeak")
    class FetchThingspeakTask extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void... urls) {
            try {
                URL url=new URL(THINGSPEAK_CHANNEL_URL + THINGSPEAK_CHANNEL_ID +
                        THINGSPEAK_FEEDS_LAST + THINGSPEAK_API_KEY_STRING + "=" +
                        THINGSPEAK_API_KEY + "");
                HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder=new StringBuilder();
                    String line;
                    while ((line=bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        /*This function gets the data from thingspeak/cloud and stores it into our 'parkEsensor' variables */
        protected void onPostExecute(String response) {
            if (response == null) {
                Toast.makeText(MapsActivity.this, "There was an error", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                JSONObject channel=(JSONObject) new JSONTokener(response).nextValue();
                parkESensor1 = channel.getInt(THINGSPEAK_FIELD1);
                parkESensor2 = channel.getInt(THINGSPEAK_FIELD2);
                parkESensor3 = channel.getInt(THINGSPEAK_FIELD3);
                parkESensor4 = channel.getInt(THINGSPEAK_FIELD4);
                parkESensor5 = channel.getInt(THINGSPEAK_FIELD5);
                /*
                parkESensor6 = channel.getInt(THINGSPEAK_FIELD6);
                parkESensor7 = channel.getInt(THINGSPEAK_FIELD7);
                parkESensor8 = channel.getInt(THINGSPEAK_FIELD8);
                parkESensor9 = channel.getInt(THINGSPEAK_FIELD9);
                parkESensor10 = channel.getInt(THINGSPEAK_FIELD10);
                parkESensor11 = channel.getInt(THINGSPEAK_FIELD11);
                parkESensor12 = channel.getInt(THINGSPEAK_FIELD12);
                parkESensor13 = channel.getInt(THINGSPEAK_FIELD13);
                parkESensor14 = channel.getInt(THINGSPEAK_FIELD14);
                parkESensor15 = channel.getInt(THINGSPEAK_FIELD15);
                parkESensor16 = channel.getInt(THINGSPEAK_FIELD16);
                parkESensor17 = channel.getInt(THINGSPEAK_FIELD17);
                parkESensor18 = channel.getInt(THINGSPEAK_FIELD18);
                parkESensor19 = channel.getInt(THINGSPEAK_FIELD19);
                parkESensor20 = channel.getInt(THINGSPEAK_FIELD20);
                parkESensor21 = channel.getInt(THINGSPEAK_FIELD21);
                parkESensor22 = channel.getInt(THINGSPEAK_FIELD22);
                parkESensor23 = channel.getInt(THINGSPEAK_FIELD23);
                parkESensor24 = channel.getInt(THINGSPEAK_FIELD24);
                parkESensor25 = channel.getInt(THINGSPEAK_FIELD25);
                parkESensor26 = channel.getInt(THINGSPEAK_FIELD26);
                parkESensor27 = channel.getInt(THINGSPEAK_FIELD27);
                parkESensor28 = channel.getInt(THINGSPEAK_FIELD28);
                parkESensor29 = channel.getInt(THINGSPEAK_FIELD29);
                parkESensor30 = channel.getInt(THINGSPEAK_FIELD30);
                parkESensor31 = channel.getInt(THINGSPEAK_FIELD31);
                parkESensor32 = channel.getInt(THINGSPEAK_FIELD32);
                parkESensor33 = channel.getInt(THINGSPEAK_FIELD33);
                parkESensor34 = channel.getInt(THINGSPEAK_FIELD34);
                parkESensor35 = channel.getInt(THINGSPEAK_FIELD35);
                parkESensor36 = channel.getInt(THINGSPEAK_FIELD36);
                parkESensor37 = channel.getInt(THINGSPEAK_FIELD37);
                parkESensor38 = channel.getInt(THINGSPEAK_FIELD38);
                parkESensor39 = channel.getInt(THINGSPEAK_FIELD39);
                parkESensor40 = channel.getInt(THINGSPEAK_FIELD40);
                parkESensor41 = channel.getInt(THINGSPEAK_FIELD41);
                parkESensor42 = channel.getInt(THINGSPEAK_FIELD42);
                parkESensor43 = channel.getInt(THINGSPEAK_FIELD43);
                parkESensor44 = channel.getInt(THINGSPEAK_FIELD44);
                parkESensor45 = channel.getInt(THINGSPEAK_FIELD45);
                parkESensor46 = channel.getInt(THINGSPEAK_FIELD46);
                parkESensor47 = channel.getInt(THINGSPEAK_FIELD47);
                parkESensor48 = channel.getInt(THINGSPEAK_FIELD48);
                parkESensor49 = channel.getInt(THINGSPEAK_FIELD49);
                parkESensor50 = channel.getInt(THINGSPEAK_FIELD50);
                */

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager=(LocationManager) getSystemService(LOCATION_SERVICE);

        if (!isLocationEnabled()) {
            showAlert(1);
        }

        mRequestingLocationUpdates=false;
        mFusedLocationClient=LocationServices.getFusedLocationProviderClient(this);

        createLocationCallback();
        createLocationRequest();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;

/*
        // this was just extra code
        LatLng FIUParking = new LatLng(25.769393, -80.367177);
        mMap.addMarker(new MarkerOptions().position(FIUParking).title("Me"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FIUParking, 20));
*/
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        enableMyLocation();
        startLocationUpdates();
        handler.postDelayed(runnable, 0);


        /*the widget switch to change map type from normal to satellite view*/
        Switch aSwitch=findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // satellite view
                } else {
                    // The toggle is disabled
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });
        //mMap.setMapType(mMap.MAP_TYPE_SATELLITE); // satellite view


        /*Here we have the coordinates for each parking spot which draws on the map*/
        polygon1 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769375, -80.367100), //bottom right point
                        new LatLng(25.769375, -80.367150), //bottom left
                        new LatLng(25.769400, -80.367150), // top left
                        new LatLng(25.769400, -80.367100)));// top right

        polygon2 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769350, -80.367100),
                        new LatLng(25.769350, -80.367150),
                        new LatLng(25.769375, -80.367150),
                        new LatLng(25.769375, -80.367100)));

        polygon3 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769325, -80.367100),
                        new LatLng(25.769325, -80.367150),
                        new LatLng(25.769350, -80.367150),
                        new LatLng(25.769350, -80.367100)));

        polygon4 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769375, -80.367210),
                        new LatLng(25.769375, -80.367260),
                        new LatLng(25.769400, -80.367260),
                        new LatLng(25.769400, -80.367210)));

        polygon5 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769350, -80.367210),
                        new LatLng(25.769350, -80.367260),
                        new LatLng(25.769375, -80.367260),
                        new LatLng(25.769375, -80.367210)));

        polygon6 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769325, -80.367210),
                        new LatLng(25.769325, -80.367260),
                        new LatLng(25.769350, -80.367260),
                        new LatLng(25.769350, -80.367210)));


        polygon7 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769325, -80.367020), //bottom right
                        new LatLng(25.769325, -80.367070), //bottom left
                        new LatLng(25.769350, -80.367070), // top left
                        new LatLng(25.769350, -80.367020)));// top right

        polygon8 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769350, -80.367020),
                        new LatLng(25.769350, -80.367070),
                        new LatLng(25.769375, -80.367070),
                        new LatLng(25.769375, -80.367020)));

        polygon9 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769375, -80.367020),
                        new LatLng(25.769375, -80.367070),
                        new LatLng(25.769400, -80.367070),
                        new LatLng(25.769400, -80.367020)));

        polygon10 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769400, -80.367020),
                        new LatLng(25.769400, -80.367070),
                        new LatLng(25.769425, -80.367070),
                        new LatLng(25.769425, -80.367020)));

        polygon11 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769470, -80.367020),
                        new LatLng(25.769470, -80.367070),
                        new LatLng(25.769495, -80.367070),
                        new LatLng(25.769495, -80.367020)));

        polygon12 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769495, -80.367020),
                        new LatLng(25.769495, -80.367070),
                        new LatLng(25.769520, -80.367070),
                        new LatLng(25.769520, -80.367020)));

        polygon13=googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769520, -80.367020), //bottom right point
                        new LatLng(25.769520, -80.367070), //bottom left
                        new LatLng(25.769545, -80.367070), // top left
                        new LatLng(25.769545, -80.367020)));// top right

        polygon14 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769545, -80.367020),
                        new LatLng(25.769545, -80.367070),
                        new LatLng(25.769570, -80.367070),
                        new LatLng(25.769570, -80.367020)));

        polygon15 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769570, -80.367020),
                        new LatLng(25.769570, -80.367070),
                        new LatLng(25.769595, -80.367070),
                        new LatLng(25.769595, -80.367020)));

        polygon16 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769595, -80.367020),
                        new LatLng(25.769595, -80.367070),
                        new LatLng(25.769620, -80.367070),
                        new LatLng(25.769620, -80.367020)));

        polygon17 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769620, -80.367020),
                        new LatLng(25.769620, -80.367070),
                        new LatLng(25.769645, -80.367070),
                        new LatLng(25.769645, -80.367020)));

        polygon18 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769645, -80.367020),
                        new LatLng(25.769645, -80.367070),
                        new LatLng(25.769670, -80.367070),
                        new LatLng(25.769670, -80.367020)));

        polygon19 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769670, -80.367020), //bottom right
                        new LatLng(25.769670, -80.367070), //bottom left
                        new LatLng(25.769695, -80.367070), // top left
                        new LatLng(25.769695, -80.367020)));// top right

        polygon20 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769695, -80.367020),
                        new LatLng(25.769695, -80.367070),
                        new LatLng(25.769720, -80.367070),
                        new LatLng(25.769720, -80.367020)));

        /* Next Section*/
        polygon21 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769740, -80.367030),
                        new LatLng(25.769740, -80.367080),
                        new LatLng(25.769765, -80.367080),
                        new LatLng(25.769765, -80.367030)));

        polygon22 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769765, -80.367030),
                        new LatLng(25.769765, -80.367080),
                        new LatLng(25.769790, -80.367080),
                        new LatLng(25.769790, -80.367030)));

        polygon23 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769790, -80.367030),
                        new LatLng(25.769790, -80.367080),
                        new LatLng(25.769815, -80.367080),
                        new LatLng(25.769815, -80.367030)));

        polygon24 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769815, -80.367030),
                        new LatLng(25.769815, -80.367080),
                        new LatLng(25.769840, -80.367080),
                        new LatLng(25.769840, -80.367030)));

        polygon25 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769840, -80.367030),
                        new LatLng(25.769840, -80.367080),
                        new LatLng(25.769865, -80.367080),
                        new LatLng(25.769865, -80.367030)));

        polygon26 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769865, -80.367030),
                        new LatLng(25.769865, -80.367080),
                        new LatLng(25.769890, -80.367080),
                        new LatLng(25.769890, -80.367030)));

        polygon27 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769890, -80.367030),
                        new LatLng(25.769890, -80.367080),
                        new LatLng(25.769915, -80.367080),
                        new LatLng(25.769915, -80.367030)));

        polygon28 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769915, -80.367030),
                        new LatLng(25.769915, -80.367080),
                        new LatLng(25.769940, -80.367080),
                        new LatLng(25.769940, -80.367030)));

        polygon29 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769940, -80.367030), //bottom right
                        new LatLng(25.769940, -80.367080), //bottom left
                        new LatLng(25.769965, -80.367080), // top left
                        new LatLng(25.769965, -80.367030)));// top right

        polygon30 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769965, -80.367030),
                        new LatLng(25.769965, -80.367080),
                        new LatLng(25.769990, -80.367080),
                        new LatLng(25.769990, -80.367030)));

        polygon31 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769990, -80.367030),
                        new LatLng(25.769990, -80.367080),
                        new LatLng(25.770015, -80.367080),
                        new LatLng(25.770015, -80.367030)));
        /* Next section*/
        polygon32 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770100, -80.367040),
                        new LatLng(25.770100, -80.367090),
                        new LatLng(25.770125, -80.367090),
                        new LatLng(25.770125, -80.367040)));

        polygon33 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770125, -80.367040),
                        new LatLng(25.770125, -80.367090),
                        new LatLng(25.770150, -80.367090),
                        new LatLng(25.770150, -80.367040)));

        polygon34 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770150, -80.367040),
                        new LatLng(25.770150, -80.367090),
                        new LatLng(25.770175, -80.367090),
                        new LatLng(25.770175, -80.367040)));

        polygon35 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770175, -80.367040),
                        new LatLng(25.770175, -80.367090),
                        new LatLng(25.770200, -80.367090),
                        new LatLng(25.770200, -80.367040)));

        polygon36 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770200, -80.367040),
                        new LatLng(25.770200, -80.367090),
                        new LatLng(25.770225, -80.367090),
                        new LatLng(25.770225, -80.367040)));

        polygon37 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770225, -80.367040),
                        new LatLng(25.770225, -80.367090),
                        new LatLng(25.770250, -80.367090),
                        new LatLng(25.770250, -80.367040)));

        polygon38 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770250, -80.367040),
                        new LatLng(25.770250, -80.367090),
                        new LatLng(25.770275, -80.367090),
                        new LatLng(25.770275, -80.367040)));

        polygon39 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770275, -80.367040), //bottom right
                        new LatLng(25.770275, -80.367090), //bottom left
                        new LatLng(25.770300, -80.367090), // top left
                        new LatLng(25.770300, -80.367040)));// top right

        polygon40 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770300, -80.367040),
                        new LatLng(25.770300, -80.367090),
                        new LatLng(25.770325, -80.367090),
                        new LatLng(25.770325, -80.367040)));

        /*Next Section*/
        polygon41 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770350, -80.367050),
                        new LatLng(25.770350, -80.367100),
                        new LatLng(25.770375, -80.367100),
                        new LatLng(25.770375, -80.367050)));

        polygon42 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770375, -80.367050),
                        new LatLng(25.770375, -80.367100),
                        new LatLng(25.770400, -80.367100),
                        new LatLng(25.770400, -80.367050)));

        polygon43 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770400, -80.367050),
                        new LatLng(25.770400, -80.367100),
                        new LatLng(25.770425, -80.367100),
                        new LatLng(25.770425, -80.367050)));

        polygon44 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770425, -80.367050),
                        new LatLng(25.770425, -80.367100),
                        new LatLng(25.770450, -80.367100),
                        new LatLng(25.770450, -80.367050)));

        polygon45 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770450, -80.367050),
                        new LatLng(25.770450, -80.367100),
                        new LatLng(25.770475, -80.367100),
                        new LatLng(25.770475, -80.367050)));

        polygon46 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770475, -80.367050),
                        new LatLng(25.770475, -80.367100),
                        new LatLng(25.770500, -80.367100),
                        new LatLng(25.770500, -80.367050)));

        polygon47 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770500, -80.367050),
                        new LatLng(25.770500, -80.367100),
                        new LatLng(25.770525, -80.367100),
                        new LatLng(25.770525, -80.367050)));

        polygon48 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770525, -80.367050),
                        new LatLng(25.770525, -80.367100),
                        new LatLng(25.770550, -80.367100),
                        new LatLng(25.770550, -80.367050)));

        polygon49 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770550, -80.367050), //bottom right
                        new LatLng(25.770550, -80.367100), //bottom left
                        new LatLng(25.770575, -80.367100), // top left
                        new LatLng(25.770575, -80.367050)));// top right

        polygon50 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770575, -80.367050),
                        new LatLng(25.770575, -80.367100),
                        new LatLng(25.770600, -80.367100),
                        new LatLng(25.770600, -80.367050)));

        /* Polygons for looks */
        polygonA1 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769335, -80.366895),
                        new LatLng(25.769335, -80.366945),
                        new LatLng(25.770740, -80.367000),
                        new LatLng(25.770740, -80.366950)));
        polygonA1.setStrokeColor(Color.RED);
        polygonA1.setFillColor(Color.RED);

        polygonA2 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769335, -80.366830),
                        new LatLng(25.769335, -80.366880),
                        new LatLng(25.770740, -80.366930),
                        new LatLng(25.770740, -80.366880)));
        polygonA2.setStrokeColor(Color.RED);
        polygonA2.setFillColor(Color.RED);

        polygonA3 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769340, -80.366715),
                        new LatLng(25.769340, -80.366765),
                        new LatLng(25.770745, -80.366820),
                        new LatLng(25.770745, -80.366770)));
        polygonA3.setStrokeColor(Color.RED);
        polygonA3.setFillColor(Color.RED);

        polygonA4 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769350, -80.366300),
                        new LatLng(25.769350, -80.366350),
                        new LatLng(25.770755, -80.366400),
                        new LatLng(25.770755, -80.366350)));
        polygonA4.setStrokeColor(Color.RED);
        polygonA4.setFillColor(Color.RED);

        polygonA5 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769360, -80.366185),
                        new LatLng(25.769360, -80.366235),
                        new LatLng(25.770760, -80.366290),
                        new LatLng(25.770760, -80.366240)));
        polygonA5.setStrokeColor(Color.RED);
        polygonA5.setFillColor(Color.RED);

        polygonA6 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769360, -80.366120),
                        new LatLng(25.769360, -80.366170),
                        new LatLng(25.770760, -80.366220),
                        new LatLng(25.770760, -80.366170)));
        polygonA6.setStrokeColor(Color.RED);
        polygonA6.setFillColor(Color.RED);

        polygonA7 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769360, -80.366005),
                        new LatLng(25.769360, -80.366055),
                        new LatLng(25.770770, -80.366105),
                        new LatLng(25.770770, -80.366055)));
        polygonA7.setStrokeColor(Color.RED);
        polygonA7.setFillColor(Color.RED);

        polygonA8 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770550, -80.368295),
                        new LatLng(25.770540, -80.368815),
                        new LatLng(25.770590, -80.368815),
                        new LatLng(25.770600, -80.368295)));
        polygonA8.setStrokeColor(Color.RED);
        polygonA8.setFillColor(Color.RED);

        polygonA9 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770500, -80.368295),
                        new LatLng(25.770490, -80.368815),
                        new LatLng(25.770540, -80.368815),
                        new LatLng(25.770550, -80.368295)));
        polygonA9.setStrokeColor(Color.RED);
        polygonA9.setFillColor(Color.RED);

        polygonA10 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770380, -80.368290),
                        new LatLng(25.770370, -80.368810),
                        new LatLng(25.770410, -80.368810),
                        new LatLng(25.770420, -80.368290)));
        polygonA10.setStrokeColor(Color.RED);
        polygonA10.setFillColor(Color.RED);

        polygonA11 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770330, -80.368290),
                        new LatLng(25.770320, -80.368810),
                        new LatLng(25.770370, -80.368810),
                        new LatLng(25.770380, -80.368290)));
        polygonA11.setStrokeColor(Color.RED);
        polygonA11.setFillColor(Color.RED);

        polygonA12 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770250, -80.368295),
                        new LatLng(25.770240, -80.368815),
                        new LatLng(25.770190, -80.368815),
                        new LatLng(25.770200, -80.368295)));
        polygonA12.setStrokeColor(Color.RED);
        polygonA12.setFillColor(Color.RED);

        polygonA13 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770200, -80.368295),
                        new LatLng(25.770190, -80.368815),
                        new LatLng(25.770140, -80.368815),
                        new LatLng(25.770150, -80.368295)));
        polygonA13.setStrokeColor(Color.RED);
        polygonA13.setFillColor(Color.RED);

        polygonA14 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770020, -80.368385),
                        new LatLng(25.770020, -80.368585),
                        new LatLng(25.770070, -80.368585),
                        new LatLng(25.770070, -80.368385)));
        polygonA14.setStrokeColor(Color.RED);
        polygonA14.setFillColor(Color.RED);

        polygonA15 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769950, -80.368385),
                        new LatLng(25.769950, -80.368585),
                        new LatLng(25.770000, -80.368585),
                        new LatLng(25.770000, -80.368385)));
        polygonA15.setStrokeColor(Color.RED);
        polygonA15.setFillColor(Color.RED);

        polygonA16 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769825, -80.368385),
                        new LatLng(25.769825, -80.368755),
                        new LatLng(25.769875, -80.368755),
                        new LatLng(25.769875, -80.368385)));
        polygonA16.setStrokeColor(Color.RED);
        polygonA16.setFillColor(Color.RED);

        polygonA17 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769775, -80.368340),
                        new LatLng(25.769775, -80.368755),
                        new LatLng(25.769825, -80.368755),
                        new LatLng(25.769825, -80.368340)));
        polygonA17.setStrokeColor(Color.RED);
        polygonA17.setFillColor(Color.RED);

        polygonA18 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769645, -80.368340),
                        new LatLng(25.769645, -80.368755),
                        new LatLng(25.769695, -80.368755),
                        new LatLng(25.769695, -80.368340)));
        polygonA18.setStrokeColor(Color.RED);
        polygonA18.setFillColor(Color.RED);

        polygonA19 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769595, -80.368340),
                        new LatLng(25.769595, -80.368755),
                        new LatLng(25.769645, -80.368755),
                        new LatLng(25.769645, -80.368340)));
        polygonA19.setStrokeColor(Color.RED);
        polygonA19.setFillColor(Color.RED);

        polygonA20 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769470, -80.368255),
                        new LatLng(25.769470, -80.368715),
                        new LatLng(25.769520, -80.368715),
                        new LatLng(25.769520, -80.368255)));
        polygonA20.setStrokeColor(Color.RED);
        polygonA20.setFillColor(Color.RED);

        polygonA21 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769420, -80.368255),
                        new LatLng(25.769420, -80.368715),
                        new LatLng(25.769470, -80.368715),
                        new LatLng(25.769470, -80.368255)));
        polygonA21.setStrokeColor(Color.RED);
        polygonA21.setFillColor(Color.RED);

        polygonA22 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.769295, -80.368255),
                        new LatLng(25.769295, -80.368715),
                        new LatLng(25.769345, -80.368715),
                        new LatLng(25.769345, -80.368255)));
        polygonA22.setStrokeColor(Color.RED);
        polygonA22.setFillColor(Color.RED);

        polygonA23 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770890, -80.366185),
                        new LatLng(25.770890, -80.367010),
                        new LatLng(25.770940, -80.367010),
                        new LatLng(25.770940, -80.366185)));
        polygonA23.setStrokeColor(Color.RED);
        polygonA23.setFillColor(Color.RED);

        polygonA24 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770840, -80.366185),
                        new LatLng(25.770840, -80.367010),
                        new LatLng(25.770890, -80.367010),
                        new LatLng(25.770890, -80.366185)));
        polygonA24.setStrokeColor(Color.RED);
        polygonA24.setFillColor(Color.RED);

        polygonA25 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.770970, -80.366185),
                        new LatLng(25.770970, -80.366950),
                        new LatLng(25.771070, -80.366950),
                        new LatLng(25.771070, -80.366185)));
        polygonA25.setStrokeColor(Color.RED);
        polygonA25.setFillColor(Color.RED);

        polygonA26 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.771130, -80.366185),
                        new LatLng(25.771130, -80.366950),
                        new LatLng(25.771230, -80.366950),
                        new LatLng(25.771230, -80.366185)));
        polygonA26.setStrokeColor(Color.RED);
        polygonA26.setFillColor(Color.RED);

        polygonA26 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.771295, -80.366185),
                        new LatLng(25.771295, -80.366950),
                        new LatLng(25.771395, -80.366950),
                        new LatLng(25.771395, -80.366185)));
        polygonA26.setStrokeColor(Color.RED);
        polygonA26.setFillColor(Color.RED);

        polygonA27 = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(25.771465, -80.366185),
                        new LatLng(25.771465, -80.366950),
                        new LatLng(25.771515, -80.366950),
                        new LatLng(25.771515, -80.366185)));
        polygonA27.setStrokeColor(Color.RED);
        polygonA27.setFillColor(Color.RED);

        mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            @Override
            public void onPolygonClick(Polygon polygon) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MapsActivity.this);

                @SuppressLint("InflateParams")
                View mView = getLayoutInflater().inflate(R.layout.dialog_info, null);
                @SuppressLint("WrongViewCast")
                final NumberPicker numberPicker = mView.findViewById(R.id.numberHours);
                numberPicker.setMinValue(0);
                numberPicker.setMaxValue(24);
                Button mPay = mView.findViewById(R.id.btnPay);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                mPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(numberPicker.getValue() > 0){
                            Toast.makeText(MapsActivity.this,"Thank You", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(MapsActivity.this, "Please pick your Hours", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        final ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    toggleButton.setTextColor(Color.BLUE);
                    mRunnable =new Runnable() {
                        @Override
                        public void run() {
                            mMap.moveCamera(CameraUpdateFactory.zoomTo(20));
                            LatLng latLng = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
                            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                            mHandler.postDelayed(this, 1000);
                        }
                    };
                    mHandler.postDelayed(mRunnable,1000);
                }
                else {
                    mHandler.removeCallbacks(mRunnable);
                    toggleButton.setTextColor(Color.BLACK);
                    //mHandler.removeCallbacks(mRunnable);
                    //mMap.moveCamera(CameraUpdateFactory.zoomTo(20));
                    LatLng latLng= new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                }

            }

        });
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder parkingInfo = new AlertDialog.Builder(MapsActivity.this);
                LayoutInflater inflater = LayoutInflater.from(MapsActivity.this);
                @SuppressLint("InflateParams")
                View view1 = inflater.inflate(R.layout.image_info, null);
                parkingInfo.setView(view1);
                parkingInfo.show();

            }
        });
    }


    /* This function runs itself and other functions every second */
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            new FetchThingspeakTask().execute();

            //Toast.makeText(MapsActivity.this, String.valueOf(parkESensor1), Toast.LENGTH_LONG).show();
            if (parkESensor1 == 0) {
                polygon1.setFillColor(Color.GREEN);
            }
            else{
                polygon1.setFillColor(Color.RED); //red
            }
            if (parkESensor2 == 0) {
                polygon2.setFillColor(Color.GREEN);
            }
            else{
                polygon2.setFillColor(Color.RED);
            }
            if (parkESensor3 == 0) {
                polygon3.setFillColor(Color.GREEN);
            }
            else{
                polygon3.setFillColor(Color.RED);
            }
            if (parkESensor4 == 0) {
                polygon4.setFillColor(Color.GREEN);
            }
            else{
                polygon4.setFillColor(Color.RED);
            }
            if (parkESensor5 == 0) {
                polygon5.setFillColor(Color.GREEN);
            }
            else{
                polygon5.setFillColor(Color.RED);
            }
            if (parkESensor6 == 1) {
                polygon6.setFillColor(Color.GREEN);
            }
            else{
                polygon6.setFillColor(Color.RED);
            }
            if (parkESensor7 == 1) {
                polygon7.setFillColor(Color.GREEN);
            }
            else{
                polygon7.setFillColor(Color.RED);
            }
            if (parkESensor8 == 1) {
                polygon8.setFillColor(Color.GREEN);
            }
            else{
                polygon8.setFillColor(Color.RED);
            }
            if (parkESensor9 == 1) {
                polygon9.setFillColor(Color.GREEN);
            }
            else{
                polygon9.setFillColor(Color.RED);
            }
            if (parkESensor10 == 1) {
                polygon10.setFillColor(Color.GREEN);
            }
            else{
                polygon10.setFillColor(Color.RED);
            }
            if (parkESensor11 == 1) {
                polygon11.setFillColor(Color.GREEN);
            }
            else{
                polygon11.setFillColor(Color.RED);
            }
            if (parkESensor12 == 1) {
                polygon12.setFillColor(Color.GREEN);
            }
            else{
                polygon12.setFillColor(Color.RED);
            }
            if (parkESensor13 == 1) {
                polygon13.setFillColor(Color.GREEN);
            }
            else{
                polygon13.setFillColor(Color.RED);
            }
            if (parkESensor14 == 1) {
                polygon14.setFillColor(Color.GREEN);
            }
            else{
                polygon14.setFillColor(Color.RED);
            }
            if (parkESensor15 == 1) {
                polygon15.setFillColor(Color.GREEN);
            }
            else{
                polygon15.setFillColor(Color.RED);
            }
            if (parkESensor16 == 1) {
                polygon16.setFillColor(Color.GREEN);
            }
            else{
                polygon16.setFillColor(Color.RED);
            }
            if (parkESensor17 == 1) {
                polygon17.setFillColor(Color.GREEN);
            }
            else{
                polygon17.setFillColor(Color.RED);
            }
            if (parkESensor18 == 1) {
                polygon18.setFillColor(Color.GREEN);
            }
            else{
                polygon18.setFillColor(Color.RED);
            }
            if (parkESensor19 == 1) {
                polygon19.setFillColor(Color.GREEN);
            }
            else{
                polygon19.setFillColor(Color.RED);
            }
            if (parkESensor20 == 1) {
                polygon20.setFillColor(Color.GREEN);
            }
            else{
                polygon20.setFillColor(Color.RED);
            }
            if (parkESensor21 == 1) {
                polygon21.setFillColor(Color.GREEN);
            }
            else{
                polygon21.setFillColor(Color.RED);
            }
            if (parkESensor22 == 1) {
                polygon22.setFillColor(Color.GREEN);
            }
            else{
                polygon22.setFillColor(Color.RED);
            }
            if (parkESensor23 == 1) {
                polygon23.setFillColor(Color.GREEN);
            }
            else{
                polygon23.setFillColor(Color.RED);
            }
            if (parkESensor24 == 1) {
                polygon24.setFillColor(Color.GREEN);
            }
            else{
                polygon24.setFillColor(Color.RED);
            }
            if (parkESensor25 == 1) {
                polygon25.setFillColor(Color.GREEN);
            }
            else{
                polygon25.setFillColor(Color.RED);
            }
            if (parkESensor26 == 1) {
                polygon26.setFillColor(Color.GREEN);
            }
            else{
                polygon26.setFillColor(Color.RED);
            }
            if (parkESensor27 == 1) {
                polygon27.setFillColor(Color.GREEN);
            }
            else{
                polygon27.setFillColor(Color.RED);
            }
            if (parkESensor28 == 1) {
                polygon28.setFillColor(Color.GREEN);
            }
            else{
                polygon28.setFillColor(Color.RED);
            }
            if (parkESensor29 == 1) {
                polygon29.setFillColor(Color.GREEN);
            }
            else{
                polygon29.setFillColor(Color.RED);
            }
            if (parkESensor30 == 1) {
                polygon30.setFillColor(Color.GREEN);
            }
            else{
                polygon30.setFillColor(Color.RED);
            }
            if (parkESensor31 == 1) {
                polygon31.setFillColor(Color.GREEN);
            }
            else{
                polygon31.setFillColor(Color.RED);
            }
            if (parkESensor32 == 1) {
                polygon32.setFillColor(Color.GREEN);
            }
            else{
                polygon32.setFillColor(Color.RED);
            }
            if (parkESensor33 == 1) {
                polygon33.setFillColor(Color.GREEN);
            }
            else{
                polygon33.setFillColor(Color.RED);
            }
            if (parkESensor34 == 1) {
                polygon34.setFillColor(Color.GREEN);
            }
            else{
                polygon34.setFillColor(Color.RED);
            }
            if (parkESensor35 == 1) {
                polygon35.setFillColor(Color.GREEN);
            }
            else{
                polygon35.setFillColor(Color.RED);
            }
            if (parkESensor36 == 1) {
                polygon36.setFillColor(Color.GREEN);
            }
            else{
                polygon36.setFillColor(Color.RED);
            }
            if (parkESensor37 == 1) {
                polygon37.setFillColor(Color.GREEN);
            }
            else{
                polygon37.setFillColor(Color.RED);
            }
            if (parkESensor38 == 1) {
                polygon38.setFillColor(Color.GREEN);
            }
            else{
                polygon38.setFillColor(Color.RED);
            }
            if (parkESensor39 == 1) {
                polygon39.setFillColor(Color.GREEN);
            }
            else{
                polygon39.setFillColor(Color.RED);
            }
            if (parkESensor40 == 1) {
                polygon40.setFillColor(Color.GREEN);
            }
            else{
                polygon40.setFillColor(Color.RED);
            }
            if (parkESensor41 == 1) {
                polygon41.setFillColor(Color.GREEN);
            }
            else{
                polygon41.setFillColor(Color.RED);
            }
            if (parkESensor42 == 1) {
                polygon42.setFillColor(Color.GREEN);
            }
            else{
                polygon42.setFillColor(Color.RED);
            }
            if (parkESensor43 == 1) {
                polygon43.setFillColor(Color.GREEN);
            }
            else{
                polygon43.setFillColor(Color.RED);
            }
            if (parkESensor44 == 1) {
                polygon44.setFillColor(Color.GREEN);
            }
            else{
                polygon44.setFillColor(Color.RED);
            }
            if (parkESensor45 == 1) {
                polygon45.setFillColor(Color.GREEN);
            }
            else{
                polygon45.setFillColor(Color.RED);
            }
            if (parkESensor46 == 1) {
                polygon46.setFillColor(Color.GREEN);
            }
            else{
                polygon46.setFillColor(Color.RED);
            }
            if (parkESensor47 == 1) {
                polygon47.setFillColor(Color.GREEN);
            }
            else{
                polygon47.setFillColor(Color.RED);
            }
            if (parkESensor48 == 1) {
                polygon48.setFillColor(Color.GREEN);
            }
            else{
                polygon48.setFillColor(Color.RED);
            }
            if (parkESensor49 == 1) {
                polygon49.setFillColor(Color.GREEN);
            }
            else{
                polygon49.setFillColor(Color.RED);
            }
            if (parkESensor50 == 1) {
                polygon50.setFillColor(Color.GREEN);
            }
            else{
                polygon50.setFillColor(Color.RED);
            }

            handler.postDelayed(this, 0);

        }

    };


    /* check if the gps is on on first runtime*/
    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    /* the dialog box to turn on the gps and sends user to location settings*/
    private void showAlert(final int status) {
        String message, title, btnText;
        if (status == 1) {
            message = "Please turn on GPS to allow this app to access your location";
            title = "Enable Location";
            btnText = "Location Settings";
        } else {
            message = "Please turn on GPS to allow this app to access your location";
            title = "Permission access";
            btnText = "Grant";
        }
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        //dialog.setCancelable(false);
        dialog.setTitle(title)
                .setMessage(message)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.M)
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        if (status == 1) {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(myIntent);
                        } else
                            requestPermissions(PERMISSIONS, PERMISSION_ALL);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        //finish();

                    }
                });
        dialog.show();
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(MapsActivity.this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    private void createLocationRequest() {
        mLocationRequest = new LocationRequest();

        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        // Sets the desired interval for active location updates. This interval is
        // inexact. You may not receive updates at all if no location sources are available, or
        // you may receive them slower than requested. You may also receive updates faster than
        // requested if other applications are requesting location at a faster interval.
        mLocationRequest.setInterval(5000);

        // Sets the fastest rate for active location updates. This interval is exact, and your
        // application will never receive updates faster than this value.
        mLocationRequest.setFastestInterval(0);


    }

    private void createLocationCallback() {
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);

                mCurrentLocation = locationResult.getLastLocation();

/*
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(20));
                    LatLng latLng=new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
*/
            }
        };
    }

    @SuppressLint("MissingPermission")
    private void startLocationUpdates() {

        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                mLocationCallback, Looper.myLooper());
    }

}
