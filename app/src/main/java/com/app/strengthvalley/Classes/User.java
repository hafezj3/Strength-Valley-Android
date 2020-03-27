package com.app.strengthvalley.Classes;

import java.util.Objects;

public class User {

    public static String MALE = "M";
    public static String FEMALE = "F";

    private long id;
    private String name;
    private String gender;
    private double weight;
    private int workoutCount;
    private int workoutCountCurrentWeek;

    public User() {
    }

    public User(long id, String name, String gender, double weight, int workoutCount, int workoutCountCurrentWeek) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.workoutCount = workoutCount;
        this.workoutCountCurrentWeek = workoutCountCurrentWeek;
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

    public int getWorkoutCount() {
        return workoutCount;
    }

    public void setWorkoutCount(int workoutCount) {
        this.workoutCount = workoutCount;
    }

    public int getWorkoutCountCurrentWeek() {
        return workoutCountCurrentWeek;
    }

    public void setWorkoutCountCurrentWeek(int workoutCountCurrentWeek) {
        this.workoutCountCurrentWeek = workoutCountCurrentWeek;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
