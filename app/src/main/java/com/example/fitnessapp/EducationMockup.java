package com.example.fitnessapp;

import java.util.ArrayList;
import java.util.List;

public class EducationMockup {

    public static List<String> getEducationDetails(String educationTopic) {
        List<String> details = new ArrayList<>();


        if ("Nutrition Basics".equals(educationTopic)) {
            details.add("Nutrition is the science of food and its impact on the body.");
            details.add("It involves understanding vitamins, minerals, proteins, fats, and carbohydrates.");
            details.add("Good nutrition is essential for energy, muscle growth, and recovery.");
            details.add("Understanding calorie intake and expenditure is crucial for weight management.");
        }

        else if ("Mental Wellness".equals(educationTopic)) {
            details.add("Mental health is a state of well-being where individuals realize their abilities.");
            details.add("Exercise can reduce stress, improve mood, and boost cognitive function.");
            details.add("Mind-body practices like yoga and meditation can help improve mental health.");
            details.add("Understanding the connection between physical and mental well-being is essential for holistic health.");
        }

        else if ("Injury Prevention".equals(educationTopic)) {
            details.add("Injury prevention is the practice of reducing the risk of injuries during exercise.");
            details.add("Proper warm-up and cool-down routines are crucial to avoid injury.");
            details.add("Form and technique are key to preventing injuries during strength training.");
            details.add("Stretching and mobility exercises can improve flexibility and reduce the risk of strains.");
        }


        return details;
    }
}
