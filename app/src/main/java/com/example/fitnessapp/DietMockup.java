package com.example.fitnessapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DietMockup {

    public static Map<String, List<String>> getWeeklyMenu(String dietType) {
        Map<String, List<String>> weeklyMenu = new HashMap<>();

        if ("Low Carb Meal".equals(dietType)) {
            weeklyMenu.put("Monday", createLowCarbMeals());
            weeklyMenu.put("Tuesday", createLowCarbMeals());
            weeklyMenu.put("Wednesday", createLowCarbMeals());
            weeklyMenu.put("Thursday", createLowCarbMeals());
            weeklyMenu.put("Friday", createLowCarbMeals());
            weeklyMenu.put("Saturday", createLowCarbMeals());
            weeklyMenu.put("Sunday", createLowCarbMeals());
        } else if ("High Protein Meal".equals(dietType)) {
            weeklyMenu.put("Monday", createHighProteinMeals());
            weeklyMenu.put("Tuesday", createHighProteinMeals());
            weeklyMenu.put("Wednesday", createHighProteinMeals());
            weeklyMenu.put("Thursday", createHighProteinMeals());
            weeklyMenu.put("Friday", createHighProteinMeals());
            weeklyMenu.put("Saturday", createHighProteinMeals());
            weeklyMenu.put("Sunday", createHighProteinMeals());
        }

        // Return the populated weekly menu map
        return weeklyMenu;
    }

    private static List<String> createLowCarbMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Breakfast: Scrambled Eggs with Avocado");
        meals.add("Lunch: Grilled Chicken Salad");
        meals.add("Dinner: Baked Salmon with Steamed Veggies");
        meals.add("Snack: Almonds");
        return meals;
    }

    private static List<String> createHighProteinMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Breakfast: Greek Yogurt with Protein Powder");
        meals.add("Lunch: Grilled Chicken with Quinoa");
        meals.add("Dinner: Steak with Asparagus");
        meals.add("Snack: Cottage Cheese with Berries");
        return meals;
    }
}
