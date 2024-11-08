package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> itemList;
    private String categoryType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView = findViewById(R.id.listView);
        categoryType = getIntent().getStringExtra("CATEGORY_TYPE");

        if ("Exercises".equals(categoryType)) {
            itemList = Mockup.getCategories("Exercises");
        } else if ("Diet".equals(categoryType)) {
            itemList = Mockup.getCategories("Diet");
        } else if ("Education".equals(categoryType)) {
            itemList = Mockup.getCategories("Education");
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if ("Exercises".equals(categoryType)) {
                openSubcategoryActivity(itemList.get(position));
            } else if ("Diet".equals(categoryType)) {
                openDayMenuActivity(itemList.get(position));
            } else if ("Education".equals(categoryType)) {
                openEducationActivity(itemList.get(position));
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }

    private void openSubcategoryActivity(String category) {
        Intent intent = new Intent(CategoryActivity.this, SubcategoryActivity.class);
        intent.putExtra("CATEGORY_NAME", category);
        startActivity(intent);
    }

    private void openDayMenuActivity(String dietType) {
        Intent intent = new Intent(CategoryActivity.this, DayMenuActivity.class);
        intent.putExtra("DIET_TYPE", dietType);
        startActivity(intent);
    }

    private void openEducationActivity(String educationTopic) {
        Intent intent = new Intent(CategoryActivity.this, EducationActivity.class);
        intent.putExtra("EDUCATION_TOPIC", educationTopic);
        startActivity(intent);
    }
}
