package com.example.polish_language.tabsWorker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import com.example.polish_language.R

// Инизиализация окна с "Магазин":
@SuppressLint("StaticFieldLeak")
private lateinit var buttonCloseShop: ImageView
private lateinit var dialogShop: Dialog
fun initDialogShop(context: Context) {
    dialogShop = Dialog(context)
    dialogShop.setContentView(R.layout.tab_shop)
    dialogShop.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    buttonCloseShop = dialogShop.findViewById(R.id.close_alert_dialog_shop)
    buttonCloseShop.setOnClickListener(createListener())
}

// Отображение окна с "Магазин":
fun showShop() = dialogShop.show()

// Обработка нажатий на кнопки окна с "Магазин":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonCloseShop -> dialogShop.dismiss()
    }
}