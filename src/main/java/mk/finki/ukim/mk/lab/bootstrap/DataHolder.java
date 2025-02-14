package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {


    public static List<Event> events = null;

    public static List<EventBooking> eventBookings = new ArrayList<>();

    public static List<Location> locations = null;

    @PostConstruct
    public void init() {
        events = new ArrayList<>();

        events.add(new Event("Tech Conference", "Conference for tech enthusiasts", 4.9, new Location("Conference Center", "123 Main St", "Tech City", "Country")));
        events.add(new Event("Art Expo", "Exhibition of modern art", 4.5, new Location("Art Gallery", "456 Art Ave", "Art City", "Country")));
        events.add(new Event("Music Festival", "Outdoor music festival", 4.8, new Location("Festival Grounds", "789 Music Blvd", "Music City", "Country")));
        events.add(new Event("Science Fair", "Fair showcasing science projects", 4.3, new Location("Science Hall", "101 Science Dr", "Innovation City", "Country")));
        events.add(new Event("Food Carnival", "Carnival with various food stalls", 4.6, new Location("Carnival Park", "202 Flavor Rd", "Gourmet City", "Country")));
        events.add(new Event("Film Screening", "Premiere screening of indie films", 4.4, new Location("Cinema Hall", "303 Film Ln", "Cinema City", "Country")));
        events.add(new Event("Literature Fest", "Festival for book lovers", 4.7, new Location("Library Hall", "404 Book St", "Literature City", "Country")));
        events.add(new Event("Sports Meet", "Annual sports meet", 4.2, new Location("Sports Complex", "505 Athlete Ave", "Sports City", "Country")));
        events.add(new Event("Startup Pitch", "Pitching event for startups", 4.9, new Location("Business Center", "606 Startup Blvd", "Entrepreneur City", "Country")));
        events.add(new Event("Fashion Show", "Showcasing latest fashion trends", 4.6, new Location("Fashion Arena", "707 Style Rd", "Fashion City", "Country")));



        locations = new ArrayList<>();
        locations.add(new Location("Green Park", "123 Maple St, Springfield", "500", "A spacious park with beautiful greenery and a pond"));
        locations.add(new Location("Blue Horizon Conference Center", "456 Oak Ave, Springfield", "2000", "A modern conference center equipped with state-of-the-art facilities"));
        locations.add(new Location("Sunset Library", "789 Pine Rd, Springfield", "150", "A quiet library with an extensive collection of books and study areas"));
        locations.add(new Location("The Grand Theater", "101 River Blvd, Springfield", "1200", "An old-fashioned theater with beautiful architecture and excellent acoustics"));
        locations.add(new Location("Willow Community Center", "202 Willow Dr, Springfield", "300", "A community center offering various classes and meeting spaces for events"));

    }
}
