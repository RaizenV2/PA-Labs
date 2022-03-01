package com.company;

public class Event {
    private String name;
    private Integer participants;
    private Integer startTime;
    private Integer endTime;


    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
    //Getters

    public String getName() {
        return name;
    }

    public Integer getParticipants() {
        return participants;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    //Base Class Construcotr
    public Event(String name, Integer participants, Integer startTime, Integer endTime) {
        this.name = name;
        this.participants = participants;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Create to string method to print out
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", participants=" + participants +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
