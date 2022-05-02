package com.example.emango1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emango1.Pojo.User;
import com.example.emango1.R;

import java.util.ArrayList;

public class CareerDetailsAdapter extends RecyclerView.Adapter<CareerDetailsAdapter.ViewHolder>{

    private final ArrayList<User> mUsersList;
    private iFragmentSelected mFragmentSelected;

    public CareerDetailsAdapter(ArrayList<User> usersList, iFragmentSelected context){
        mFragmentSelected = context;
        mUsersList = usersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.career_details_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.careerIdView.setText(String.valueOf(mUsersList.get(position).getId()));
        holder.careerNameView.setText(mUsersList.get(position).getTitle());
        holder.additionalButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragmentSelected.userSelected(mUsersList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsersList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
     TextView careerIdView;
     TextView careerNameView;
     Button additionalButtonView;

     public ViewHolder(@NonNull View itemView) {
         super(itemView);
         careerIdView = itemView.findViewById(R.id.career_id);
         careerNameView = itemView.findViewById(R.id.career_name);
         additionalButtonView = itemView.findViewById(R.id.additional_details_button);
     }
 }

    public interface iFragmentSelected {
        public void userSelected(User user);
    }
}
