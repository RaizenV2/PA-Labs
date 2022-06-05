package controller;

import model.Event;
import model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.SchedulerBeanDefinitionParser;
import org.springframework.web.bind.annotation.*;
import repository.EventRepository;
import repository.ReservationRepository;
import service.ReservationService;
import service.ScheduleService;

import java.util.List;

@RestController
public class ReservationController {

  @Autowired
  ReservationRepository reservationRepository;

  @Autowired
  ScheduleService scheduleService;

  @GetMapping("/schedule")
  List<Reservation> getPossibleScheduling(@RequestParam List<String> eventIds){
    return scheduleService.generateSchedule(eventIds);
  }

  @GetMapping("/reservation")
  List<Reservation> getAllReservations(){
    return reservationRepository.findAll();
  }

  @PostMapping("/reservation")
  Reservation postReservation(@RequestBody Reservation reservation){
    return reservationRepository.insert(reservation);
  }
}
