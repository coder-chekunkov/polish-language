package com.example.polish_language.staticActions

import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.widget.ImageButton

fun ImageButton.startAnimationButton() {
    val animationOfButton: AnimationDrawable = this.background as AnimationDrawable
    animationOfButton.setEnterFadeDuration(500)
    animationOfButton.setExitFadeDuration(1000)
    animationOfButton.start()
}

fun View.startAnimationView() {
    val animationOfButton: AnimationDrawable = this.background as AnimationDrawable
    animationOfButton.setEnterFadeDuration(500)
    animationOfButton.setExitFadeDuration(1000)
    animationOfButton.start()
}