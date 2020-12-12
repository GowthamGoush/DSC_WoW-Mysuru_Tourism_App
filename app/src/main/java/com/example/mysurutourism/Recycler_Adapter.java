package com.example.mysurutourism;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.Frag_ViewHolder> {

    ArrayList<ItemDetails> FragList;
    Context mContext;
    Activity mActivity;

    public class Frag_ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public CardView cardView;
        public ImageView imageView;

        public Frag_ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.resultName);
            cardView = itemView.findViewById(R.id.itemsCard);
            imageView = itemView.findViewById(R.id.resultImage2);
/*
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ItemDetails itemDetails = FragList.get(getAdapterPosition());

                    Intent intent = new Intent(mActivity,MainActivity2.class);
                    intent.putExtra("name",itemDetails.getItemName());
                    intent.putExtra("image",itemDetails.getItemImage());
                    intent.putExtra("url",itemDetails.getItemUrl());
                    mActivity.startActivity(intent);

                }
            });

 */

        }
    }

    public Recycler_Adapter(ArrayList<ItemDetails> List , Context context , Activity activity) {
        FragList = List;
        mContext = context;
        mActivity = activity;
    }

    @NonNull
    @Override
    public Frag_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spots_layout, parent, false);
        Frag_ViewHolder fvh = new Frag_ViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull Frag_ViewHolder holder, int position) {

        ItemDetails Item = FragList.get(position);

        holder.textView.setText(Item.getItemName());

        Glide.with(mContext).load(Item.getItemImage())
                .circleCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return FragList.size();
    }
}