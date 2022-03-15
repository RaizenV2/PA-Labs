package com.company;

import java.util.Map;

public class Computer extends Node implements Identifiable,Storage{
    private String addres;
    private Integer storageCap;

    public Computer(String name, String addres, Integer storageCap) {
        super(name);
        this.addres = addres;
        this.storageCap = storageCap;
    }

    public Integer getStorageCap() {
        return storageCap;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setStorageCap(Integer storageCap) {
        this.storageCap = storageCap;
    }

    @Override
    public String getAddress() {
        return this.addres;
    }

    @Override
    public Integer getStorageCapacity() {
        return this.storageCap;
    }


}
