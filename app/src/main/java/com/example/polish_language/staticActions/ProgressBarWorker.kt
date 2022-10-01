package com.example.polish_language.staticActions

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.polish_language.MainActivity
import com.example.polish_language.R
import org.json.JSONArray

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
private const val lastGamesCount = 80
private var allGamesCount: Int = 0
private var rootString: String = ""

fun initProgress(mainLayout: RelativeLayout, mainContext: Context, rootStringJSON: String) {
    layout = mainLayout
    context = mainContext
    rootString = rootStringJSON
    allGamesCount = JSONArray(rootString).length()
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
    val allGames = "${getCorrectAnswersFromStatistic(context)}/${JSONArray(rootString).length()}"
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


fun setOfProgressAfterUpdate(mainContext: Context) {
    val newDictionary = MainActivity().getDictionary(mainContext)

    val allGames = "${getCorrectAnswersFromStatistic(context)}/${JSONArray(newDictionary).length()}"
    textAllGames.text = allGames
    progressAllGames.max = JSONArray(newDictionary).length()
}