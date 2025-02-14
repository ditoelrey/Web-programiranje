//package mk.finki.ukim.mk.lab.repository.inmemory;
//
//
//import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.model.EventBooking;
//import mk.finki.ukim.mk.lab.model.Location;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class EventRepository {
//
//
//    public List<Event> findAll() {
//        return DataHolder.events;
//    }
//
//    public List<Event> searchEvents(String text) {
//        return DataHolder.events.stream()
//                .filter(event -> event.getName().toLowerCase().contains(text.toLowerCase()) ||
//                        event.getDescription().toLowerCase().contains(text.toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public Optional<Event> findById(Long id) {
//        return DataHolder.events.stream().filter(i -> i.getId().equals(id)).findFirst();
//    }
//
//    public Optional<Event> findByName(String name) {
//        return DataHolder.events.stream().filter(i -> i.getName().equals(name)).findFirst();
//    }
//    public void deleteById(Long id) {
//        DataHolder.events.removeIf(i -> i.getId().equals(id));
//    }
//
//    public Optional <Event> save(String name, String description, double popularityScore, Location location) {
//        if (location == null) {
//            throw new IllegalArgumentException();
//        }
//
//        Event event = new Event(name,description,popularityScore,location);
//        DataHolder.events.removeIf(p -> p.getName().equals(event.getName()));
//        DataHolder.events.add(event);
//        return Optional.of(event);
//    }
//
//
//
//
//
//
//
//}
//
//
//
//
//
//
