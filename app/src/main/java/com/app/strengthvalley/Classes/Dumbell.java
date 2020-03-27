package com.app.strengthvalley.Classes;

import java.util.Objects;

import androidx.annotation.Nullable;

public class Dumbell {

    private long id;
    private double weight;

    public Dumbell() {
    }

    public Dumbell(long id, double weight) {
        this.id = id;
        this.weight = weight;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dumbell)) return false;
        Dumbell dumbell = (Dumbell) o;
        return id == dumbell.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
