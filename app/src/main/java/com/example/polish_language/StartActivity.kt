package com.example.polish_language

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val listener = View.OnClickListener { view -> if (view.id == R.id.goToMenu) goToMenu() }

        val buttonMenu = findViewById<Button>(R.id.goToMenu)
        buttonMenu.setOnClickListener(listener)
    }

    private fun goToMenu() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}