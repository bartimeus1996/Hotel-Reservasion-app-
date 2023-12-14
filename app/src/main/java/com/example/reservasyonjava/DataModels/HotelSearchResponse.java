package com.example.reservasyonjava.DataModels;

import java.util.List;

public class HotelSearchResponse {
    private int count;
    private List<HotelDetails> results;

    public HotelSearchResponse(int count, List<HotelDetails> results) {
        this.count = count;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<HotelDetails> getResults() {
        return results;
    }

    public void setResults(List<HotelDetails> results) {
        this.results = results;
    }
}
