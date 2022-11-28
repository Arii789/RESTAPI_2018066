package com.example.restapi_2018066;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://komapi.co/api/v2/";
    @GET("komputer?limit=10")
    Call<komputer> getKomputer();
}