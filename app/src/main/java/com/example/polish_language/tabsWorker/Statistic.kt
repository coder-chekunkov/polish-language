package com.example.polish_language.tabsWorker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import com.example.polish_language.R

// Инизиализация окна с "Статистика":
@SuppressLint("StaticFieldLeak")
private lateinit var buttonCloseStatistic: ImageView
private lateinit var dialogStatistic: Dialog
fun initDialogStatistic(context: Context) {
    dialogStatistic = Dialog(context)
    dialogStatistic.setContentView(R.layout.tab_statistic)
    dialogStatistic.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    buttonCloseStatistic = dialogStatistic.findViewById(R.id.close_alert_dialog_statistic)
    buttonCloseStatistic.setOnClickListener(createListener())
}

// Отображение окна с "Статистика":
fun showStatistic() = dialogStatistic.show()

// Обработка нажатий на кнопки окна с "Статистика":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonCloseStatistic -> dialogStatistic.dismiss()
    }
}
