package com.example.reservasyonjava.DataModels;

public class CityLocationResponse {
    private String name;
    private String locale;
    private String dest_id;

    public CityLocationResponse(String name, String locale, String dest_id) {
        this.name = name;
        this.locale = locale;
        this.dest_id = dest_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDest_id() {
        return dest_id;
    }

    public void setDest_id(String dest_id) {
        this.dest_id = dest_id;
    }
}
