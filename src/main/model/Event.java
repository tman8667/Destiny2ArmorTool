package model;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

// Represents an armor tool event
// Code adapted from AlarmSystem project
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;

    // EFFECTS: Creates an event with given description and current date/time stamp
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }

    public Date getDate() {
        return dateLogged;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }

        Event event = (Event) other;

        return Objects.equals(this.dateLogged, event.dateLogged)
                && Objects.equals(this.description, event.description);
    }

    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}
