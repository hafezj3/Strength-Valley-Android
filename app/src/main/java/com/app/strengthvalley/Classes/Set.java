package com.app.strengthvalley.Classes;

public class Set {

   private long id;
   private long exerciseId;
   private int reps;
   private int order;
   private double weight;
   private int duration;//in seconds
   private int E1RM;// estimated 1RM
   private double volume;
   private String comment;
   private String status;

    public Set() {
        this.id=0;
        this.exerciseId=0;
        this.reps=0;
        this.order=0;
        this.weight=0;
        this.duration=0;
        this.E1RM=0;
        this.comment = null;
        this.status = null;
    }


//    public Set(Set set){
//        this = new Set()
//    }


    public Set(long id, long exerciseId, int reps, int order, double weight, int duration, String comment,String status) {
        this.id = id;
        this.exerciseId = exerciseId;
        this.reps = reps;
        this.order = order;
        this.weight = weight;
        this.duration = duration;
        this.comment = comment;
        this.status = status;
        E1RM = 0;// TODO TO BE CHANGED
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getE1RM() {
        return E1RM;
    }

    public void setE1RM(int e1RM) {
        E1RM = e1RM;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
