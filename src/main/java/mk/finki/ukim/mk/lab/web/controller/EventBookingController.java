package mk.finki.ukim.mk.lab.web.controller;


import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.util.List;

@Controller
public class EventBookingController {

    private final EventBookingService eventBookingService;
    private final UserService userService;

    public EventBookingController(EventBookingService eventBookingService, UserService userService) {
        this.eventBookingService = eventBookingService;
        this.userService = userService;
    }

    @PostMapping("/events/eventBooking")
    public String bookEvent(
            @RequestParam Long selectedEvent,
            @RequestParam int numTickets, Principal principal,
            Model model, HttpServletRequest request) {

        String attendeeName = principal.getName();
        String attendAddress = request.getRemoteAddr();
        EventBooking booking = eventBookingService.placeBooking(selectedEvent, attendeeName, attendAddress,numTickets);


        model.addAttribute("bookings", booking);
        return "bookingConfirmation";
    }

}
