package model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Resource")
public class Resource {
    @Id
    private String id;
    private String name;
    // The hour when this resource becomes available/unavailable each day
    private Integer availableFrom;
    private Integer availableUntil;
}
