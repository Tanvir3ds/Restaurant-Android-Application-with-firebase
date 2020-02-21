package com.example.rest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<ModelClass> modelClassList;

    public MyAdapter(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view= layoutInflater.inflate(R.layout.burger_item_layout,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClass modelClass = modelClassList.get(position);
        holder.FoodName.setText("Name: "+modelClass.getFoodName());
        holder.FoodPrice.setText("Price: "+modelClass.getFoodPrice());
        holder.FoodDescription.setText("Details: "+modelClass.getFoodDescription());

        Picasso.with(context)
                .load(modelClass.getImageUrl())
                .placeholder(R.mipmap.ic_launcher_round)
                .fit()
                .centerCrop()
                .into(holder.FoodImage);

    }

    @Override
    public int getItemCount() {

        return modelClassList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView FoodName, FoodPrice, FoodDescription;
        ImageView FoodImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            FoodName=itemView.findViewById(R.id.CardViewFoodName_ID);
            FoodPrice=itemView.findViewById(R.id.CardViewFoodPrice_ID);
            FoodDescription=itemView.findViewById(R.id.CardViewFoodDescription_ID);
            FoodImage=itemView.findViewById(R.id.CardImageView_ID);
        }
    }
}
