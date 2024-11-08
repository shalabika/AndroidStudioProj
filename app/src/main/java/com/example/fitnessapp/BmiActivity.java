package com.example.fitnessapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class BmiActivity extends AppCompatActivity {

    private EditText weightInput, heightInput;
    private TextView resultText;
    private Button calculateButton;
    private Button backButton;
    private RadioGroup radioGroupUnits;
    private Spinner weightSpinner, heightSpinner;
    private TextView weightSpinnerTitle, heightSpinnerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        resultText = findViewById(R.id.resultText);
        calculateButton = findViewById(R.id.calculateButton);
        backButton = findViewById(R.id.backButton);
        radioGroupUnits = findViewById(R.id.radioGroupUnits);
        weightSpinner = findViewById(R.id.weightSpinner);
        heightSpinner = findViewById(R.id.heightSpinner);
        weightSpinnerTitle = findViewById(R.id.weightSpinnerTitle);
        heightSpinnerTitle = findViewById(R.id.heightSpinnerTitle);

        ArrayAdapter<String> weightAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, generateWeightValues());
        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightSpinner.setAdapter(weightAdapter);

        ArrayAdapter<String> heightAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, generateHeightValues());
        heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heightSpinner.setAdapter(heightAdapter);

        calculateButton.setOnClickListener(v -> calculateBmi());
        backButton.setOnClickListener(v -> finish());

        radioGroupUnits.setOnCheckedChangeListener((group, checkedId) -> toggleUnitSelection(checkedId));
    }

    private void toggleUnitSelection(int checkedId) {
        if (checkedId == R.id.radioMetric) {
            weightInput.setVisibility(View.VISIBLE);
            heightInput.setVisibility(View.VISIBLE);
            weightSpinner.setVisibility(View.GONE);
            heightSpinner.setVisibility(View.GONE);
            weightSpinnerTitle.setVisibility(View.GONE);
            heightSpinnerTitle.setVisibility(View.GONE);
        } else if (checkedId == R.id.radioImperial) {
            weightInput.setVisibility(View.GONE);
            heightInput.setVisibility(View.GONE);
            weightSpinner.setVisibility(View.VISIBLE);
            heightSpinner.setVisibility(View.VISIBLE);
            weightSpinnerTitle.setVisibility(View.VISIBLE);
            heightSpinnerTitle.setVisibility(View.VISIBLE);
        }
    }

    private void calculateBmi() {
        int selectedUnitId = radioGroupUnits.getCheckedRadioButtonId();
        double weight = 0;
        double height = 0;

        try {
            if (selectedUnitId == R.id.radioMetric) {
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                if (weightStr.isEmpty() || heightStr.isEmpty()) {
                    resultText.setText("Please enter both weight and height.");
                    Toast.makeText(this, "Please enter both weight and height.", Toast.LENGTH_SHORT).show();
                    return;
                }

                weight = Double.parseDouble(weightStr);
                height = Double.parseDouble(heightStr) / 100;
            } else if (selectedUnitId == R.id.radioImperial) {
                weight = Integer.parseInt(weightSpinner.getSelectedItem().toString());
                height = Integer.parseInt(heightSpinner.getSelectedItem().toString());

                height = height * 0.0254;
                weight = weight * 0.453592;
            }

            if (weight <= 0 || height <= 0) {
                resultText.setText("Weight and height must be positive values.");
                Toast.makeText(this, "Weight and height must be positive values.", Toast.LENGTH_SHORT).show();
                return;
            }

            double bmi = weight / (height * height);
            resultText.setText("Your BMI: " + String.format("%.2f", bmi));
            String bmiCategory = getBmiCategory(bmi);
            Toast.makeText(this, "Category: " + bmiCategory, Toast.LENGTH_LONG).show();

        } catch (NumberFormatException e) {
            resultText.setText("Invalid input. Please enter numeric values.");
            Toast.makeText(this, "Invalid input. Please enter numeric values.", Toast.LENGTH_SHORT).show();
        }
    }

    private String getBmiCategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private String[] generateWeightValues() {
        return new String[] {"100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200", "210", "220", "230", "240"};
    }

    private String[] generateHeightValues() {
        return new String[] {"58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76"};
    }
}
