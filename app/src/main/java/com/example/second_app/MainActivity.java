package com.example.second_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        EditText editText = findViewById(R.id.editText);
        Button buttonReverse = findViewById(R.id.buttonReverse);
        TextView textViewResult = findViewById(R.id.textViewResult);

        // Set a click listener on the button
        buttonReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText
                String inputText = editText.getText().toString();

                // Reverse the text
                String reversedText = new StringBuilder(inputText).reverse().toString();

                // Display the reversed text
                textViewResult.setText(reversedText);
            }
        });
    }
}
