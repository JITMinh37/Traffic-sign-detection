package com.example.navigationbottom.adaper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationbottom.R;
import com.example.navigationbottom.databinding.BienbaoItemBinding;
import com.example.navigationbottom.model.BienBao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BienBaoAdapter extends RecyclerView.Adapter<BienBaoAdapter.ViewHolder>{

    public static ArrayList<BienBao> bienBaos;
    public static ArrayList<BienBao> bienBaoscopy;

    public BienBaoAdapter(ArrayList<BienBao> bienBaos) {
        this.bienBaos = bienBaos;
        this.bienBaoscopy = bienBaos;
    }

    @NonNull
    @Override
    public BienBaoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BienbaoItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.bienbao_item,
                parent,
                false

        );

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setBienbao(bienBaos.get(position));
        Picasso.get().load(bienBaos.get(position).getUrl()).into(holder.binding.ivBienbao);
    }

    @Override
    public int getItemCount() {
        if(bienBaos != null){
            return bienBaos.size();
        }
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public BienbaoItemBinding binding;
        public ViewHolder(BienbaoItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
            itemBinding.ivBienbao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BienBao bienBao = bienBaos.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("bienbao", bienBao);
                    Navigation.findNavController(view).navigate(R.id.detailsListHomeFragment, bundle);
                }
            });

        }
    }
}
