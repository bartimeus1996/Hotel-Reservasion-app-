package com.example.reservasyonjava.DataModels;

import com.google.gson.annotations.SerializedName;

public class HotelDetails {
    @SerializedName("name")
    private String name;

    @SerializedName("reviewScoreWord")
    private String reviewScoreWord;

    @SerializedName("photoMainUrl")
    private String resimUrl;

    public HotelDetails(String name, String reviewScoreWord, String resimUrl) {
        this.name = name;
        this.reviewScoreWord = reviewScoreWord;
        this.resimUrl = resimUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviewScoreWord() {
        return reviewScoreWord;
    }

    public void setReviewScoreWord(String reviewScoreWord) {
        this.reviewScoreWord = reviewScoreWord;
    }

    public String getResimUrl() {
        return resimUrl;
    }

    public void setResimUrl(String resimUrl) {
        this.resimUrl = resimUrl;
    }
}
