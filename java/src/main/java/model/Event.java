package model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Event")
public class Event {
    @Id
    private String id;
    
    private String name;
    private List<String> requiredResourcesId;
    private Integer lengthInHours;
}
