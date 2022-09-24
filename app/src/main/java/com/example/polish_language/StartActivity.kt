package com.example.polish_language

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        android.os.Handler().postDelayed({ goToMenu() }, 1000)
    }

    // Переход в основное меню приложения:
    private fun goToMenu() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)
        finishAfterTransition()
    }
}