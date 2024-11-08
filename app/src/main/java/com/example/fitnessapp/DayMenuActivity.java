package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DayMenuActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> daysList;
    private Map<String, List<String>> weeklyMenu;
    private String dietType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_menu);

        dietType = getIntent().getStringExtra("DIET_TYPE");
        listView = findViewById(R.id.listView);
        weeklyMenu = DietMockup.getWeeklyMenu(dietType);
        daysList = new ArrayList<>(weeklyMenu.keySet());
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daysList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedDay = daysList.get(position);
            openMealsActivity(selectedDay);
        });
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }

    private void openMealsActivity(String selectedDay) {
        Intent intent = new Intent(DayMenuActivity.this, MealsActivity.class);
        intent.putExtra("SELECTED_DAY", selectedDay);
        intent.putExtra("MEALS", new ArrayList<>(weeklyMenu.get(selectedDay)));
        startActivity(intent);
    }
}
