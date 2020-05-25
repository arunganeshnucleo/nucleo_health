package com.prod.nucleohealth.view.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.prod.nucleohealth.R;
import com.prod.nucleohealth.data.model.HospitalDetails;
import com.prod.nucleohealth.data.model.request.HospitalsRequestModel;
import com.prod.nucleohealth.utils.Constants;
import com.prod.nucleohealth.utils.CustomProgressDialog;
import com.prod.nucleohealth.viewmodel.HospitalMapViewModel;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.MaskTransformation;


/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalMapFragment extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {
    private static final String TAG = "HospitalMapFragment";
    private HospitalMapViewModel hospitalMapViewModel;
    private NavController navController;
    private CustomProgressDialog progressDialog;
    private ArrayList<HospitalDetails> hospitalDetailsList;
    //----Map related stuff
    private SupportMapFragment mapFragment;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private GoogleMap mGoogleMap;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    private  Location mLastLocation;
    private ArrayList<Marker> markerList;
    private  Boolean isMapLoaded;
    private Boolean isHomeLocated;
    private Marker homeMarker;
    private Double selectedLatitude, selectedLongitude;
    //Hospital details
    private ImageView imgHospitalProfile;
    public HospitalMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hosptial_map, container, false);
        initVars();
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.hospitals_map));
        imgHospitalProfile = view.findViewById(R.id.img_hospital_profile);
        setHospitalImage();
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    private void initVars() {
        hospitalDetailsList = new ArrayList<>();
        markerList = new ArrayList<>();
        selectedLatitude = 13.176900;
        selectedLongitude = 80.248040;
        isHomeLocated = false;
        isMapLoaded = false;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hospitalMapViewModel = new ViewModelProvider(this).get(HospitalMapViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    //---Get hospitals from API--
    private void getHospitals() {
        hospitalMapViewModel.setApplicationId(Constants.APPLICATION_ID);
        hospitalMapViewModel.setContentType(Constants.CONTENT_TYPE);
        HospitalsRequestModel hospitalsRequestModel = new HospitalsRequestModel();


        hospitalsRequestModel.setLatitude("13.176900");
        hospitalsRequestModel.setLongitude("80.248040");
        hospitalMapViewModel.setHospitalsRequestModel(hospitalsRequestModel);
        progressDialog = CustomProgressDialog.show(getActivity(), true, false);
        hospitalMapViewModel.getHospitals();
        hospitalMapViewModel.getHospitalsData().observe(getActivity(), hospitalResponseModel -> {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if (hospitalResponseModel.getStatus().equals("1")) {
                this.hospitalDetailsList.clear();
                //HospitalData hospitalData = hospitalResponseModel.getData();
                this.hospitalDetailsList.addAll(hospitalResponseModel.getData().getHospitalDetails());
                addMarkerToMap();
                Toast.makeText(getActivity(),"hospitalData "+this.hospitalDetailsList.size(),Toast.LENGTH_LONG).show();
            }
        });
    }

    //Attach hospital image to imageview
    private void setHospitalImage(){
        Glide.with(getActivity())
                .load(R.drawable.default_hospital)
                .apply(RequestOptions.bitmapTransform(new MaskTransformation(R.drawable.bottom_borderless_shape)))
                .into(imgHospitalProfile);
    }
    private void addMarkerToMap(){
        for(Marker marker:markerList){
            marker.remove();
        }

        for(HospitalDetails hospitalDetails:hospitalDetailsList){
            if(hospitalDetails!=null) {
                addMapMarkers(Double.parseDouble(hospitalDetails.getLatitude()),Double.parseDouble(hospitalDetails.getLongitude()),
                        hospitalDetails.getHospitalName(),hospitalDetails.getAddress1(),hospitalDetails);
            }
        }
    }

    private void addMapMarkers(double lat, double lang, final String name, String address,HospitalDetails hospitalDetails ) {
        LatLng locPosition = new LatLng(lat, lang);
        Marker mapMarker = mGoogleMap.addMarker(new MarkerOptions()
                .position(locPosition)
                .title(name)
                .snippet(address)
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.hospital_pin)));
        mapMarker.setTag(hospitalDetails);
        markerList.add(mapMarker);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        isMapLoaded = true;
        getHospitals();
        mGoogleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //hideMapInfoWindow();
            }
        });

        mGoogleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Object tag = marker.getTag();
                // hideMapInfoWindow();
                if (tag != null) {
                    if (tag != "home") {
                        //lastClicked = marker;
                        // marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.location_selected));
                        //Station station = (Station) marker.getTag();
                        //showStationInfo(station);
                    }

                }
                return true;
            }
        });

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                buildGoogleApiClient();
                mGoogleMap.setMyLocationEnabled(true);
                //initCurrentLocation();
            } else {
                checkLocationPermission();
            }
        } else {
            buildGoogleApiClient();
            mGoogleMap.setMyLocationEnabled(true);
            //initCurrentLocation();
        }
        mGoogleMap.getUiSettings().setMapToolbarEnabled(false);
        mGoogleMap.getUiSettings().setZoomControlsEnabled(false);
        mGoogleMap.setMyLocationEnabled(false);
        mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
    }

    private void styleMap() {
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mGoogleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            getActivity(), R.raw.style_json));

            if (!success) {
                Log.e("MapsActivityRaw", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapsActivityRaw", "Can't find style.", e);
        }
    }

    private void animateCameraToHome(Double lat, Double lng) {
        LatLng locPosition;
        locPosition = new LatLng(lat, lng);
        /*CameraPosition cameraPosition = new CameraPosition.Builder().
                target(new LatLng(lat, lng)).zoom(14).build();
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));*/
        if (homeMarker != null) homeMarker.remove();

        homeMarker = mGoogleMap.addMarker(new MarkerOptions()
                .position(locPosition)
                .title("")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.home_pin)));
        homeMarker.setTag("home");
        LatLng currentLatLng = new LatLng(lat,
                lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(currentLatLng,
                14);
        mGoogleMap.moveCamera(update);

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }


    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onLocationChanged(Location location) {
        if (isHomeLocated) return;
        mLastLocation = location;
        if (isMapLoaded) {
            animateCameraToHome(mLastLocation.getLatitude(), mLastLocation.getLongitude());
            isHomeLocated = true;
        }
    }


    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(getActivity())
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                requestPermissions(
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);

                            }
                        })
                        .create()
                        .show();
            } else {
                // No explanation needed, we can request the permission.
                requestPermissions(
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }

    private void initCurrentLocation() {
        //if(isCurrentLocationDetected) return;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                boolean locationDetected = false;
                LocationManager lm = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                double lat = 0.0;
                double lon = 0.0;
                if (location == null)
                    locationDetected = false;
                else {
                    lat = location.getLatitude();
                    lon = location.getLongitude();
                    locationDetected = true;
                }
                if (mLastLocation != null) {
                    lat = mLastLocation.getLatitude();
                    lon = mLastLocation.getLongitude();
                    locationDetected = true;
                }
                if (!locationDetected) return;
                String latitude = Double.toString(lat);
                String longitude = Double.toString(lon);
                animateCameraToHome(lat, lon);
                /*selectedLatitude = lat;
                selectedLatitude = lon;

                if (longitude != null && latitude != null) {
                    isCurrentLocationDetected = true;
                    isLoadMore = false;
                    nextPageToken = "";
                    isMaxPageReached = false;
                    getSearchMapResult(latitude,longitude);
                }*/
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {

        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {// If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // permission was granted, yay! Do the
                // location-related task you need to do.
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {

                    if (mGoogleApiClient == null) {
                        buildGoogleApiClient();
                    }
                    /////search near  by stations
                    initCurrentLocation();
                    // showFavStations();
                    mGoogleMap.setMyLocationEnabled(true);
                }

            } else {

                // permission denied, boo! Disable the
                // functionality that depends on this permission.

                //Show stations around chicago as user denied location services
                // initCurrentLocation();
                //     getSearchMapResult(Double.toString(mLastLocation.getLatitude()), Double.toString(mLastLocation.getLongitude()));
                // showFavStations();
                //Toast.makeText(getActivity(), "Permission denied, You cannot access location related services", Toast.LENGTH_LONG).show();
            }
            return;
        }
    }
}
