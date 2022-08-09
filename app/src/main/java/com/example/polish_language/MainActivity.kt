package com.example.polish_language

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testTextView = findViewById<TextView>(R.id.testTextView)
        val testButton = findViewById<Button>(R.id.testButton)
        val testButton2 = findViewById<Button>(R.id.testButton2)
        val testButton3 = findViewById<Button>(R.id.testButton3)

        val listener = View.OnClickListener { view ->
            testTextView.text = when (view.id) {
                R.id.testButton -> "Pushed Test Button 1"
                R.id.testButton2 -> "Pushed Test Button 2"
                R.id.testButton3 -> "Pushed Test Button 3"
                else -> "Error"
            }
        }

        testButton.setOnClickListener(listener)
        testButton2.setOnClickListener(listener)
        testButton3.setOnClickListener(listener)

    }
}