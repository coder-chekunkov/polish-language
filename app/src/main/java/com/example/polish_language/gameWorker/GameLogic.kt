package com.example.polish_language.gameWorker

import android.annotation.SuppressLint
import android.widget.TextView
import kotlin.random.Random

private var isCorrect = true// Переменная для хранения "правильности" слова

@SuppressLint("SetTextI18n")
fun addWordOnScreen(rootStringJSON: String, plWord: TextView, ruWord: TextView) {
    isCorrect = createRandomCorrectValue() // Рандомная переменная для правильности слова
    val idWord = createRandomIdWord() // Рандомная переменная для номера слова
    val word = readDictionaryJSONFile(rootStringJSON, idWord) // Слово из словаря

    val plWordValue = "\"${word.plWord}\""
    val ruWordCorrectValue = "\"${word.ruWordCorrect}\""
    val ruWordWrongValue = "\"${word.ruWordWrong}\""

    plWord.text = plWordValue // Вывод Польского слова на экран
    ruWord.text = if (isCorrect) ruWordCorrectValue else ruWordWrongValue // Вывод русского слова
}

// Проверка правильно ответа пользователя:
fun checkIsCorrectAns(userAnswer: Boolean) {
    if (userAnswer == isCorrect) {
        println("CORRECT ANSWER!")
    } else {
        println("WRONG ANSWER!")
    }
}

private fun createRandomIdWord(): Int = (1..50).shuffled().last()
private fun createRandomCorrectValue(): Boolean = Random.nextBoolean()