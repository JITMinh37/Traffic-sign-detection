package com.example.navigationbottom.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import com.example.navigationbottom.R;
import com.example.navigationbottom.activity.LoginActivity;

public class SettingFragment extends Fragment {

    private View mView;
    private TextView textViewTenNguoiDung;
    private AppCompatButton appCompatButtonLogout;
    public SettingFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_setting, container, false);

        initUI();

        return mView;
    }

    private void initUI() {
        appCompatButtonLogout = mView.findViewById(R.id.btn_logout);

        appCompatButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        });
    }
}
