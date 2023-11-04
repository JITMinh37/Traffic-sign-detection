package com.example.navigationbottom.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.navigationbottom.R;
import com.example.navigationbottom.databinding.FragmentDetailsListHomeBinding;
import com.example.navigationbottom.model.BienBao;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.imageview.ShapeableImageView;

public class detailsListHomeFragment extends Fragment {
    private BienBao bienBao;
    private NavController navController;
    private ImageView ivAnhLon, ivBackDetails;
    private ShapeableImageView siAnhNho;
    private TextView tvMaBienBao, tvNoidungBienBao;
    private ShimmerFrameLayout shimmerFrameLayout;
    private NestedScrollView nestedScrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bienBao = (BienBao) getArguments().getSerializable("bienbao");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_details_list_home, container, false);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivAnhLon = view.findViewById(R.id.iv_anhLon);
        siAnhNho = view.findViewById(R.id.si_anhNho);
        tvMaBienBao = view.findViewById(R.id.tv_maBienBaoDetails);
        tvNoidungBienBao = view.findViewById(R.id.tv_noiDungBienBaoDetail);
        ivBackDetails = view.findViewById(R.id.iv_backDetails);
        shimmerFrameLayout = view.findViewById(R.id.shimmer_details);
        nestedScrollView = view.findViewById(R.id.scrollView_details_listHome);


        shimmerFrameLayout.startShimmer();


        tvMaBienBao.setText(bienBao.getMaBienBao());
        tvNoidungBienBao.setText(bienBao.getNoiDung());

        Glide.with(detailsListHomeFragment.this)
                .load(bienBao.getUrl())
                .into(ivAnhLon);
        Glide.with(detailsListHomeFragment.this)
                .load(bienBao.getUrl())
                .into(siAnhNho);

        Handler handler = new Handler();
        handler.postDelayed(()->{
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            nestedScrollView.setVisibility(View.VISIBLE);
        }, 1000);

        // Khởi tạo NavController từ NavHostFragment
        navController = NavHostFragment.findNavController(this);

        // Bắt sự kiện khi nhấn nút "quay lại"
        ivBackDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sử dụng NavController để quay lại Fragment danh sách
                navController.popBackStack();
            }
        });

    }

}