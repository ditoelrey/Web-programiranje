package mk.finki.ukim.mk.lab.service.impl;


import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.exceptions.LocationNotFoundException;

import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventImpl implements EventService {


    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEvents(text);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Optional<Event> findByName(String name) {
        return eventRepository.findEventByName(name);
    }

    @Override
    public void deleteById(Long id) {
         eventRepository.deleteById(id);
    }


    @Override
    public Optional<Event> save(String name, String description, double popularityScore,Long locationId) {
        Location location = this.locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));
        return Optional.of(this.eventRepository.save(new Event(name, description, popularityScore, location)));
    }

    @Override
    public List<Event> findAllByLocationId(Long locationId) {
        return eventRepository.findAllByLocation_id(locationId);
    }

    @Override
    public Optional<Event> update(Long id, String name, String description, double popularityScore, Long locationId) {
        Event event = eventRepository.findById(id).orElse(null);
        Location location = locationRepository.findById(locationId).orElse(null);

        if (event != null) {
            event.setName(name);
            event.setDescription(description);
            event.setPopularityScore(popularityScore);
            event.setLocation(location);

            return Optional.of(this.eventRepository.save(event));
        }

        return Optional.empty();

    }
}
