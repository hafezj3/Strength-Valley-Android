package com.app.strengthvalley.Classes;

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
}
