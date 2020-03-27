package com.app.strengthvalley.Classes;

import java.util.Objects;

public class Plate {

    private long id;
    private double weight;
    private String type;

    public Plate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plate)) return false;
        Plate plate = (Plate) o;
        return id == plate.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
