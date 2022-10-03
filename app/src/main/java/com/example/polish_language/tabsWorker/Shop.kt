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
import com.example.polish_language.staticActions.ProgressBarWorker
import com.example.polish_language.staticActions.StatisticWorker
import com.example.polish_language.staticActions.ToastWorker

// Инизиализация окна с "Магазин":
@SuppressLint("StaticFieldLeak")
private lateinit var buttonCloseShop: ImageView

@SuppressLint("StaticFieldLeak")
private lateinit var buttonGetReward: ImageView

@SuppressLint("StaticFieldLeak")
private lateinit var context: Context

@SuppressLint("StaticFieldLeak")
private lateinit var timeText: TextView
private lateinit var dialogShop: Dialog
fun initDialogShop(mainContext: Context) {
    context = mainContext
    dialogShop = Dialog(context)
    dialogShop.setContentView(R.layout.tab_shop)
    dialogShop.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    buttonCloseShop = dialogShop.findViewById(R.id.close_alert_dialog_shop) // Кнопка закрытия окна
    buttonCloseShop.setOnClickListener(createListener())

    buttonGetReward = dialogShop.findViewById(R.id.button_shop_reward) // Кнопка получения игр
    buttonGetReward.setOnClickListener(createListener())
    timeText = dialogShop.findViewById(R.id.shop_text_timer)
}

// Отображение окна с "Магазин":
fun showShop() = dialogShop.show()

// Вывод времени до дополнительных игр:
fun showTimeShop(time: String) {
    timeText.text = time
}


// Обработка нажатий на кнопки окна с "Магазин":
private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
    when (view) {
        buttonCloseShop -> dialogShop.dismiss()
        buttonGetReward -> getRewards()
    }
}

// Запуск рекламы для получения новых игр:
private fun getRewards() {
    StatisticWorker().addRewardGames(context)
    ToastWorker().showToastGetReward()
    dialogShop.dismiss()

    ProgressBarWorker().setTextOfProgress()
    ProgressBarWorker().setBarOfProgress()
}