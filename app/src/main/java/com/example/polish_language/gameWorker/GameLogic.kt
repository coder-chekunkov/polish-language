package com.example.polish_language.gameWorker

import android.annotation.SuppressLint
import android.widget.TextView
import com.example.polish_language.cardWorker.createNewGame
import com.example.polish_language.cardWorker.startAnimationOfResultAnswer
import com.example.polish_language.staticActions.showToast
import com.example.polish_language.staticActions.startAnimationTextView
import kotlin.random.Random

private var isCorrect = true // Переменная для хранения "правильности" слова
private var plWordValue = "" // Переменная для хранения Польского слова
private var ruWordCorrectValue = "" // Переменная для хранения Русского-правильного слова
private var ruWordWrongValue = "" // Переменная для хранения Русского-неправильного слова

@SuppressLint("SetTextI18n")
fun addWordOnScreen(rootStringJSON: String, plWord: TextView, ruWord: TextView) {
    isCorrect = createRandomCorrectValue() // Рандомная переменная для правильности слова
    val idWord = createRandomIdWord() // Рандомная переменная для номера слова
    val word = readDictionaryJSONFile(rootStringJSON, idWord) // Слово из словаря

    plWordValue = "\"${word.plWord}\""
    ruWordCorrectValue = "\"${word.ruWordCorrect}\""
    ruWordWrongValue = "\"${word.ruWordWrong}\""

    plWord.text = plWordValue // Вывод Польского слова на экран
    ruWord.text = if (isCorrect) ruWordCorrectValue else ruWordWrongValue // Вывод Русского слова

    plWord.startAnimationTextView() // Запуск анимации Польского слова
    ruWord.startAnimationTextView() // Запуск анимации Русского слова
}

// Проверка правильно ответа пользователя:
fun checkIsCorrectAns(userAnswer: Boolean) {
    if (userAnswer == isCorrect) {
        val textOfExplanation = createExplanation(true) // Пояснение
        startAnimationOfResultAnswer(true) // Анимация смайликов результата (верно)
        showToast(textOfExplanation, true) // Вывод сообщения с пояснением
    } else {
        val textOfExplanation = createExplanation(false) // Пояснение
        startAnimationOfResultAnswer(false) // Анимация смайликов результата (ошибка)
        showToast(textOfExplanation, false) // Вывод сообщения с пояснением
    }

    createNewGame()
}

private fun createRandomIdWord(): Int = (1..130).shuffled().last()
private fun createRandomCorrectValue(): Boolean = Random.nextBoolean()
private fun createExplanation(correct: Boolean): String {
    val answer = if (correct) "Верно!" else "Ошибка!"
    return "$answer $plWordValue -> $ruWordCorrectValue"
}

