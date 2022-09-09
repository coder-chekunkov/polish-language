package com.example.polish_language.tabsWorker

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import com.example.polish_language.R

// Инизиализация окна с "Конец Игры":
@SuppressLint("StaticFieldLeak")
private lateinit var buttonCloseGameOver: ImageView
private lateinit var dialogGameOver: Dialog
fun initDialogGameOver(context: Context) {
    dialogGameOver = Dialog(context)
    dialogGameOver.setContentView(R.layout.tab_gameover)
    dialogGameOver.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    buttonCloseGameOver = dialogGameOver.findViewById(R.id.close_alert_dialog_no_game_more)
    buttonCloseGameOver.setOnClickListener(createListener())
}

// Отображение окна с "Конец Игры":
fun showGameOver() = dialogGameOver.show()

// Обработка нажатий на кнопки окна с "Конец Игры":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonCloseGameOver -> dialogGameOver.dismiss()
    }
}