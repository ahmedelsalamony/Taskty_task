package com.example.ahmed.taskty_task;

/**
 * Created by ahmed on 9/11/2017.
 */

public class ServiceModel {

    private String servicename,pricefrom,priceto;

    public ServiceModel(String servicename, String pricefrom, String priceto) {
        this.servicename = servicename;
        this.pricefrom = pricefrom;
        this.priceto = priceto;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getPricefrom() {
        return pricefrom;
    }

    public void setPricefrom(String pricefrom) {
        this.pricefrom = pricefrom;
    }

    public String getPriceto() {
        return priceto;
    }

    public void setPriceto(String priceto) {
        this.priceto = priceto;
    }
}
