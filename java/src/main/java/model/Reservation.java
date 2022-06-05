package model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Reservation")
public class Reservation {
    @Id
    private String id;
    private String eventId;
    private List<String> resourcesId;

    // The day/hours for the reservation
    private Integer dayNumber;
    private Integer startHour;
    private Integer endHour;
}
