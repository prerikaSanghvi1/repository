package com.example.emango1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.emango1.Adapter.CareerDetailsAdapter;
import com.example.emango1.Fragment.CareerDetailsFragmnt;
import com.example.emango1.Pojo.Authorization;
import com.example.emango1.Pojo.CountryDetails;
import com.example.emango1.Pojo.User;
import com.example.emango1.R;
import com.example.emango1.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CareerDetailsAdapter.iFragmentSelected{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<ArrayList<CountryDetails>> userCall = Service.getService().getDetails(new Authorization());
        userCall.enqueue(new Callback<ArrayList<CountryDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<CountryDetails>> call, Response<ArrayList<CountryDetails>> response) {
                if (response.isSuccessful()) {

                    List<String> spinnerArray = new ArrayList<>();
                    for (CountryDetails countryDetails : response.body()) {
                        spinnerArray.add(countryDetails.getName());
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                    MainActivity.this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
                            Spinner spinner = findViewById(R.id.button1);
                            spinner.setAdapter(adapter);

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CountryDetails>> call, Throwable t) {

            }
        });

        Call<ArrayList<User>> userCall1 = Service.getService().getCareerDetails(new Authorization());
        userCall1.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView mCareerDetails = findViewById(R.id.career_details_list);
                        CareerDetailsAdapter careerDetailsAdapter = new CareerDetailsAdapter(response.body(),
                                (CareerDetailsAdapter.iFragmentSelected) MainActivity.this);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        mCareerDetails.setLayoutManager(layoutManager);
                        mCareerDetails.setAdapter(careerDetailsAdapter);
                    }
                });

            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });

    }

    @Override
    public void userSelected(User user) {
        Fragment careerDetailsFragmnt = new CareerDetailsFragmnt(user);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.career_details, careerDetailsFragmnt).commit();
    }
}