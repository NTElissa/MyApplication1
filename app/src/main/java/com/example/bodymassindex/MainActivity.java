package com.example.bodymassindex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        EditText editTextWeight = findViewById(R.id.editTextWeight);
        EditText editTextHeight = findViewById(R.id.editTextHeight);
        Button buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        TextView textViewResult = findViewById(R.id.textViewResult);

        // Set a click listener on the button
        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                String weightText = editTextWeight.getText().toString();
                String heightText = editTextHeight.getText().toString();

                // Validate inputs
                if (weightText.isEmpty() || heightText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Parse inputs to numbers
                    double weight = Double.parseDouble(weightText);
                    double height = Double.parseDouble(heightText);

                    if (weight <= 0 || height <= 0) {
                        Toast.makeText(MainActivity.this, "Weight and height must be positive numbers", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Calculate BMI
                    double bmi = weight / (height * height);

                    // Determine BMI category
                    String category;
                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        category = "Normal weight";
                    } else {
                        category = "Overweight";
                    }

                    // Display the result
                    textViewResult.setText(String.format("BMI: %.2f\nCategory: %s", bmi, category));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid input format", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
