package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {


    List<Event> listAll();
    public List<Event> searchEvents(String text);
    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);
    void deleteById(Long id);

    Optional<Event> save (String name, String description, double popularityScore, Long location);

    Optional<Event> update(Long id, String name, String description, double popularityScore, Long locationId);

    List<Event> findAllByLocationId(Long locationId);



}
