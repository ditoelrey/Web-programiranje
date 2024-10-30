package mk.finki.ukim.mk.lab.model.exceptions;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(String message) {
        super(String.format("Event not found %s",message));
    }
}
