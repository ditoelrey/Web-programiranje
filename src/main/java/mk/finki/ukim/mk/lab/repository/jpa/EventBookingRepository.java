package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking, Long> {

    List<EventBooking> findByEventName(String eventName);

    List<EventBooking> findByUser_Username(String username);

    List<EventBooking> findByAttendeeName(String attendeeName);
}