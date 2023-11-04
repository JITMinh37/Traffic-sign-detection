package com.example.navigationbottom.viewmodel;

import com.example.navigationbottom.model.BienBao;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface BienBaoApi {
    // https://raw.githubusercontent.com/HoVThao/json-server/eb8817039a71e76428bb6f07a1736227950f5f2b/bienbaovietnam
    @GET("HoVThao/json-server/eb8817039a71e76428bb6f07a1736227950f5f2b/bienbaovietnam")
    Single<List<BienBao>> getBienBao();
}
