package mk.finki.ukim.mk.lab.web.controller;


import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

   private final EventService eventService;
   private final LocationService locationService;

   private final EventBookingService eventBookingService;



    public EventController(EventService eventService, LocationService locationService, EventBookingService eventBookingService) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.eventBookingService = eventBookingService;
        System.out.println("hello");
    }

    @GetMapping
    public String getEventPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Event> events = this.eventService.listAll();
        model.addAttribute("events", events);
        return "listEvents";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        this.eventService.deleteById(id);
        return "redirect:/events";
    }

    @GetMapping("/edit-form/{id}")
    public String editEventPage(@PathVariable Long id, Model model) {
        if (this.eventService.findById(id).isPresent()) {
            Event event = this.eventService.findById(id).get();
            List<Location> locations = this.locationService.listAll();
            model.addAttribute("locations", locations);
            model.addAttribute("event", event);
            return "add-event";
        }
        return "redirect:/events?error=EventNotFound";
    }

    // Updated POST mapping for saving events

    @PostMapping("/add")
    public String saveEvent(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double popularityScore,
            @RequestParam Long location
    ) {
        if (id != null) {
            this.eventService.update(id, name, description, popularityScore, location);
        } else {
            this.eventService.save(name, description, popularityScore, location);
        }
        return "redirect:/events";
    }
    @GetMapping("/by-location")
    public String getEventsByLocation(@RequestParam Long locationId, Model model) {
        List<Event> events = eventService.findAllByLocationId(locationId);
        model.addAttribute("events", events);
        model.addAttribute("locations", locationService.listAll());
        return "listEvents";
    }




    @GetMapping("/add-form")
    public String addEventPage(Model model) {

        List<Location> locations = this.locationService.listAll();
        model.addAttribute("locations", locations);
        return "add-event";
    }

    @GetMapping("/bookingDetails/{id}")
    public String details(@PathVariable Long id, Model model) {
        if (this.eventService.findById(id).isPresent()){
            Event event = eventService.findById(id).get();
            List<EventBooking> bookings = eventBookingService.findByName(event.getName());
            model.addAttribute("event",event);
            model.addAttribute("bookings",bookings);
            return "event-details";
        }
        return "redirect:/events?error=EventNotFound";
    }






}
