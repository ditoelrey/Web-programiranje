package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;

import java.util.List;
import java.util.Optional;

public interface EventBookingService {

    EventBooking placeBooking(Long eventId, String attendeeName, String attendeeAddress, int numberOfTickets);

    List<EventBooking> searchBooking(String name);

    List<EventBooking> findByName(String name);

    public List<EventBooking> getBookingsForCurrentUser(String username);



}
