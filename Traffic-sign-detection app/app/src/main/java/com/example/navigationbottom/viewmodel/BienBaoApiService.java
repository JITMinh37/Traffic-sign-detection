package com.example.navigationbottom.viewmodel;

import com.example.navigationbottom.model.BienBao;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BienBaoApiService {
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private BienBaoApi api;

    public BienBaoApiService(){
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // cover  laij
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // ep luongg vao
                .build()
                .create(BienBaoApi.class);
    }

    public Single<List<BienBao>> getBienBaoInApiSv(){
        return api.getBienBao();
    }
}
