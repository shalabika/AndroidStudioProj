package com.example.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import java.util.List;

public class MealsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> mealsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        String selectedDay = getIntent().getStringExtra("SELECTED_DAY");
        mealsList = getIntent().getStringArrayListExtra("MEALS");

        if (selectedDay == null || mealsList == null) {
            Toast.makeText(this, "Error: No meals data found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setTitle("Meals for " + selectedDay);

        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mealsList);
        listView.setAdapter(adapter);

        AppCompatButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }
}
