package com.example.polish_language.staticActions

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.CountDownTimer
import com.example.polish_language.tabsWorker.showTimeInformation
import com.example.polish_language.tabsWorker.showTimeShop
import java.util.*

// Переменные для работы с таймером:
var mCountDownTimer: CountDownTimer? = null
const val PREFERENCES_TIME = "time"
private var mTimeLeftInMillis: Long = 86400000
private var mTimerRunning = false
private var mEndTime: Long = 0

class TimeWorker {
    fun startTimer(context: Context) {

        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis
        mTimerRunning = true

        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimeLeftInMillis = millisUntilFinished
                val lastTime: String = createStringWithTime(millisUntilFinished)
                showTimeShop(lastTime)
                showTimeInformation(lastTime)
            }

            override fun onFinish() {
                StatisticWorker().restartLastGamesFromStatistic(context)
                ProgressBarWorker().setBarOfProgress()
                ProgressBarWorker().setTextOfProgress()
                mTimeLeftInMillis = 86400000
                startTimer(context)
            }
        }.start()
    }

    // Метод записи переменных для работы с таймером в файл:
    fun setTimerPreferences(context: Context) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFERENCES_TIME, MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean("timerRunning", mTimerRunning)
        editor.putLong("millisLeft", mTimeLeftInMillis)
        editor.putLong("endTime", mEndTime)
        editor.apply()
    }

    // Метод получения переменных для работы с таймером из файла:
    fun getTimerPreferences(context: Context) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFERENCES_TIME, MODE_PRIVATE)
        mTimeLeftInMillis = prefs.getLong("millisLeft", 86400000)
        mTimerRunning = prefs.getBoolean("timerRunning", false)
        mEndTime = prefs.getLong("endTime", 0)
        if (mTimerRunning) {
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis()
            if (mTimeLeftInMillis < 0) {
                StatisticWorker().restartLastGamesFromStatistic(context)
                ProgressBarWorker().setBarOfProgress()
                ProgressBarWorker().setTextOfProgress()
                mTimeLeftInMillis = 86400000
            }
        }
        startTimer(context)
    }

    // Создание строки со временем:
    fun createStringWithTime(lastTime: Long): String {
        val hours = (lastTime / 3600000).toInt()
        val minutes = lastTime.toInt() / 60000 % 60
        val seconds = lastTime.toInt() / 1000 % 60
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds)
    }
}
