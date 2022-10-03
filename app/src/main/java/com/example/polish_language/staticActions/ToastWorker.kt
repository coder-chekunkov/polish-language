package com.example.polish_language.staticActions

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.polish_language.R

@SuppressLint("StaticFieldLeak")
private lateinit var context: Context

class ToastWorker {

    // Инициализация контекста для окна с пояснением:
    fun initToast(mainContext: Context) {
        context = mainContext
    }

    // Вывод сообщения с пояснением:
    @SuppressLint("InflateParams")
    fun showToastExplanation(message: String, correct: Boolean) {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_toast, null)
        val cardView: CardView = view.findViewById(R.id.toastCard)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)
        val tvImage: ImageView = view.findViewById(R.id.tvImage)

        if (correct) {
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.correctAnswer))
            tvImage.setImageResource(R.drawable.good_smile_toast)
        } else {
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.wrongAnswer))
            tvImage.setImageResource(R.drawable.wrong_smile_toast)
        }
        tvMessage.text = message

        val toastExplanation = Toast(context)
        toastExplanation.view = view
        toastExplanation.show()
    }

    // Вывод сообщения о сбросе статистики:
    @SuppressLint("InflateParams")
    fun showToastRestartStatistic() {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_toast, null)
        val cardView: CardView = view.findViewById(R.id.toastCard)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)
        val tvImage: ImageView = view.findViewById(R.id.tvImage)

        cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.restartStatistic))
        tvImage.setImageResource(R.drawable.toast_icon_restart_statistic)
        tvMessage.text = "Статистика обновлена!"

        val toastGetReward = Toast(context)
        toastGetReward.view = view
        toastGetReward.show()
    }

    // Вывод сообщения о получении дополнительных игр:
    @SuppressLint("InflateParams")
    fun showToastGetReward() {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_toast, null)
        val cardView: CardView = view.findViewById(R.id.toastCard)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)
        val tvImage: ImageView = view.findViewById(R.id.tvImage)

        cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.error))
        tvImage.setImageResource(R.drawable.icon_cross)
        tvMessage.text = "Реклама недоступна! Получены дополнительные игры!"

        val toastGetReward = Toast(context)
        toastGetReward.view = view
        toastGetReward.show()
    }

    @SuppressLint("InflateParams")
// Вывод сообщения о успешном/ошибке получении новых заданий:
    fun showToastServer(result: Boolean) {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_toast, null)
        val cardView: CardView = view.findViewById(R.id.toastCard)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)
        val tvImage: ImageView = view.findViewById(R.id.tvImage)

        if (result) {
            cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.successfulServer
                )
            )
            tvImage.setImageResource(R.drawable.toast_icon_server)
            tvMessage.text = "Новые задания успешно получены!"
        } else {
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.error))
            tvImage.setImageResource(R.drawable.toast_icon_server)
            tvMessage.text = "Ошибка! Сервер недоступен!"
        }

        val toastServer = Toast(context)
        toastServer.view = view
        toastServer.show()
    }
}
