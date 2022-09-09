package com.example.polish_language.tabsWorker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import com.example.polish_language.R

// Инизиализация окна с "Информация":
@SuppressLint("StaticFieldLeak")
private lateinit var buttonCloseInfo: ImageView
private lateinit var dialogInformation: Dialog
fun initDialogInformation(context: Context) {
    dialogInformation = Dialog(context)
    dialogInformation.setContentView(R.layout.tab_information)
    dialogInformation.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    buttonCloseInfo = dialogInformation.findViewById(R.id.close_alert_dialog_information)
    buttonCloseInfo.setOnClickListener(createListener())
}

// Отображение окна с "Информация":
fun showInformation() = dialogInformation.show()

// Обработка нажатий на кнопки окна с "Информация":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonCloseInfo -> dialogInformation.dismiss()
    }
}


