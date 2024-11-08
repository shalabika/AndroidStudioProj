package com.example.fitnessapp;

import java.util.ArrayList;
import java.util.List;

public class Mockup {

    public static List<String> getCategories(String categoryType) {
        List<String> itemList = new ArrayList<>();

        if ("Exercises".equals(categoryType)) {
            itemList.add("Back");
            itemList.add("Chest");
            itemList.add("Arms");
            itemList.add("Shoulders");
            itemList.add("Legs");
            itemList.add("Core");
        } else if ("Diet".equals(categoryType)) {
            itemList.add("Low Carb Meal");
            itemList.add("High Protein Meal");
            itemList.add("Vegan Meal");
            itemList.add("Keto Diet");
        } else if ("Education".equals(categoryType)) {
            itemList.add("Injury Prevention");
            itemList.add("Nutrition Basics");
            itemList.add("Mental Wellness");
        }

        return itemList;
    }

    public static List<String> getExercisesForCategory(String category) {
        return ExerciseMockup.getExercisesForMuscle(category);
    }
}
