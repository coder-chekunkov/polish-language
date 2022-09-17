package com.example.polish_language.cardWorker

import android.annotation.SuppressLint
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
private lateinit var viewTwo: View

// Инициализация и анимация всех объектов на карточке "Описание":
fun initCardDescriptionObjects(layout: LinearLayout) {
    image = layout.findViewById(R.id.image_button_card_view_start)
    image.startAnimationButton()

    viewOne = layout.findViewById(R.id.card_view_view_one)
    viewOne.startAnimationView()

    viewTwo = layout.findViewById(R.id.card_view_view_two)
    viewTwo.startAnimationView()

}