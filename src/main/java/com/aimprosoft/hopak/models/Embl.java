package com.aimprosoft.hopak.models;

import javax.persistence.Embeddable;

@Embeddable
public class Embl {

    Long id;
    String name;

    public Embl() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nEmbl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
