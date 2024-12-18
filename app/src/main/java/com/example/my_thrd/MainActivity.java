package com.example.my_thrd;

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
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        Button buttonCalculateSquare = findViewById(R.id.buttonCalculateSquare);
        TextView textViewSquareResult = findViewById(R.id.textViewSquareResult);

        // Set a click listener on the button
        buttonCalculateSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input number from the EditText
                String inputText = editTextNumber.getText().toString();

                // Validate the input
                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Parse the input to a number and calculate the square
                    double number = Double.parseDouble(inputText);
                    double square = number * number;

                    // Display the result
                    textViewSquareResult.setText("Square: " + square);
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
