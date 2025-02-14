//package mk.finki.ukim.mk.lab.web;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.EventBooking;
//import mk.finki.ukim.mk.lab.service.EventBookingService;
//import mk.finki.ukim.mk.lab.service.impl.EventBookingImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "EventBookingServlet", urlPatterns = "/events/eventBooking")
//public class EventBookingServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final EventBookingService eventBookingService;
//    public EventBookingServlet(SpringTemplateEngine springTemplateEngine, EventBookingService eventBookingService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.eventBookingService = eventBookingService;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String eventName = (String) req.getSession().getAttribute("selectedEvent");
////        String attendeeName = (String) req.getSession().getAttribute("attendeeName");
////        int numTickets = Integer.parseInt((String) req.getSession().getAttribute("numTickets"));
//
//        String eventName = req.getParameter("selectedEvent");
//        String attendeeName = (String) req.getSession().getAttribute("attendeeName");
//        int numTickets = Integer.parseInt(req.getParameter("numTickets"));
//
//
//        EventBooking booking = eventBookingService.placeBooking(eventName, attendeeName, req.getRemoteAddr(), numTickets);
//
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("bookings", booking);
//        context.setVariable("bookings",eventBookingService.searchBooking(attendeeName));
//
//        System.out.println("Reached EventBookingServlet doPost method");
//        System.out.println("selectedEvent: " + req.getParameter("selectedEvent"));
//        System.out.println("attendeeName: " + req.getSession().getAttribute("attendeeName"));
//        System.out.println("numTickets: " + req.getParameter("numTickets"));
//
//
//        springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());
//    }
//
//
//
//
//    }
//
