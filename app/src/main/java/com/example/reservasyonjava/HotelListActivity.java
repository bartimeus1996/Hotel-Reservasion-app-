package com.example.reservasyonjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.reservasyonjava.Adapter.HotelAdapter;
import com.example.reservasyonjava.ApiServices.HotelApiService;
import com.example.reservasyonjava.DataModels.HotelDetails;
import com.example.reservasyonjava.DataModels.HotelSearchResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    HotelAdapter adapter;
    private ArrayList<HotelDetails> hotelDetailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);
        hotelDetailsList = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HotelAdapter(this, hotelDetailsList);
        recyclerView.setAdapter(adapter);


        hotelDetailsList.clear();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://booking-com.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        int destinationId = Integer.parseInt(getIntent().getStringExtra("dest_id"));

        HotelApiService hotelApiService = retrofit.create(HotelApiService.class);
        if (destinationId != -1) {
            Call<HotelSearchResponse> apiResults = hotelApiService.gethotelSearch(
                    "popularity",
                    2,
                    "2023-12-12",
                    "AED",
                    destinationId,
                    "en-gb",
                    "2023-12-29",
                    "metric",
                    1,
                    "city"
            );

            apiResults.enqueue(new Callback<HotelSearchResponse>() {
                @Override
                public void onResponse(Call<HotelSearchResponse> call, Response<HotelSearchResponse> response) {
                    if (response.isSuccessful()) {
                        HotelSearchResponse hotelSearchResponse = response.body();
                        Log.d("response count", String.valueOf(hotelSearchResponse.getCount()));
                        List<HotelDetails> hotelDetailsArrayList = hotelSearchResponse.getResults();
                        for (int i = 0; i < hotelDetailsArrayList.size(); i++) {

                            hotelDetailsList.add(new HotelDetails(
                                    hotelDetailsArrayList.get(i).getName(),
                                    hotelDetailsArrayList.get(i).getReviewScoreWord(),
                                    hotelDetailsArrayList.get(i).getResimUrl()
                            ));
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(HotelListActivity.this, "error", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<HotelSearchResponse> call, Throwable t) {
                    Toast.makeText(HotelListActivity.this, "api error", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }

}