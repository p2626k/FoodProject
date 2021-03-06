package com.example.catherine.foodproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ASUS on 2018/9/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<Member> memberList;

    RecyclerViewAdapter(Context context, List<Member> memberList) {
        this.context = context;
        this.memberList = memberList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_liked, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder viewHolder, int position) {
        viewHolder.tvName.setText(memberList.get(position).getName());
        Glide.with(context)
                .load(memberList.get(position).getImage())
                .into(viewHolder.ivImage);
        viewHolder.tvCuisine.setText(memberList.get(position).getCuisineType());
        viewHolder.rbPriceEvaluation.setRating(memberList.get(position).getPriceEvaluation());
        viewHolder.tvDistance.setText(String.valueOf(memberList.get(position).getDistance()));

    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivImage;
        TextView tvCuisine;
        RatingBar rbPriceEvaluation;
        TextView tvDistance;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvCuisine = itemView.findViewById(R.id.tvCuisine);
            rbPriceEvaluation = itemView.findViewById(R.id.rbPriceEvaluation);
            tvDistance = itemView.findViewById(R.id.tvDistance);
        }
    }


}
