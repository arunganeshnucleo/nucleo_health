package com.prod.nucleohealth.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.prod.nucleohealth.R;
import com.prod.nucleohealth.data.model.Speciality;

import java.util.ArrayList;

public class SpecialityAdapter extends RecyclerView.Adapter<SpecialityAdapter.SpecialityViewHolder>{
    ArrayList<Speciality> specialityList;
    Context context;
    public SpecialityAdapter(ArrayList<Speciality> specialityList,Context context) {
        this.specialityList = specialityList;
        this.context = context;
    }

    public static class SpecialityViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgSpeciality;
        public TextView txtSpeciality;
        public SpecialityViewHolder(View view) {
            super(view);
            imgSpeciality = view.findViewById(R.id.img_speciality);
            txtSpeciality = view.findViewById(R.id.txt_speciality);
        }

    }

    @Override
    public SpecialityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.speciality_item, parent, false);

        return new SpecialityViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(SpecialityViewHolder holder, int position) {
        Speciality speciality = specialityList.get(position);
        holder.txtSpeciality.setText(speciality.getName());
       // holder.imgSpeciality.setText(userAttemptModel.getUserWord());
        RequestOptions options = new RequestOptions()
                .circleCropTransform()
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.progress_animation)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);
        Glide.with(context).load(speciality.getImgUrl()).apply(options).into(holder.imgSpeciality);

    }
    @Override
    public int getItemCount() {
        return specialityList.size();
    }
}
