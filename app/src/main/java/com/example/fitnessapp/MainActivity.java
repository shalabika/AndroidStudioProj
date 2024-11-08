package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply window insets to prevent content from overlapping with system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //button click listeners
        findViewById(R.id.exercisesButton).setOnClickListener(v -> openCategoryActivity("Exercises"));
        findViewById(R.id.dietButton).setOnClickListener(v -> openCategoryActivity("Diet"));
        findViewById(R.id.educationButton).setOnClickListener(v -> openCategoryActivity("Education"));
        findViewById(R.id.bmiButton).setOnClickListener(v -> openBmiPage());
    }

    private void openCategoryActivity(String categoryType) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("CATEGORY_TYPE", categoryType);
        startActivity(intent);
    }

    private void openBmiPage() {
        Intent intent = new Intent(MainActivity.this, BmiActivity.class);
        startActivity(intent);
    }
}
