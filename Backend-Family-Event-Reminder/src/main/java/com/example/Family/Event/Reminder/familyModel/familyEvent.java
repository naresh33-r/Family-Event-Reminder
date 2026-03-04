package com.example.Family.Event.Reminder.familyModel;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class familyEvent {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public familyEvent() {
    }

    public familyEvent(String eventName, LocalDate eventDate, familyMember member) {

        this.eventName = eventName;
        this.eventDate = eventDate;
        this.member = member;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public familyMember getMember() {
        return member;
    }

    public void setMember(familyMember member) {
        this.member = member;
    }

    private String eventName;
    private LocalDate eventDate;

    @ManyToOne
    private familyMember member;
}
