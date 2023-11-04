package com.example.navigationbottom.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationbottom.R;
import com.example.navigationbottom.adaper.BienBaoAdapter;
import com.example.navigationbottom.model.BienBao;
import com.example.navigationbottom.viewmodel.BienBaoApiService;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ListBienBaoInHomeFragment extends Fragment{
    private BienBaoApiService bienBaoApiService;
    private RecyclerView rvBienBao;
    private ArrayList<BienBao> bienBaos;
    private BienBaoAdapter bienBaoAdapter;

    private ShimmerFrameLayout shimmerFrameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list_bien_bao_in_home, container, false);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvBienBao = view.findViewById(R.id.rv_bienbaolistfraghome);
        bienBaos = new ArrayList<>();
        bienBaoAdapter = new BienBaoAdapter(bienBaos);
        rvBienBao.setAdapter(bienBaoAdapter);
        rvBienBao.setLayoutManager(new GridLayoutManager(getContext(), 2));

        //
        shimmerFrameLayout = view.findViewById(R.id.shimmer_listBienBao);
        shimmerFrameLayout.startShimmer();
        //

        bienBaoApiService = new BienBaoApiService();
        bienBaoApiService.getBienBaoInApiSv()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<BienBao>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<BienBao> bienBaos1) {
                        Log.d("debug", "thanh cong");
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        rvBienBao.setVisibility(View.VISIBLE);
                        for (BienBao bienBao : bienBaos1) {
                            bienBaos.add(bienBao);
                            bienBaoAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        Log.d("debug", "that bai");
                    }
                });

    }


}