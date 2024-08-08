package com.example.app;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends RecyclerView.Adapter<CustomPagerAdapter.PagerViewHolder> {

    private final Context context;
    private final List<Integer> images;
    private OnItemClickListener itemClickListener;

    public CustomPagerAdapter(Context context) {
        this.context = context;
        this.images = new ArrayList<>();
    }

    // Add this method to add an image to the adapter
    public void addImage(int imageResId) {
        images.add(imageResId);
        notifyDataSetChanged();
    }

    public int getImageResId(int position) {
        return images.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pager_item, parent, false);
        return new PagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerViewHolder holder, int position) {
        int imageResId = images.get(position);
        holder.bind(imageResId);

        holder.itemView.setOnClickListener(view -> {
            if (itemClickListener != null) {
                itemClickListener.onClick(holder.imageView, imageResId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public interface OnItemClickListener {
        void onClick(ImageView imageView, int imageResId);
    }

    static class PagerViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        PagerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(int imageResId) {
            imageView.setImageResource(imageResId);
        }
    }
}
