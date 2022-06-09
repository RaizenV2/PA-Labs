package controller;

import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.EventRepository;

import java.util.List;

@RestController
public class EventController {

  @Autowired
  EventRepository eventRepository;

  @GetMapping("/event")
  List<Event> getAllEvents(){
    return eventRepository.findAll();
  }

  @PostMapping("/event")
  Event postEvent(@RequestBody Event event){
    return eventRepository.insert(event);
  }
}
