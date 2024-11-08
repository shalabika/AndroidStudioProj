package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SubcategoryActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> exerciseList;
    private String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcat);

        categoryName = getIntent().getStringExtra("CATEGORY_NAME");
        listView = findViewById(R.id.listView);
        exerciseList = ExerciseMockup.getExercisesForMuscle(categoryName);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exerciseList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> openExerciseDetailActivity(exerciseList.get(position)));

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> onBackPressed());
    }

    private void openExerciseDetailActivity(String exerciseName) {
        Intent intent = new Intent(SubcategoryActivity.this, ExerciseDetailActivity.class);
        intent.putExtra("EXERCISE_NAME", exerciseName);
        startActivity(intent);
    }

}
