package com.prod.nucleohealth.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.prod.nucleohealth.R;
import com.prod.nucleohealth.data.model.FamilyContact;
import com.prod.nucleohealth.data.model.Speciality;

import java.util.ArrayList;

public class FamilyDetailsAdapter extends RecyclerView.Adapter<FamilyDetailsAdapter.FamilyDetailsViewHolder>{
    private ArrayList<FamilyContact> familyContactsList;
    private Context context;

    public FamilyDetailsAdapter(ArrayList<FamilyContact> familyContactsList, Context context) {
        this.familyContactsList = familyContactsList;
        this.context = context;
    }

    static class FamilyDetailsViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName,txtBloodGroup,txtGender,txtRelation;
        public FamilyDetailsViewHolder(View view) {
            super(view);
            txtName = view.findViewById(R.id.txt_name);
            txtBloodGroup = view.findViewById(R.id.txt_blood_group);
            txtGender = view.findViewById(R.id.txt_gender);
            txtRelation = view.findViewById(R.id.txt_relation);
        }
    }

    @NonNull
    @Override
    public FamilyDetailsAdapter.FamilyDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.family_list_item, parent, false);

        return new FamilyDetailsAdapter.FamilyDetailsViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(FamilyDetailsAdapter.FamilyDetailsViewHolder holder, int position) {
        FamilyContact familyContact = familyContactsList.get(position);
        holder.txtName.setText(familyContact.getFirstName()+" "+familyContact.getLastName());
        holder.txtBloodGroup.setText(familyContact.getBloodGroup());
        holder.txtGender.setText(familyContact.getGender());
        holder.txtRelation.setText(familyContact.getRelationship());
    }
    @Override
    public int getItemCount() {
        return familyContactsList.size();
    }
}
