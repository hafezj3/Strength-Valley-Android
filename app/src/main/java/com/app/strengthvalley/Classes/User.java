package com.app.strengthvalley.Classes;

public class User {

    private long id;
    private String name;
    private int workoutCount;
    private int workoutCountCurrentWeek;

    public User() {
    }

    public User(long id, String name, int workoutCount, int workoutCountCurrentWeek) {
        this.id = id;
        this.name = name;
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
}
