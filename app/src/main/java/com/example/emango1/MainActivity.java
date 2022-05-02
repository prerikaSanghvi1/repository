package com.example.emango1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

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
    }
}