package com.example.andymaster.Fragment.CumunitySection.Status.Adopter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.andymaster.Fragment.CumunitySection.Status.EditStatus_Activity;
import com.example.andymaster.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {


    private Context context;
    private List<String> imageUrls;
    private OnImageClickListener clickListener;

    public interface OnImageClickListener {
        void onImageClick(String imageUrl);
    }
    public GalleryAdapter(Context context, List<String> imageUrls, OnImageClickListener clickListener) {
        this.context = context;
        this.imageUrls = imageUrls;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String imageUrl = imageUrls.get(position);
        Glide.with(context).load(imageUrl).into(holder.image);

        holder.image.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onImageClick(imageUrl);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_item_gallery);
        }
    }
}
