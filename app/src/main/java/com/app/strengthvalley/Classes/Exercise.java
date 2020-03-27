package com.app.strengthvalley.Classes;

import java.util.ArrayList;
import java.util.Objects;


public class Exercise {

    /*All possible types*/
    public static String BODY_WEIGHT = "BW";
    public static String ASSISTED_BODY_WEIGHT = "ABW";
    public static String CARDIO = "BW";
    public static String BARBELL = "B";
    public static String CABLE = "C";
    public static String DUMBELL = "D";
    public static String MACHINE = "M";
    public static String DURATION = "T";

    /*All possible muscle categories*/
    public static String CHEST = "CHEST";
    public static String BACK = "BACK";
    public static String SHOULDERS = "SHOULDERS";
    public static String LEGS = "LEGS";
    public static String BICEPS = "BICEPS";
    public static String TRICEPS = "TRICEPS";
    public static String FOREARMS = "FOREARMS";
    public static String TRAPEZII = "TRAPEZII";
    public static String CORE = "CORE";

    private Long id;
    private String name;
    private ArrayList<Set> sets;
    private int order;
    private int E1RMPosition;
    private int E1RM;
    private double totalVolume;
    private String comment;
    private String type;
    private ArrayList<String> muscleCategories;

    public Exercise() {
    }

    public Exercise(Long id, String name, ArrayList<Set> sets, int order,
           int e1RMPosition, int e1RM, double totalVolume, String comment, String type, ArrayList<String> muscleCategories) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.order = order;
        E1RMPosition = e1RMPosition;
        E1RM = e1RM;
        this.totalVolume = totalVolume;
        this.comment = comment;
        this.type = type;
        this.muscleCategories = muscleCategories;
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

    public ArrayList<String> getMuscleCategories() {
        return muscleCategories;
    }

    public void setMuscleCategories(ArrayList<String> muscleCategories) {
        this.muscleCategories = muscleCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise)) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
