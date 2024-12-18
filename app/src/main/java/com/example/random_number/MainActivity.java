package com.example.random_number;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        EditText editTextMin = findViewById(R.id.editTextMin);
        EditText editTextMax = findViewById(R.id.editTextMax);
        Button buttonGenerate = findViewById(R.id.buttonGenerate);
        TextView textViewResult = findViewById(R.id.textViewResult);

        // Set a click listener on the button
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the minimum and maximum numbers
                String minText = editTextMin.getText().toString();
                String maxText = editTextMax.getText().toString();

                // Validate inputs
                if (minText.isEmpty() || maxText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int min = Integer.parseInt(minText);
                    int max = Integer.parseInt(maxText);

                    if (min >= max) {
                        Toast.makeText(MainActivity.this, "Minimum must be less than maximum", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Generate random number within the range
                    Random random = new Random();
                    int randomNumber = random.nextInt(max - min + 1) + min;

                    // Display the result
                    textViewResult.setText("Random Number: " + randomNumber);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid number format", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
