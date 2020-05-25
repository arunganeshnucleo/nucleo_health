package com.prod.nucleohealth.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.prod.nucleohealth.R;
import com.prod.nucleohealth.data.model.Header;
import com.prod.nucleohealth.data.model.UserData;
import com.prod.nucleohealth.data.model.UserDetails;
import com.prod.nucleohealth.data.model.request.LoginRequestModel;
import com.prod.nucleohealth.data.model.request.UserDetailsRequestModel;
import com.prod.nucleohealth.utils.Constants;
import com.prod.nucleohealth.utils.CustomProgressDialog;
import com.prod.nucleohealth.utils.SessionManager;
import com.prod.nucleohealth.viewmodel.DashBoardViewModel;
import com.prod.nucleohealth.viewmodel.LoginViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    DashBoardViewModel dashBoardViewModel;
    NavController navController;
    CustomProgressDialog progressDialog;
    Button btnFindHospital,btnHealthHistory,btnFamilyList;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view){
        btnFindHospital = view.findViewById(R.id.btn_find_hospitals);
        btnFamilyList = view.findViewById(R.id.btn_family_list);
        btnFindHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHospitalFilter();
            }
        });
        btnFamilyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToFamilyList();
            }
        });
    }

    private void navigateToHospitalFilter(){
       // navController.navigate(R.id.action_dashboardFragment_to_filterFragment2);
        navController.navigate(R.id.action_home_to_hosptialMapFragment);
    }

    private void navigateToFamilyList(){
        navController.navigate(R.id.action_home_to_familyDetailsFragment);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        dashBoardViewModel = ViewModelProviders.of(getActivity()).get(DashBoardViewModel.class);
        super.onActivityCreated(savedInstanceState);
        //getClientDetails();
    }

    private void getClientDetails(){

        SessionManager session = new SessionManager(getActivity());
        String clientId = session.getClientId();
        progressDialog = CustomProgressDialog.show(getActivity(), true, false);
        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
        userDetailsRequestModel.setClient_id(clientId);
        dashBoardViewModel.setClientId(clientId);
        dashBoardViewModel.setHeader(Constants.ACCEPT_HEADER,session.getSessionToken());
        dashBoardViewModel.getUserDetails();
        dashBoardViewModel.getUserDetailsData().observe(getActivity(), userDetailsResponseModel -> {
            // Update UI.

            if (userDetailsResponseModel.getStatus().equals(Constants.STATUS_SUCCESS)) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    UserDetails userDetails = userDetailsResponseModel.getData();
                }
            }else{

            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }
}
