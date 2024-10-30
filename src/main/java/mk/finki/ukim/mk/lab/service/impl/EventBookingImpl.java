package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.exceptions.EventNotFoundException;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventBookingImpl implements EventBookingService {

    private final EventRepository eventRepository;

    public EventBookingImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {

        List<Event> events = eventRepository.searchEvents(eventName);
        if (events.isEmpty()) {
            throw new EventNotFoundException(eventName);
        }

        EventBooking booking = new EventBooking(eventName, attendeeName, attendeeAddress, (long) numberOfTickets);


        return booking;
    }


}
