package com.example.ahmed.taskty_task;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterSelected extends RecyclerView.Adapter<RecyclerAdapterSelected.MyViewHolder> {

    private List<ServiceModel> moviesList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView servicename,pricefrom,priceto;


        public MyViewHolder(View itemView) {
            super(itemView);
            servicename=(TextView)itemView.findViewById(R.id.txt_servicename);
            pricefrom=(TextView)itemView.findViewById(R.id.pricefrom);
            priceto=(TextView)itemView.findViewById(R.id.priceto);

        }
    }


    public RecyclerAdapterSelected(Context context,List<ServiceModel> moviesList) {
        this.moviesList = moviesList;
        this.context=context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_servicesselected, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ServiceModel movie = moviesList.get(position);
        holder.servicename.setText(movie.getServicename());
        holder.pricefrom.setText(movie.getPricefrom());
        holder.priceto.setText(movie.getPriceto());

        Intent intent = ((Activity) context).getIntent();
        ArrayList<Integer> arr=intent.getIntegerArrayListExtra("selected");
        for (int x : arr){
            if (position==x){
                holder.servicename.setBackgroundColor(Color.WHITE);
                holder.pricefrom.setBackgroundColor(Color.WHITE);
                holder.priceto.setBackgroundColor(Color.WHITE);
            }
        }

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}