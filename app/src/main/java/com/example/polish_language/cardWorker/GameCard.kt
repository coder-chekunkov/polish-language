package com.example.polish_language.cardWorker

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.polish_language.R
import com.example.polish_language.gameWorker.addWordOnScreen
import com.example.polish_language.gameWorker.checkIsCorrectAns
import com.example.polish_language.staticActions.startAnimationButton
import com.example.polish_language.staticActions.startAnimationImageView
import com.example.polish_language.staticActions.startAnimationView

@SuppressLint("StaticFieldLeak")
private lateinit var imageAnswerOne: ImageView

@SuppressLint("StaticFieldLeak")
private lateinit var imageAnswerTwo: ImageView

@SuppressLint("StaticFieldLeak")
private lateinit var image: ImageButton

@SuppressLint("StaticFieldLeak")
private lateinit var viewOne: View

@SuppressLint("StaticFieldLeak")
private lateinit var buttonYes: ImageButton

@SuppressLint("StaticFieldLeak")
private lateinit var buttonNo: ImageButton

@SuppressLint("StaticFieldLeak")
private lateinit var textPlWord: TextView

@SuppressLint("StaticFieldLeak")
private lateinit var textRuWord: TextView
private lateinit var rootJSON: String

// Инициализация и анимация всех объектов на карточке "Игра":
fun initCardGameObjects(layout: LinearLayout, JSON: String) {

    imageAnswerOne = layout.findViewById(R.id.smile_one) // Смайлик ответа №1
    imageAnswerOne.visibility = View.INVISIBLE
    imageAnswerTwo = layout.findViewById(R.id.smile_two) // Смайлик ответа №2
    imageAnswerTwo.visibility = View.INVISIBLE

    image = layout.findViewById(R.id.image_view_card_view_game_play) // Анимационная заставка №1
    image.startAnimationButton()

    viewOne = layout.findViewById(R.id.card_view_game_one) // Анимационная заставка №2
    viewOne.startAnimationView()

    buttonYes = layout.findViewById(R.id.button_answer_yes) // Кнопка ответа "Да"
    buttonYes.setOnClickListener(createListener())
    buttonYes.startAnimationButton()

    buttonNo = layout.findViewById(R.id.button_answer_no) // Кнопка ответа "Нет"
    buttonNo.setOnClickListener(createListener())
    buttonNo.startAnimationButton()

    textPlWord = layout.findViewById(R.id.text_game_one) // Польское слово
    textRuWord = layout.findViewById(R.id.text_game_two) // Русское слово

    rootJSON = JSON // Основной словарь слов
}

// Обработчик нажатий на кнопки "Да" и "Нет":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonYes -> checkIsCorrectAns(true)
        buttonNo -> checkIsCorrectAns(false)
    }
}

// Получение нового уровня для игры:
fun createNewGame() = addWordOnScreen(rootJSON, textPlWord, textRuWord)

// Отрисовка смайликов взависимости от ответа:
fun startAnimationOfResultAnswer(correct: Boolean) {
    imageAnswerOne.startAnimationImageView(correct)
    imageAnswerTwo.startAnimationImageView(correct)
}