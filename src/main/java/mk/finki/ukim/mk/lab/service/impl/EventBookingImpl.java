package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.repository.jpa.EventBookingRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookingImpl implements EventBookingService {

      private final EventBookingRepository eventBookingRepository;
      private final EventService eventService;


    public EventBookingImpl(EventBookingRepository eventBookingRepository, EventService eventService) {
        this.eventBookingRepository = eventBookingRepository;
        this.eventService = eventService;
    }


    @Override
    public EventBooking placeBooking(Long eventId, String attendeeName, String attendeeAddress, int numberOfTickets) {

        Event event = eventService.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));


        EventBooking booking = new EventBooking(event.getName(), attendeeName, attendeeAddress,(long) numberOfTickets);
        eventBookingRepository.save(booking);
        return booking;
    }

    @Override
    public List<EventBooking> searchBooking(String name) {
        return eventBookingRepository.findByEventName(name);
    }

    @Override
    public List<EventBooking> findByName(String name) {
        return eventBookingRepository.findByEventName(name);
    }




    @Override
    public List<EventBooking> getBookingsForCurrentUser(String username) {
        return eventBookingRepository.findByAttendeeName(username);
    }
}
