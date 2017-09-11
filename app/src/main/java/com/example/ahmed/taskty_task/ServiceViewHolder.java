package com.example.ahmed.taskty_task;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ahmed on 9/11/2017.
 */

public class ServiceViewHolder extends RecyclerView.ViewHolder {
   private TextView servicename,pricefrom,priceto;

    public ServiceViewHolder(View itemView) {
        super(itemView);
        servicename=(TextView)itemView.findViewById(R.id.txt_servicename);
        pricefrom=(TextView)itemView.findViewById(R.id.pricefrom);
        priceto=(TextView)itemView.findViewById(R.id.priceto);
    }

    public TextView getServicename() {
        return servicename;
    }

    public void setServicename(TextView servicename) {
        this.servicename = servicename;
    }

    public TextView getPricefrom() {
        return pricefrom;
    }

    public void setPricefrom(TextView pricefrom) {
        this.pricefrom = pricefrom;
    }

    public TextView getPriceto() {
        return priceto;
    }

    public void setPriceto(TextView priceto) {
        this.priceto = priceto;
    }
}
