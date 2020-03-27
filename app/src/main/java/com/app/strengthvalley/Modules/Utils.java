package com.app.strengthvalley.Modules;

import com.app.strengthvalley.Classes.Barbell;
import com.app.strengthvalley.Classes.Plate;

import java.util.ArrayList;

public class Utils {

    public static double LOMBARDI_CST = 0.1;

    public static double totalBarbellWeight(Barbell barbell, ArrayList<Plate> plates) {

        double weight = barbell.getWeight();

        for (Plate plate : plates) {
            weight += plate.getWeight();
        }
        return weight;
    }

    public static double calculateE1RM(int reps, double weight) { // Lombardi Method

        double repsDouble = reps;
        return Math.floor(weight * Math.pow(repsDouble, LOMBARDI_CST) + 0.5);
    }




}
