package com.example.emango1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emango1.Pojo.TopExams;
import com.example.emango1.R;

import java.util.ArrayList;

public class ExamDetailsAdapter extends RecyclerView.Adapter<ExamDetailsAdapter.ViewHolder> {

    private final ArrayList<TopExams> mTopExams;

    public ExamDetailsAdapter(ArrayList<TopExams> examList){
        mTopExams = examList;
    }

    @NonNull
    @Override
    public ExamDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_list, parent, false);
        return new ExamDetailsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamDetailsAdapter.ViewHolder holder, int position) {
        holder.examIdView.setText(String.valueOf(mTopExams.get(position).getId()));
        holder.examNameView.setText(mTopExams.get(position).getName());
        holder.examSlugNameView.setText("(" + mTopExams.get(position).getSlug() + ")");
    }


    @Override
    public int getItemCount() {
        return mTopExams.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView examIdView;
        TextView examNameView;
        TextView examSlugNameView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            examIdView = itemView.findViewById(R.id.exam_id);
            examNameView = itemView.findViewById(R.id.exam_name);
            examSlugNameView = itemView.findViewById(R.id.exam_slug_name);
        }
    }
}