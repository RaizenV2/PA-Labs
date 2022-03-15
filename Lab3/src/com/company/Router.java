package com.company;

public class Router extends Node implements Identifiable{
    private String addres;

    public Router(String name, String addres) {
        super(name);
        this.addres = addres;
    }


    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    @Override
    public String getAddress() {
        return this.addres;
    }

}
