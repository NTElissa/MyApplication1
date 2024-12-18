package com.example.my_celsius;

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
        EditText editTextCelsius = findViewById(R.id.editTextCelsius);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        TextView textViewResult = findViewById(R.id.textViewResult);

        // Set a click listener on the button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input temperature in Celsius
                String inputText = editTextCelsius.getText().toString();

                // Validate the input
                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a temperature", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Parse the input to a number
                    double celsius = Double.parseDouble(inputText);

                    // Convert Celsius to Fahrenheit
                    double fahrenheit = (celsius * 9 / 5) + 32;

                    // Display the result
                    textViewResult.setText(String.format("Fahrenheit: %.2f", fahrenheit));
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    Toast.makeText(MainActivity.this, "Invalid temperature", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
