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
private lateinit var dialogSettings: Dialog
fun initDialogSettings(context: Context) {
    dialogSettings = Dialog(context)
    dialogSettings.setContentView(R.layout.tab_settings)
    dialogSettings.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    buttonCloseSettings = dialogSettings.findViewById(R.id.close_alert_dialog_settings)
    buttonCloseSettings.setOnClickListener(createListener())
}

// Отображение окна с "Настройки":
fun showSettings() = dialogSettings.show()

// Обработка нажатий на кнопки окна с "Настройки":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonCloseSettings -> dialogSettings.dismiss()
    }
}


