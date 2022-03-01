package com.company;

import java.util.ArrayList;
import java.util.List;

public class Assigment {

    private List<Event> events;
    private  Room room;

    public Assigment(List<Event> events, Room room) {
        this.events =  new ArrayList<Event>();
        this.room = room;
    }

    public void setEvents(Event e1, Event e2 , Event e3 , Event e4) {
        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Event> getEvents() {
        List<Event> eventsRet = new ArrayList<Event>();
        for(Event ev: events)
        {
            eventsRet.add(ev);
        }
        return eventsRet;
    }

    @Override
    public String toString() {
        return "Assigment{" +
                "events=" + events +
                ", room=" + room +
                '}';
    }
}
