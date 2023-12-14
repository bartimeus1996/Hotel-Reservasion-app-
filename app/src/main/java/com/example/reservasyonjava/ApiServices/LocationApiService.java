package com.example.reservasyonjava.ApiServices;

import com.example.reservasyonjava.DataModels.CityLocationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface LocationApiService {
    @Headers({
            "X-RapidAPI-Key:9f36b2640amsh4da896e1a1b169ep1aa97djsn04eef59ee7fe",
            "X-RapidAPI-Host:booking-com.p.rapidapi.com"
    })
    @GET("v1/hotels/locations")
    Call<List<CityLocationResponse>> getCityLocation(

            @Query("name") String cityName,
            @Query("locale") String locale
    );

}
