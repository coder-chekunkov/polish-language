package com.example.polish_language

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.polish_language.gameWorker.addWordOnScreen
import com.example.polish_language.gameWorker.*


class MainActivity : AppCompatActivity() {

    private lateinit var polandWord: TextView
    private lateinit var ruWord: TextView

    private lateinit var buttonNewWord: Button
    private lateinit var buttonCorrect: Button
    private lateinit var buttonWrong: Button

    private lateinit var rootStringJSON: String // Переменная, хранящяя весь словарь (dictionary.json)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootStringJSON = readText(this) // Запись словаря в переменную
        val listener = createListener() // Реализация обработки нажатий на кнопки

        polandWord = findViewById(R.id.plWord)
        ruWord = findViewById(R.id.ruWord)

        buttonNewWord = findViewById(R.id.getNewWord)
        buttonCorrect = findViewById(R.id.buttonCorrectly)
        buttonWrong = findViewById(R.id.buttonWrong)

        buttonNewWord.setOnClickListener(listener)
        buttonCorrect.setOnClickListener(listener)
        buttonWrong.setOnClickListener(listener)
    }

    // Отработка нажатий на кнопки:
    private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
        when (view) {
            buttonNewWord -> addWordOnScreen(rootStringJSON, polandWord, ruWord)
            buttonCorrect -> {
                checkIsCorrectAns(true)
                addWordOnScreen(rootStringJSON, polandWord, ruWord)
            }
            buttonWrong -> {
                checkIsCorrectAns(false)
                addWordOnScreen(rootStringJSON, polandWord, ruWord)
            }
        }
    }
}
