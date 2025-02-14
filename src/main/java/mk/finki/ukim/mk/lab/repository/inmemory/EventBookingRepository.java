//package mk.finki.ukim.mk.lab.repository.inmemory;
//
//import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.model.EventBooking;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//
//@Repository
//public class EventBookingRepository {
//
//
//    public List<EventBooking> searchBookings (String name) {
//        return DataHolder.eventBookings.stream()
//                .filter(eventBooking -> eventBooking.getAttendeeName() != null && eventBooking.getAttendeeName().contains(name))
//                .collect(Collectors.toList());
//
//    }
//
//    public void createBooking(EventBooking eventBooking){
//
//        DataHolder.eventBookings.add(eventBooking);
//    }
//
//    public List<EventBooking> findByName(String name) {
//        return DataHolder.eventBookings.stream().filter(i -> i.getEventName().equals(name)).collect(Collectors.toList());
//    }
//
//
//
//
//}
