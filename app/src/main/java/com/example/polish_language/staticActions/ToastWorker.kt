package com.example.polish_language.staticActions

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.polish_language.R

@SuppressLint("StaticFieldLeak")
private lateinit var context: Context

// Инициализация контекста для окна с пояснением:
fun initToast(mainContext: Context) {
    context = mainContext
}

// Вывод сообщения с пояснением:
@SuppressLint("InflateParams")
fun showToastExplanation(message: String, correct: Boolean) {

    val view: View = if (correct) {
        LayoutInflater.from(context).inflate(R.layout.toast_correct, null)
    } else {
        LayoutInflater.from(context).inflate(R.layout.toast_wrong, null)
    }

    val tvMessage: TextView = view.findViewById(R.id.tvMessage)
    tvMessage.text = message

    val toastExplanation = Toast(context)
    toastExplanation.view = view
    toastExplanation.show()
}

// Вывод сообщения о сбросе статистики:
@SuppressLint("InflateParams")
fun showToastRestartStatistic() {
    val view = LayoutInflater.from(context).inflate(R.layout.toast_statistic, null)
    val tvMessage: TextView = view.findViewById(R.id.tvMessage)
    tvMessage.text = "Статистика обновлена!"

    val toastRestartStatistic = Toast(context)
    toastRestartStatistic.view = view
    toastRestartStatistic.show()
}

// Вывод сообщения о получении дополнительных игр:
@SuppressLint("InflateParams")
fun showToastGetReward() {
    val view = LayoutInflater.from(context).inflate(R.layout.toast_error, null)
    val tvMessage: TextView = view.findViewById(R.id.tvMessage)
    tvMessage.text = "Реклама недоступна! Получены дополнительные игры!"

    val toastGetReward = Toast(context)
    toastGetReward.view = view
    toastGetReward.show()
}
