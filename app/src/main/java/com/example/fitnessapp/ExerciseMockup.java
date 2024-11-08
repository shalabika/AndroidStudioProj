package com.example.fitnessapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseMockup {

    // This method returns exercises based on the muscle group or category
    public static List<String> getExercisesForMuscle(String muscleGroup) {
        Map<String, List<String>> exercises = new HashMap<>();

        List<String> backExercises = new ArrayList<>();
        backExercises.add("Deadlift");
        backExercises.add("Pull-up");
        backExercises.add("Bent-over Row");
        exercises.put("Back", backExercises);

        List<String> chestExercises = new ArrayList<>();
        chestExercises.add("Bench Press");
        chestExercises.add("Push-up");
        chestExercises.add("Chest Fly");
        exercises.put("Chest", chestExercises);

        List<String> armsExercises = new ArrayList<>();
        armsExercises.add("Bicep Curl");
        armsExercises.add("Tricep Pushdown");
        armsExercises.add("Hammer Curl");
        exercises.put("Arms", armsExercises);

        List<String> shouldersExercises = new ArrayList<>();
        shouldersExercises.add("Overhead Press");
        shouldersExercises.add("Lateral Raise");
        shouldersExercises.add("Front Raise");
        exercises.put("Shoulders", shouldersExercises);

        List<String> legsExercises = new ArrayList<>();
        legsExercises.add("Squat");
        legsExercises.add("Lunge");
        legsExercises.add("Leg Press");
        exercises.put("Legs", legsExercises);

        List<String> coreExercises = new ArrayList<>();
        coreExercises.add("Plank");
        coreExercises.add("Russian Twist");
        coreExercises.add("Leg Raise");
        exercises.put("Core", coreExercises);

        // Return the exercises based on the selected muscle group
        return exercises.getOrDefault(muscleGroup, new ArrayList<>());
    }

    // This method returns exercise details (image and description) for a given exercise name
    public static ExerciseDetails getExerciseDetails(String exerciseName) {
        if ("Deadlift".equals(exerciseName)) {
            return new ExerciseDetails(R.drawable.deadlift_image, "The Deadlift is a strength training exercise that works your back, glutes, and legs. Ensure proper form to avoid injury.");
        } else if ("Squat".equals(exerciseName)) {
            return new ExerciseDetails(R.drawable.squat_image, "The Squat is a compound exercise that targets your quadriceps, hamstrings, and glutes. Perform the exercise by lowering your body into a sitting position.");
        } else if ("Bench Press".equals(exerciseName)) {
            return new ExerciseDetails(R.drawable.bench_press_image, "The Bench Press is a classic upper-body exercise that works the chest, shoulders, and triceps. Lower the bar to your chest and press upward.");
        } else if ("Pull-up".equals(exerciseName)) {
            return new ExerciseDetails(R.drawable.pullup_image, "Pull-ups are a great upper-body exercise that work the back, shoulders, and arms. Grip the bar and pull your chin above it.");
        } else if ("Lunge".equals(exerciseName)) {
            return new ExerciseDetails(R.drawable.lunge_image, "Lunges are excellent for strengthening the legs and glutes. Step forward and lower your back knee toward the ground.");
        } else {
            // Default response if the exercise is not recognized
            return new ExerciseDetails(R.drawable.logo_image, "No description available for this exercise.");
        }
    }

    // Helper class to store the details (image and description) of an exercise
    public static class ExerciseDetails {
        public int imageResourceId;
        public String description;

        // Constructor to initialize the ExerciseDetails
        public ExerciseDetails(int imageResourceId, String description) {
            this.imageResourceId = imageResourceId;
            this.description = description;
        }
    }
}
