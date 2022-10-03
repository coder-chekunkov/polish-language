package com.example.polish_language.gameWorker

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import com.example.polish_language.cardWorker.createNewGame
import com.example.polish_language.cardWorker.startAnimationOfResultAnswer
import com.example.polish_language.serverWorker.SaveAndReadDictionaryStorage
import com.example.polish_language.staticActions.StatisticWorker
import com.example.polish_language.staticActions.ToastWorker
import com.example.polish_language.staticActions.startAnimationTextView
import org.json.JSONArray
import kotlin.random.Random

// Класс для хранения слова из словаря (dictionary.json):
class Word(val plWord: String, val ruWordCorrect: String, val ruWordWrong: String)

private var isCorrect = true // Переменная для хранения "правильности" слова
private var plWordValue = "" // Переменная для хранения Польского слова
private var ruWordCorrectValue = "" // Переменная для хранения Русского-правильного слова
private var ruWordWrongValue = "" // Переменная для хранения Русского-неправильного слова
private val saveReadDictionary = SaveAndReadDictionaryStorage() // Переменная для работы со словарем

@SuppressLint("StaticFieldLeak")
private lateinit var context: Context

class GameLogic {

    @SuppressLint("SetTextI18n")
    fun addWordOnScreen(
        rootStringJSON: String,
        plWord: TextView,
        ruWord: TextView,
        mainContext: Context
    ) {
        context = mainContext
        isCorrect = createRandomCorrectValue() // Рандомная переменная для правильности слова

        // Рандомная переменная для номера слова:
        val idWord =
            if (saveReadDictionary.isFilePresent(mainContext)) createRandomIdWordServer(
                JSONArray(rootStringJSON)
            ) else createRandomIdWordRes()
        val word = readDictionaryJSONFile(rootStringJSON, idWord) // Слово из словаря

        plWordValue = "\"${word.plWord}\""
        ruWordCorrectValue = "\"${word.ruWordCorrect}\""
        ruWordWrongValue = "\"${word.ruWordWrong}\""

        plWord.text = plWordValue // Вывод Польского слова на экран
        ruWord.text =
            if (isCorrect) ruWordCorrectValue else ruWordWrongValue // Вывод Русского слова

        plWord.startAnimationTextView() // Запуск анимации Польского слова
        ruWord.startAnimationTextView() // Запуск анимации Русского слова
    }

    // Проверка правильно ответа пользователя:
    fun checkIsCorrectAns(userAnswer: Boolean) {
        if (userAnswer == isCorrect) {
            val textOfExplanation = createExplanation(true) // Пояснение
            startAnimationOfResultAnswer(true) // Анимация смайликов результата (верно)
            ToastWorker().showToastExplanation(
                textOfExplanation,
                true
            ) // Вывод сообщения с пояснением
            StatisticWorker().increaseStatistic(context, 1, 0) // Изменение статистики
        } else {
            val textOfExplanation = createExplanation(false) // Пояснение
            startAnimationOfResultAnswer(false) // Анимация смайликов результата (ошибка)
            ToastWorker().showToastExplanation(
                textOfExplanation,
                false
            ) // Вывод сообщения с пояснением
            StatisticWorker().increaseStatistic(context, 0, 1) // Изменение статистики
        }

        createNewGame()
    }

    // Создание объекта с данными из словаря:
    private fun readDictionaryJSONFile(rootStringJSON: String, idWord: Int): Word {

        val jsonArray = JSONArray(rootStringJSON)
        for (i in 0 until jsonArray.length()) {
            val jsonRoot = jsonArray.getJSONObject(i)
            val id = jsonRoot.getInt("id")

            if (id == idWord) {
                val plWord = jsonRoot.getString("plWord")
                val ruWord = jsonRoot.getString("ruWord")
                val ruWrongWord = jsonRoot.getString("ruWrongWord")

                return Word(plWord, ruWord, ruWrongWord)
            }
        }

        return Word("error", "error", "error")
    }

    private fun createRandomIdWordServer(array: JSONArray): Int =
        (1..array.length()).shuffled().last()

    private fun createRandomIdWordRes(): Int = (1..200).shuffled().last()
    private fun createRandomCorrectValue(): Boolean = Random.nextBoolean()
    private fun createExplanation(correct: Boolean): String {
        val answer = if (correct) "Верно!" else "Ошибка!"
        return "$answer $plWordValue -> $ruWordCorrectValue"
    }
}



