package com.app.strengthvalley.Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Workout {

    private long id;
    private long userId;
    private String name;
    private double totalVolume;
    private int PRCount;
    private ArrayList<Exercise> exercises;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Workout() {
    }

    public Workout(long id, long userId, String name, ArrayList<Exercise> exercises, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.exercises = exercises;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public int getPRCount() {
        return PRCount;
    }

    public void setPRCount(int PRCount) {
        this.PRCount = PRCount;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return id == workout.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
