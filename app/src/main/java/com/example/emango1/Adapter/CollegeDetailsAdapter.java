package com.example.emango1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emango1.Pojo.TopCollege;
import com.example.emango1.Pojo.User;
import com.example.emango1.R;

import java.util.ArrayList;

public class CollegeDetailsAdapter extends RecyclerView.Adapter<CollegeDetailsAdapter.ViewHolder> {

    private final ArrayList<TopCollege> mCollegeDetails;

    public CollegeDetailsAdapter(ArrayList<TopCollege> collegeList){
        mCollegeDetails = collegeList;
    }

    @NonNull
    @Override
    public CollegeDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.collegeIdView.setText(String.valueOf(mCollegeDetails.get(position).getId()));
        holder.collegeNameView.setText(mCollegeDetails.get(position).getName());
        holder.collegeSlugNameView.setText("(" + mCollegeDetails.get(position).getSlug() + ")");
    }


    @Override
    public int getItemCount() {
        return mCollegeDetails.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView collegeIdView;
        TextView collegeNameView;
        TextView collegeSlugNameView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            collegeIdView = itemView.findViewById(R.id.college_id);
            collegeNameView = itemView.findViewById(R.id.college_name);
            collegeSlugNameView = itemView.findViewById(R.id.college_slug_name);
        }
    }
}
