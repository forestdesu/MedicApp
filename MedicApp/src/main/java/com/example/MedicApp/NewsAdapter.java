package com.example.MedicApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    NewsData[] NewsData;
    Context context;

    public NewsAdapter(NewsData[] NewsData, TrueMainActivity activity) {
        this.NewsData = NewsData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.news_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NewsData newsDataList = NewsData[position];
        holder.NewsTitle.setText(newsDataList.getNewsTitle());
        holder.NewsDesc.setText(newsDataList.getNewsDesc());
        holder.NewsPrice.setText(newsDataList.getNewsPrice());

        String imageUrl = newsDataList.getNewsURLImg();
        Picasso.get().load(imageUrl).into(holder.NewsImg);
    }

    @Override
    public int getItemCount() {
        return NewsData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView NewsTitle;
        TextView NewsDesc;
        TextView NewsPrice;
        ImageView NewsImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            NewsTitle = itemView.findViewById(R.id.news_title);
            NewsDesc = itemView.findViewById(R.id.news_desc);
            NewsPrice = itemView.findViewById(R.id.news_price);
            NewsImg = itemView.findViewById(R.id.news_img);
        }

    }

}
