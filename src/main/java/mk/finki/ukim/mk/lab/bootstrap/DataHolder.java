package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {


    public static List<Event> events = null;


    @PostConstruct
    public void init() {
        events = new ArrayList<>();
        events.add(new Event("Music Festival", "Annual music festival", 4.5));
        events.add(new Event("Art Exhibition", "Showcasing modern art", 3.8));
        events.add(new Event("Tech Conference", "Conference for tech enthusiasts", 4.9));
        events.add(new Event("Food Carnival", "Taste delicious street food", 4.2));
        events.add(new Event("Literature Fair", "Explore world of books", 3.5));
        events.add(new Event("Science Expo", "Exhibit scientific innovations", 4.1));
        events.add(new Event("Film Screening", "Premiere of indie films", 3.9));
        events.add(new Event("Comedy Show", "Stand-up comedy night", 4.3));
        events.add(new Event("Charity Run", "Fundraiser for a good cause", 4.0));
        events.add(new Event("Yoga Retreat", "Relax and rejuvenate", 3.7));
    }
}
