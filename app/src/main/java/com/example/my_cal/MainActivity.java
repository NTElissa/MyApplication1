package com.example.my_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentInput = "";  // Holds the entire expression (operands + operators)
    private String operator = "";      // Holds the current operator
    private double firstNumber = 0;    // The first operand

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Set up button listeners
        setNumberClickListeners();
        setOperatorClickListeners();
        setControlButtons();
    }

    // Set up number buttons
    private void setNumberClickListeners() {
        int[] numberButtons = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            currentInput += button.getText().toString();
            resultTextView.setText(currentInput);  // Update the display with the current input
        };

        for (int id : numberButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    // Set up operator buttons (+, -, X, /)
    private void setOperatorClickListeners() {
        int[] operatorButtons = {R.id.buttonPlus, R.id.buttonMinus, R.id.buttonMultiply, R.id.buttonDivide};

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            operator = button.getText().toString();

            if (!currentInput.isEmpty()) {
                firstNumber = Double.parseDouble(currentInput);
                currentInput += " " + operator + " ";  // Add operator to current input
                resultTextView.setText(currentInput);  // Update display
            }
        };

        for (int id : operatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    // Set up control buttons (Clear, Backspace, Equals)
    private void setControlButtons() {
        // Clear Button
        findViewById(R.id.buttonClear).setOnClickListener(view -> {
            currentInput = "";
            firstNumber = 0;
            operator = "";
            resultTextView.setText("0");
        });

        // Backspace Button
        findViewById(R.id.buttonBackspace).setOnClickListener(view -> {
            if (!currentInput.isEmpty()) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
                resultTextView.setText(currentInput.isEmpty() ? "0" : currentInput);
            }
        });

        // Equals Button
        findViewById(R.id.buttonEquals).setOnClickListener(view -> {
            if (!currentInput.isEmpty() && !operator.isEmpty()) {
                String[] parts = currentInput.split(" " + operator + " ");  // Split input by operator
                if (parts.length == 2) {
                    double secondNumber = Double.parseDouble(parts[1]);
                    double result = performCalculation(firstNumber, secondNumber, operator);
                    currentInput += " = " + result;  // Append the result to the expression
                    resultTextView.setText(currentInput);  // Show complete expression with result

                    // Reset for next calculation
                    firstNumber = result;
                    operator = "";
                }
            }
        });
    }

    // Perform calculations
    private double performCalculation(double num1, double num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "X": return num1 * num2;
            case "/": return num1 / num2;
            default: return 0;
        }
    }
}
