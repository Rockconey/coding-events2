package org.launchcode.codingevents.models;

public class Event {

  private int id;
  private static int nextID = 1;

  private String name;
  private String description;

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextID;
        nextID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
