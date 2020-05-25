package com.prod.nucleohealth.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
import com.prod.nucleohealth.data.model.Speciality;
import com.prod.nucleohealth.data.model.response.SpecialityResponseModel;
import com.prod.nucleohealth.utils.Constants;
import com.prod.nucleohealth.utils.CustomProgressDialog;
import com.prod.nucleohealth.view.adapters.SpecialityAdapter;
import com.prod.nucleohealth.viewmodel.SpecialityFilterViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialityFilterFragment extends Fragment {
    private static final String TAG = "SpecialityFilterFragmen";
    SpecialityFilterViewModel specialityFilterViewModel;
    CustomProgressDialog progressDialog;
    SpecialityAdapter specialityAdapter;
    ArrayList<Speciality> specialityList;
    RecyclerView rcSpecialityView;
    Button btnBack,btnNext;
    NavController navController;
    public SpecialityFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter_speciality, container, false);
        initComponents(view);
        return view;

    }

    private void initComponents(View view){
        rcSpecialityView = view.findViewById(R.id.rc_speciality);
        btnBack = view.findViewById(R.id.btn_back);
        btnNext = view.findViewById(R.id.btn_speciality_next);
        specialityList = new ArrayList();
        specialityAdapter = new SpecialityAdapter(specialityList,getActivity());
        rcSpecialityView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //userAttemeptedListView.setItemAnimator(new DefaultItemAnimator());
        rcSpecialityView.setAdapter(specialityAdapter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHospitalMap();
            }
        });

    }
    private void navigateToHospitalMap(){
        navController.navigate(R.id.action_search_to_hosptialMapFragment);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        specialityFilterViewModel = ViewModelProviders.of(getActivity()).get(SpecialityFilterViewModel.class);
        getSpecialities();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    private void getSpecialities(){
        specialityFilterViewModel.setApplicationId(Constants.APPLICATION_ID);
        specialityFilterViewModel.setAccept(Constants.ACCEPT_HEADER);
        progressDialog = CustomProgressDialog.show(getActivity(), true, false);
        specialityFilterViewModel.getSpecialities();
        specialityFilterViewModel.getSpecialitesData().observe(getActivity(), specialityResponseModel -> {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if(specialityResponseModel.getStatus().equals("1")){
                this.specialityList.clear();
                this.specialityList.addAll(specialityResponseModel.getData());
                this.specialityAdapter.notifyDataSetChanged();
            }
        });
    }
}
