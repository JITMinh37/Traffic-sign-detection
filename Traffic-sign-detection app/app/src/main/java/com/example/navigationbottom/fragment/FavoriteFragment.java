package com.example.navigationbottom.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationbottom.R;
import com.example.navigationbottom.viewmodel.BienBaoApiService;

public class FavoriteFragment extends Fragment {
    private BienBaoApiService bienBaoApiService;

    private View mView;

    public FavoriteFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_favorite, container, false);


        return mView;
    }
}
