package com.example.reservasyonjava.ApiServices;

import com.example.reservasyonjava.DataModels.HotelSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface HotelApiService {
    @Headers({
            "X-RapidAPI-Key:9f36b2640amsh4da896e1a1b169ep1aa97djsn04eef59ee7fe",
            "X-RapidAPI-Host:booking-com.p.rapidapi.com"
    })
    @GET("v2/hotels/search")
    Call<HotelSearchResponse> gethotelSearch(
            @Query("order_by") String order_by,
            @Query("adults_number") int adults_number,
            @Query("checkin_date") String checkin_date,
            @Query("filter_by_currency") String filter_by_currency,
            @Query("dest_id") int dest_id,
            @Query("locale") String locale,
            @Query("checkout_date") String checkout_date,
            @Query("units") String units,
            @Query("room_number") int room_number,
            @Query("dest_type") String dest_type

    );

}
