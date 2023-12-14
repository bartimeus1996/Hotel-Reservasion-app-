package com.example.reservasyonjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reservasyonjava.ApiServices.HotelApiService;
import com.example.reservasyonjava.ApiServices.LocationApiService;
import com.example.reservasyonjava.DataModels.CityLocationResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    private EditText cityEditText;
    private Button searchButton;
    private LocationApiService locationApi;
    private HotelApiService hotelApi;
    List<CityLocationResponse> listResponse = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        cityEditText = findViewById(R.id.edSehir);
        searchButton = findViewById(R.id.searchBtn);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://booking-com.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LocationApiService locationApiService = retrofit.create(LocationApiService.class);
        HotelApiService hotelApiService = retrofit.create(HotelApiService.class);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String sehirAdi= cityEditText.getText().toString();

                Call<List<CityLocationResponse>> locationCall = locationApiService.getCityLocation(sehirAdi,"en-gb");
                locationCall.enqueue(new Callback<List<CityLocationResponse>>() {
                    @Override
                    public void onResponse(Call<List<CityLocationResponse>> call, Response<List<CityLocationResponse>> response) {


                        List<CityLocationResponse> locationResponse = response.body();
                        if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                            String destinationId = response.body().get(0).getDest_id();
                            Intent intent =new Intent(SearchActivity.this,HotelListActivity.class);
                            intent.putExtra("dest_id", destinationId);
                            startActivity(intent);
                            Log.i("dest id", locationResponse.get(0).getDest_id());
                        }
                    }
                    @Override
                    public void onFailure(Call<List<CityLocationResponse>> call, Throwable t) {
                        Toast.makeText(SearchActivity.this, "Error fail", Toast.LENGTH_SHORT).show();
                    };
                });
            }
        });
    }
}
