package com.example.MedicApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TrueMainActivity extends AppCompatActivity {

    public int sum_basket = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_main);

        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        getNewsData().thenAccept(dataList -> {
            if (dataList != null) {
                NewsData[] newsDataArray = dataList.toArray(new NewsData[0]);
                NewsAdapter newsAdapter = new NewsAdapter(newsDataArray, TrueMainActivity.this);
                recyclerView2.setAdapter(newsAdapter);
            } else {
                Log.d("FAQ", "dataList is null");
            }
        }).exceptionally(e -> {
            // Handle exception
            Log.e("FAQ", "Exception: " + e.getMessage());
            return null;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        getAnalisData().thenAccept(dataList -> {
            if (dataList != null) {
                AnalisData[] analisDataArray = dataList.toArray(new AnalisData[0]);
                AnalisAdapter analisAdapter = new AnalisAdapter(analisDataArray, TrueMainActivity.this);
                recyclerView.setAdapter(analisAdapter);
            } else {
                Log.d("FAQ", "dataList is null");
            }
        }).exceptionally(e -> {
            // Handle exception
            Log.e("FAQ", "Exception: " + e.getMessage());
            return null;
        });
    }

    private CompletableFuture<List<AnalisData>> getAnalisData() {
        CompletableFuture<List<AnalisData>> future = new CompletableFuture<>();

        Retrofit retrofit = ApiClient.getClient();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<AnalisJSON>> call = apiService.getData();
        call.enqueue(new Callback<List<AnalisJSON>>() {
            @Override
            public void onResponse(Call<List<AnalisJSON>> call, Response<List<AnalisJSON>> response) {
                if (response.isSuccessful()) {
                    List<AnalisJSON> dataList = response.body();
                    if (dataList != null) {
                        List<AnalisData> analisDataList = new ArrayList<>();
                        for (AnalisJSON data : dataList) {
                            AnalisData analisData = new AnalisData(data.getName(), data.getTime(), data.getPrice() + " ₽");

                            analisDataList.add(analisData);
                        }

                        future.complete(analisDataList);
                    }
                } else {
                    future.completeExceptionally(new RuntimeException("Ошибка выполнения запроса"));
                }
            }

            @Override
            public void onFailure(Call<List<AnalisJSON>> call, Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
    }

    private CompletableFuture<List<NewsData>> getNewsData() {
        CompletableFuture<List<NewsData>> future = new CompletableFuture<>();

        Retrofit retrofit = ApiClient.getClient();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<NewsJSON>> call = apiService.getDataNews();
        call.enqueue(new Callback<List<NewsJSON>>() {
            @Override
            public void onResponse(Call<List<NewsJSON>> call, Response<List<NewsJSON>> response) {
                if (response.isSuccessful()) {
                    List<NewsJSON> dataList = response.body();
                    if (dataList != null) {
                        List<NewsData> newsDataList = new ArrayList<>();
                        for (NewsJSON data : dataList) {
                            NewsData newsData = new NewsData(data.getName(), data.getDescription(), data.getPrice() + " ₽", data.getImage());
                            Log.d("FAQ", data.getName() + " - " + data.getDescription() + " - " + data.getPrice() + " ₽" + " - " + data.getImage());
                            newsDataList.add(newsData);
                        }
                        future.complete(newsDataList);
                    }
                } else {
                    future.completeExceptionally(new RuntimeException("Ошибка выполнения запроса"));
                }
            }

            @Override
            public void onFailure(Call<List<NewsJSON>> call, Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
    }
    public void changeSum(int price) {
        sum_basket = sum_basket + price;
        TextView TextPrice = findViewById(R.id.price);
        String pricyy = String.valueOf(sum_basket) + " ₽";
        TextPrice.setText(pricyy);
        if (sum_basket == 0) {
            LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);
            linearLayout2.setVisibility(View.GONE);
        }
    }

}

