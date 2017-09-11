package com.example.ahmed.taskty_task;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<ServiceModel> moviesList;
    public static List<Integer> positionSelected;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView servicename,pricefrom,priceto;
        public RadioButton radio;

        public MyViewHolder(View itemView) {
            super(itemView);
            servicename=(TextView)itemView.findViewById(R.id.txt_servicename);
            pricefrom=(TextView)itemView.findViewById(R.id.pricefrom);
            priceto=(TextView)itemView.findViewById(R.id.priceto);
            radio=(RadioButton)itemView.findViewById(R.id.radio);

        }
    }


    public RecyclerAdapter(List<ServiceModel> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_services, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ServiceModel movie = moviesList.get(position);
        holder.servicename.setText(movie.getServicename());
        holder.pricefrom.setText(movie.getPricefrom());
        holder.priceto.setText(movie.getPriceto());
        positionSelected = new ArrayList<>();
        holder.radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                positionSelected.add(position);
            }
        });
        for (int i=0;i<positionSelected.size();i++){
            System.out.println(positionSelected.get(i)+"okok");
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}