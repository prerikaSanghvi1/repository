package com.example.emango1.Fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emango1.Activity.MainActivity;
import com.example.emango1.Adapter.CareerDetailsAdapter;
import com.example.emango1.Adapter.CollegeDetailsAdapter;
import com.example.emango1.Adapter.ExamDetailsAdapter;
import com.example.emango1.Pojo.User;
import com.example.emango1.R;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class CareerDetailsFragmnt extends Fragment {
    private final User mUser;

    public CareerDetailsFragmnt(User user){
        mUser = user;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.career_details_page, container, false);
        ((TextView) mView.findViewById(R.id.career_header)).setText(mUser.getTitle());

        RecyclerView mCollegeDetails = mView.findViewById(R.id.top_college_list);
        CollegeDetailsAdapter collegeDetailsAdapter = new CollegeDetailsAdapter(new ArrayList<>(mUser.getTopCollegeList()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mCollegeDetails.setLayoutManager(layoutManager);
        mCollegeDetails.setAdapter(collegeDetailsAdapter);

        RecyclerView mExamDetails = mView.findViewById(R.id.top_exam_list);
        ExamDetailsAdapter examDetailsAdapter = new ExamDetailsAdapter(new ArrayList<>(mUser.getTopExamsList()));
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity().getApplicationContext());
        mExamDetails.setLayoutManager(layoutManager1);
        mExamDetails.setAdapter(examDetailsAdapter);
        return mView;
    }
}
