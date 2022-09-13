package com.example.polish_language.staticActions

import android.graphics.drawable.AnimationDrawable
import android.widget.ImageButton

fun ImageButton.startAnimation() {
    val animationOfButton: AnimationDrawable = this.background as AnimationDrawable
    animationOfButton.setEnterFadeDuration(500)
    animationOfButton.setExitFadeDuration(1000)
    animationOfButton.start()
}
