package com.example.polish_language.staticActions

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.polish_language.R

@SuppressLint("StaticFieldLeak")
private lateinit var textAllGames: TextView

@SuppressLint("StaticFieldLeak")
private lateinit var textLastGames: TextView

@SuppressLint("StaticFieldLeak")
private lateinit var progressAllGames: ProgressBar

@SuppressLint("StaticFieldLeak")
private lateinit var progressLastGames: ProgressBar

@SuppressLint("StaticFieldLeak")
private lateinit var layout: RelativeLayout

@SuppressLint("StaticFieldLeak")
private lateinit var context: Context
private const val allGamesCount = 160
private const val lastGamesCount = 80

fun initProgress(mainLayout: RelativeLayout, mainContext: Context) {
    layout = mainLayout
    context = mainContext
    textAllGames = layout.findViewById(R.id.text_decided_questions)
    textLastGames = layout.findViewById(R.id.text_last_questions)
    progressAllGames = layout.findViewById(R.id.progressBar_decided_questions)
    progressAllGames.max = allGamesCount
    progressLastGames = layout.findViewById(R.id.progressBar_last_questions)
    progressLastGames.max = lastGamesCount

    setTextOfProgress()
    setBarOfProgress()
}

fun setTextOfProgress() {
    val allGames = "${getCorrectAnswersFromStatistic(context)}/$allGamesCount"
    val lastGames = "${getLastGamesFromStatistic(context)}/$lastGamesCount"

    textAllGames.text = allGames
    textLastGames.text = lastGames
}

fun setBarOfProgress() {
    val allGames = getCorrectAnswersFromStatistic(context)
    val lastGames = 80 - getLastGamesFromStatistic(context)

    progressAllGames.progress = allGames
    progressLastGames.progress = lastGames
}
