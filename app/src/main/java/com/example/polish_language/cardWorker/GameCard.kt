package com.example.polish_language.cardWorker

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import com.example.polish_language.R
import com.example.polish_language.staticActions.startAnimationButton
import com.example.polish_language.staticActions.startAnimationView


@SuppressLint("StaticFieldLeak")
private lateinit var image: ImageButton

@SuppressLint("StaticFieldLeak")
private lateinit var viewOne: View

@SuppressLint("StaticFieldLeak")
private lateinit var buttonYes: ImageButton

@SuppressLint("StaticFieldLeak")
private lateinit var buttonNo: ImageButton

// Инициализация и анимация всех объектов на карточке "Игра":
fun initCardGameObjects(layout: LinearLayout) {
    image = layout.findViewById(R.id.image_view_card_view_game_play)
    image.startAnimationButton()

    viewOne = layout.findViewById(R.id.card_view_game_one)
    viewOne.startAnimationView()

    buttonYes = layout.findViewById(R.id.button_answer_yes)
    buttonYes.setOnClickListener(createListener())
    buttonYes.startAnimationButton()

    buttonNo = layout.findViewById(R.id.button_answer_no)
    buttonNo.setOnClickListener(createListener())
    buttonNo.startAnimationButton()
}

// Обработчик нажатий на кнопки "Да" и "Нет":
private fun createListener(): View.OnClickListener = View.OnClickListener { }