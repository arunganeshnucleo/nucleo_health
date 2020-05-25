package com.prod.nucleohealth.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.prod.nucleohealth.R;
import com.prod.nucleohealth.data.model.FamilyContact;
import com.prod.nucleohealth.data.model.Speciality;
import com.prod.nucleohealth.data.model.request.FamilyDetailsRequestModel;
import com.prod.nucleohealth.data.model.request.UserDetailsRequestModel;
import com.prod.nucleohealth.utils.Constants;
import com.prod.nucleohealth.utils.CustomProgressDialog;
import com.prod.nucleohealth.utils.SessionManager;
import com.prod.nucleohealth.view.adapters.FamilyDetailsAdapter;
import com.prod.nucleohealth.view.adapters.SpecialityAdapter;
import com.prod.nucleohealth.viewmodel.FamilyDetailsViewModel;
import com.prod.nucleohealth.viewmodel.SpecialityFilterViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyDetailsFragment extends Fragment {
    private static final String TAG = "FamilyDetailsFragment";
    FamilyDetailsViewModel familyDetailsViewModel;
    CustomProgressDialog progressDialog;
    FamilyDetailsAdapter familyDetailsAdapter;
    ArrayList<FamilyContact> familyContactsList;
    RecyclerView rcFamilyView;
    Button btnBack;
    NavController navController;
    public FamilyDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_family_details, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view){
        rcFamilyView = view.findViewById(R.id.rc_family_details);
        btnBack = view.findViewById(R.id.btn_back);
        familyContactsList = new ArrayList();
        familyDetailsAdapter = new FamilyDetailsAdapter(familyContactsList,getActivity());
        rcFamilyView.setLayoutManager( new LinearLayoutManager(getActivity()));
        rcFamilyView.setAdapter(familyDetailsAdapter);


    }
    private void navigateToHospitalMap(){
        navController.navigate(R.id.action_search_to_hosptialMapFragment);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        familyDetailsViewModel = new ViewModelProvider(this).get(FamilyDetailsViewModel.class);
        getFamilyDetails();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    private void getFamilyDetails(){
        SessionManager session = new SessionManager(getActivity());
        String clientId = session.getClientId();
        progressDialog = CustomProgressDialog.show(getActivity(), true, false);
        FamilyDetailsRequestModel familyDetailsRequestModel = new FamilyDetailsRequestModel();
        familyDetailsRequestModel.setClient_id(clientId);
        familyDetailsViewModel.setClientId(clientId);
        familyDetailsViewModel.setHeader(Constants.ACCEPT_HEADER,session.getSessionToken());
        familyDetailsViewModel.getFamilyDetails();
        familyDetailsViewModel.getFamilyDetailsData().observe(getActivity(), specialityResponseModel -> {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if(specialityResponseModel.getStatus().equals("1")){
                this.familyContactsList.clear();
                this.familyContactsList.addAll(specialityResponseModel.getData());
                this.familyDetailsAdapter.notifyDataSetChanged();
            }
        });
    }
}
