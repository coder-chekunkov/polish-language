package com.example.polish_language.tabsWorker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.polish_language.R
import com.example.polish_language.staticActions.StatisticWorker

// Инизиализация окна с "Статистика":
@SuppressLint("StaticFieldLeak")
private lateinit var buttonCloseStatistic: ImageView

@SuppressLint("StaticFieldLeak")
private lateinit var textCorrectAnswers: TextView

@SuppressLint("StaticFieldLeak")
private lateinit var textWrongAnswers: TextView

@SuppressLint("StaticFieldLeak")
private lateinit var textAllGames: TextView

@SuppressLint("StaticFieldLeak")
private lateinit var textLastGames: TextView

@SuppressLint("StaticFieldLeak")
private lateinit var context: Context

private lateinit var dialogStatistic: Dialog
fun initDialogStatistic(mainContext: Context) {
    context = mainContext
    dialogStatistic = Dialog(context)
    dialogStatistic.setContentView(R.layout.tab_statistic)
    dialogStatistic.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    buttonCloseStatistic = dialogStatistic.findViewById(R.id.close_alert_dialog_statistic)
    buttonCloseStatistic.setOnClickListener(createListener())

    textCorrectAnswers = dialogStatistic.findViewById(R.id.count_good_answers)
    textWrongAnswers = dialogStatistic.findViewById(R.id.count_bad_answers)
    textAllGames = dialogStatistic.findViewById(R.id.text_count_all_answers)
    textLastGames = dialogStatistic.findViewById(R.id.count_last_questions)
}

// Отображение окна с "Статистика":
fun showStatistic() {
    dialogStatistic.show()
    showDataStatistic()
}

// Обработка нажатий на кнопки окна с "Статистика":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonCloseStatistic -> dialogStatistic.dismiss()
    }
}

// Вывод статистики:
private fun showDataStatistic() {
    val dataStatistic = StatisticWorker().getStatistic(context)

    val correctAnswers = dataStatistic.correctAnswers
    val wrongAnswers = dataStatistic.wrongAnswers
    val allGames = dataStatistic.allGames
    val lastGames = dataStatistic.lastGames

    textCorrectAnswers.text = if (correctAnswers > 999) "999+" else correctAnswers.toString()
    textWrongAnswers.text = if (wrongAnswers > 999) "999+" else wrongAnswers.toString()
    textAllGames.text = if (allGames > 999) "999+" else allGames.toString()
    textLastGames.text = if (allGames > 999) "999+" else lastGames.toString()

}
