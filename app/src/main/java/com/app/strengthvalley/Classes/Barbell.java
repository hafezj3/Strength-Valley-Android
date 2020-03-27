package com.app.strengthvalley.Classes;

import java.util.Objects;

import androidx.annotation.Nullable;

public class Barbell {

    //TODO add known names

    private long id;
    private String name;
    private double weight;

    public Barbell() {
    }

    public Barbell(long id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barbell barbell = (Barbell) o;
        return id == barbell.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
