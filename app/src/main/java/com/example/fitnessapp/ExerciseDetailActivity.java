package com.example.fitnessapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseDetailActivity extends AppCompatActivity {

    private ImageView exerciseImageView;
    private TextView exerciseDescription;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        // Initialize views
        exerciseImageView = findViewById(R.id.exerciseImageView);
        exerciseDescription = findViewById(R.id.exerciseDescription);
        backButton = findViewById(R.id.backButton);
        String exerciseName = getIntent().getStringExtra("EXERCISE_NAME");
        ExerciseMockup.ExerciseDetails details = ExerciseMockup.getExerciseDetails(exerciseName);

        if (details != null) {
            exerciseImageView.setImageResource(details.imageResourceId);
            exerciseDescription.setText(details.description);
        }

        backButton.setOnClickListener(v -> finish());
    }
}
