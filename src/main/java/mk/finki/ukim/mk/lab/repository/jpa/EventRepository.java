package mk.finki.ukim.mk.lab.repository.jpa;


import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.name LIKE %:keyword%")
    List<Event> searchEvents(@Param("keyword") String keyword);

    List<Event> findAllByLocation_id(Long location_id);

    Optional<Event> findEventByName(String name);




}
