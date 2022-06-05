package controller;

import model.Reservation;
import model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.ReservationRepository;
import repository.ResourceRepository;

import javax.el.ResourceBundleELResolver;
import java.util.List;

@RestController
public class ResourceController {
  @Autowired
  ResourceRepository resourceRepository;

  @GetMapping("/resource")
  List<Resource> getAllResources(){
    return resourceRepository.findAll();
  }

  @PostMapping("/resource")
  Resource postResource(@RequestBody Resource resource){
    return resourceRepository.insert(resource);
  }
}
