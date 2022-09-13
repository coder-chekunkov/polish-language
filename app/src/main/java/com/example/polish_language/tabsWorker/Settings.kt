package com.example.polish_language.tabsWorker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import com.example.polish_language.R

// Инизиализация окна с "Настройки":
@SuppressLint("StaticFieldLeak")
private lateinit var buttonCloseSettings: ImageView

@SuppressLint("StaticFieldLeak")
private lateinit var buttonReview: ImageView

@SuppressLint("StaticFieldLeak")
private lateinit var buttonRestart: ImageView

@SuppressLint("StaticFieldLeak")
private lateinit var buttonGetData: ImageView
private lateinit var dialogSettings: Dialog
fun initDialogSettings(context: Context) {
    dialogSettings = Dialog(context)
    dialogSettings.setContentView(R.layout.tab_settings)
    dialogSettings.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    buttonCloseSettings = dialogSettings.findViewById(R.id.close_alert_dialog_settings)
    buttonCloseSettings.setOnClickListener(createListener())

    buttonReview = dialogSettings.findViewById(R.id.button_settings_review)
    buttonReview.setOnClickListener(createListener())

    buttonRestart = dialogSettings.findViewById(R.id.button_settings_restart)
    buttonRestart.setOnClickListener(createListener())

    buttonGetData = dialogSettings.findViewById(R.id.button_get_data)
    buttonGetData.setOnClickListener(createListener())
}

// Отображение окна с "Настройки":
fun showSettings() = dialogSettings.show()

// Обработка нажатий на кнопки окна с "Настройки":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonCloseSettings -> dialogSettings.dismiss()
        buttonReview -> setReview()
        buttonRestart -> restartGame()
        buttonGetData -> getData()
    }
}

// Оставить отзыв о приложении:
private fun setReview() {
    println("---> Pushed Button: Set Review <---")
}

// Обнуление результата правильно выполненых заданий:
private fun restartGame() {
    println("---> Pushed Button: Restart Game <---")
}

// Запрос новых заданий для игр:
private fun getData() {
    println("---> Pushed Button: Get Data <---")
}

