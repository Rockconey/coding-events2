package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class EventCategory {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Field cannot be left blank.")
    private String name;

    public EventCategory(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public EventCategory() {}

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
