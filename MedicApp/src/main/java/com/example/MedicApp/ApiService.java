package com.example.MedicApp;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v3/532c2674-f536-4b93-bd65-0a51d4de174d")
    Call<List<AnalisJSON>> getData();

    @GET("v3/0090ce04-e1b9-487c-9f1e-9b35b3b26e99")
    Call<List<NewsJSON>> getDataNews();
}
