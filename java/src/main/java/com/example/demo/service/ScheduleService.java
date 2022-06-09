package service;

import model.Event;
import model.Reservation;
import model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EventRepository;
import repository.ReservationRepository;
import repository.ResourceRepository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> generateSchedule (List<String> eventIds) {
        List<Reservation> schedule = new LinkedList<>();
        List<Event> events = eventIds
            .stream()
            .map((id) -> eventRepository.findById(id)
                .orElse(null))
            .collect(Collectors.toList());

        List<Reservation> currentReservations = reservationRepository.findAll();
        List<Resource> usedResources = events.stream()
                .map(Event::getRequiredResourcesId)
                .reduce(new LinkedList<>(),(acc, resourceIds) -> {
                    List<String> newResources = new LinkedList<>();
                    newResources.addAll(acc);
                    newResources.addAll(resourceIds);
                    return newResources;
                })
            .stream()
            .map((resourceId) -> resourceRepository.findById(resourceId).orElse(null))
            .collect(Collectors.toList());

        events.sort((left, right)->left.getLengthInHours()-right.getLengthInHours());

        events.forEach((event)->{
          if(event == null) return;
          schedule.add(this.getFirstAvailableReservation(event, usedResources, currentReservations, schedule));
        });
        return schedule;
    }
  Reservation getFirstAvailableReservation(Event event, List<Resource> resources, List<Reservation> reservations, List<Reservation> currentSchedule){
      Reservation reservation = new Reservation();
      reservation.setDayNumber(0);
      reservation.setStartHour(0);
      reservation.setEndHour(event.getLengthInHours());
      reservation.setResourcesId(event.getRequiredResourcesId());

      List<Resource> requiredResources = resources.stream().filter((resource)->{
        return reservation.getResourcesId().contains(resource.getId());
      }).collect(Collectors.toList());

      List<Reservation> allReservations = List.copyOf(reservations);
      allReservations.addAll(currentSchedule);

      while(true){
        if(isScheduleConflict(allReservations, reservation)){
          reservation.setStartHour(reservation.getStartHour()+1);
          reservation.setEndHour(reservation.getEndHour()+1);
          if(reservation.getEndHour()>23){
            reservation.setEndHour(reservation.getEndHour()%24);
          }
          if(reservation.getStartHour()>23){
            reservation.setStartHour(reservation.getStartHour()%24);
            reservation.setDayNumber(reservation.getDayNumber()+1);
          }
        }
        else {
          return reservation;
        }
      }
  }
  Boolean isScheduleConflict(List<Reservation> schedule, Reservation newReservation) {
    for (Reservation reservation : schedule) {
      for (String resourceId1 : reservation.getResourcesId()) {
        for (String resourceId2 : newReservation.getResourcesId()) {
          if (resourceId1.equals(resourceId2)) {
            int startHourCurrent = reservation.getStartHour() + 24 * reservation.getDayNumber();
            int endHourCurrent = reservation.getEndHour() + 24 * reservation.getDayNumber();
            if (endHourCurrent < startHourCurrent) {
              endHourCurrent += 24;
            }
            int startHourNew = newReservation.getStartHour() + 24 * newReservation.getDayNumber();
            int endHourNew = newReservation.getEndHour() + 24 * newReservation.getDayNumber();
            if (endHourNew < startHourNew) {
              endHourNew += 24;
            }

            if (startHourCurrent < startHourNew && startHourNew < endHourCurrent) {
              return true;
            }
            if (startHourCurrent < endHourNew && endHourNew < endHourCurrent) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}
