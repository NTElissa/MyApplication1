package com.example.tip_calculator;

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
        EditText editTextBillAmount = findViewById(R.id.editTextBillAmount);
        EditText editTextTipPercentage = findViewById(R.id.editTextTipPercentage);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        TextView textViewResult = findViewById(R.id.textViewResult);

        // Set a click listener on the button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get inputs from the EditText fields
                String billAmountText = editTextBillAmount.getText().toString();
                String tipPercentageText = editTextTipPercentage.getText().toString();

                // Validate inputs
                if (billAmountText.isEmpty() || tipPercentageText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both values", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    // Parse inputs
                    double billAmount = Double.parseDouble(billAmountText);
                    int tipPercentage = Integer.parseInt(tipPercentageText);

                    // Calculate tip and total amount
                    double tipAmount = (billAmount * tipPercentage) / 100;
                    double totalAmount = billAmount + tipAmount;

                    // Display the result
                    textViewResult.setText(String.format("Tip: %.2f\nTotal: %.2f", tipAmount, totalAmount));
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    Toast.makeText(MainActivity.this, "Invalid input format", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
