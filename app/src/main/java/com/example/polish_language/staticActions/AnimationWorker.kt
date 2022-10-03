package com.example.polish_language.staticActions

import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.polish_language.R

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

fun TextView.startAnimationTextView() {
    val animationOfTextView = AnimationUtils.loadAnimation(context, R.anim.text_appear)
    this.startAnimation(animationOfTextView)
}

fun ImageView.startAnimationImageView(correct: Boolean) {
    val animationOfImageView = AnimationUtils.loadAnimation(context, R.anim.smile_animation)

    if (correct) this.setImageResource(R.drawable.good_smile)
    else this.setImageResource(R.drawable.wrong_smile)

    this.visibility = View.VISIBLE
    this.startAnimation(animationOfImageView)
    this.visibility = View.INVISIBLE
}
