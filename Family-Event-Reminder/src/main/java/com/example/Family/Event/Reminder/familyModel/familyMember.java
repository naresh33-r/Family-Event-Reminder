package com.example.Family.Event.Reminder.familyModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class familyMember {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private  String EmailID;
    private String Relation;
    public familyMember(String name, String emailID, String relation) {

        this.name = name;
        EmailID = emailID;
        Relation = relation;
    }



    public String getRelation() {
        return Relation;
    }

    public void setRelation(String relation) {
        Relation = relation;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getName() {
        return name;
    }

    public familyMember() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
