package com.example.torque

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var forceEditText: EditText
    private lateinit var distanceEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        forceEditText = findViewById(R.id.forceEditText)
        distanceEditText = findViewById(R.id.distanceEditText)
        resultTextView = findViewById(R.id.resultTextView)
        calculateButton = findViewById(R.id.calculateButton)

        // Set OnClickListener for the calculate button
        calculateButton.setOnClickListener {
            calculateTorque()
        }
    }

    private fun calculateTorque() {
        val forceText = forceEditText.text.toString()
        val distanceText = distanceEditText.text.toString()

        val force = forceText.toDoubleOrNull()
        val distance = distanceText.toDoubleOrNull()

        when {
            forceText.isEmpty() || distanceText.isEmpty() -> {
                resultTextView.text = "Please fill in both fields."
            }
            force == null || distance == null -> {
                resultTextView.text = "Please enter valid numeric values."
            }
            else -> {
                val torque = force * distance
                resultTextView.text = "Torque: %.2f Nm".format(torque)  // Formatting torque
            }
        }
    }
}
