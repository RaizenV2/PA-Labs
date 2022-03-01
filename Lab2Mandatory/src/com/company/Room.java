package com.company;

public  class Room {
        private String name;
        private RoomType type;
        private Integer capacity;
//standard base class constructor
    public Room(String name, RoomType type, Integer capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }
//Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
//Getters
    public String getName() {
        return name;
    }

    public RoomType getType() {
        return type;
    }

    public Integer getCapacity() {
        return capacity;
    }
//Create to string method to print out
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                '}';
    }
}
