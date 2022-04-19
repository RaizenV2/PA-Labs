package com.company;

import java.io.Serializable;

public abstract class Item implements Serializable {
    Integer id;
    String title;
    String Location;

    protected Item(Integer id, String title, String location) {
        this.id = id;
        this.title = title;
        Location = location;
    }

}
