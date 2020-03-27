package com.app.strengthvalley.Classes;

import java.util.ArrayList;

public class Exercise {

    public static String BODY_WEIGHT = "BW";
    public static String ASSISTED_BODY_WEIGHT = "ABW";
    public static String CARDIO = "BW";
    public static String BARBELL = "B";
    public static String CABLE = "C";
    public static String DUMBELL = "D";
    public static String MACHINE = "M";
    public static String DURATION = "T";

    private Long id;
    private String name;
    private ArrayList<Set> sets;
    private int order;
    private int E1RMPosition;
    private int E1RM;
    private double totalVolume;
    private Dumbell dumbell;
    private Plate plate;
    private Barbell barbell;
    private ArrayList<Plate> plates;
    private String comment;
    private String type;

    public Exercise() {
    }

    public Exercise(Long id, String name, ArrayList<Set> sets, int order, int e1RMposition, int e1RM, String comment, String type) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.order = order;
        this.E1RMPosition = e1RMposition;
        E1RM = e1RM;
        this.comment = comment;
        this.type = type;
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

    public ArrayList<Set> getSets() {
        return sets;
    }

    public void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getE1RMposition() {
        return E1RMPosition;
    }

    public void setE1RMposition(int e1RMposition) {
        E1RMPosition = e1RMposition;
    }

    public int getE1RM() {
        return E1RM;
    }

    public void setE1RM(int e1RM) {
        E1RM = e1RM;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public int getE1RMPosition() {
        return E1RMPosition;
    }

    public void setE1RMPosition(int e1RMPosition) {
        E1RMPosition = e1RMPosition;
    }

    public Dumbell getDumbell() {
        return dumbell;
    }

    public void setDumbell(Dumbell dumbell) {
        this.dumbell = dumbell;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public Barbell getBarbell() {
        return barbell;
    }

    public void setBarbell(Barbell barbell) {
        this.barbell = barbell;
    }

    public ArrayList<Plate> getPlates() {
        return plates;
    }

    public void setPlates(ArrayList<Plate> plates) {
        this.plates = plates;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
