package com.example.calculator_scientific

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentInput: String = "0"
    private var operator: String? = null
    private var previousInput: Double = 0.0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        val number = button.text.toString()

        if (currentInput == "0") {
            currentInput = number
        } else {
            currentInput += number
        }

        resultTextView.text = currentInput
    }

    fun onOperatorClick(view: View) {
        val button = view as Button
        operator = button.text.toString()
        previousInput = currentInput.toDouble()
        currentInput = "0"
    }

    fun onDecimalClick(view: View) {
        if (!currentInput.contains(".")) {
            currentInput += "."
            resultTextView.text = currentInput
        }
    }

    fun onEqualsClick(view: View) {
        val secondInput = currentInput.toDouble()
        var result = 0.0

        when (operator) {
            "+" -> result = previousInput + secondInput
            "-" -> result = previousInput - secondInput
            "*" -> result = previousInput * secondInput
            "/" -> result = previousInput / secondInput
        }

        currentInput = result.toString()
        resultTextView.text = currentInput
        operator = null
    }

    fun onClearClick(view: View) {
        currentInput = "0"
        operator = null
        previousInput = 0.0
        resultTextView.text = currentInput
    }
}