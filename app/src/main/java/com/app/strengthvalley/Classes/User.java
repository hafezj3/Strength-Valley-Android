package com.app.strengthvalley.Classes;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    public static String MALE = "M";
    public static String FEMALE = "F";

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String gender;
    private double weight;
    private int workoutCount;
    private int workoutCountCurrentWeek;
    private LocalDateTime birthDate;

    public User() {
    }

    public User(long id, String name, String username,
                String gender, double weight, int workoutCount, int workoutCountCurrentWeek, LocalDateTime birthDate) {
        this.id = id;
        this.firstName = name;
        this.username = username;
        this.gender = gender;
        this.weight = weight;
        this.workoutCount = workoutCount;
        this.workoutCountCurrentWeek = workoutCountCurrentWeek;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
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
