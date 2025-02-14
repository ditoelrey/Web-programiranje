package mk.finki.ukim.mk.lab.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Location {

    @Id
    private Long id;
    private String name;
    private String address;
    private String capacity;
    private String description;
    @OneToMany(mappedBy = "location")
    List<Event> eventList;


    public Location(String name, String address, String capacity, String description) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
    }

    public Location(String name, String address, String capacity, String description, List<Event> eventList) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
        this.eventList = eventList;
    }

    public Location() {

    }
}
