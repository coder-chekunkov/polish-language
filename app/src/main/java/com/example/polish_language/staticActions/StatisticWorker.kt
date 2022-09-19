package com.example.polish_language.staticActions

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE


private const val APP_PREFERENCES = "statistic"
private const val CORRECT_ANSWERS = "correct_answers"
private const val WRONG_ANSWERS = "wrong_answers"
private const val ALL_GAMES = "all_games"
private const val LAST_GAMES = "last_games"

// Класс хранения статистики:
class Statistic(
    val correctAnswers: Int,
    val wrongAnswers: Int,
    val allGames: Int,
    val lastGames: Int
)

// Получение основной статистики пользователя:
fun getStatistic(context: Context): Statistic {
    val mainStatistic = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

    val correctAnswers = mainStatistic.getInt(CORRECT_ANSWERS, 0) // Верные ответы
    val wrongAnswers = mainStatistic.getInt(WRONG_ANSWERS, 0) // Ошибки
    val allGames = mainStatistic.getInt(ALL_GAMES, 0) // Всего сыграно игр
    val lastGames = mainStatistic.getInt(LAST_GAMES, 10) // Кол-во оставшихся игр

    return Statistic(correctAnswers, wrongAnswers, allGames, lastGames)
}

// Изменение статистики после игры:
@SuppressLint("CommitPrefEdits")
fun increaseStatistic(context: Context, correct: Int, wrong: Int) {
    val mainStatistic = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    val editor = mainStatistic.edit()

    val correctAnswers = mainStatistic.getInt(CORRECT_ANSWERS, 0) // Верные ответы
    val wrongAnswers = mainStatistic.getInt(WRONG_ANSWERS, 0) // Ошибки
    val allGames = mainStatistic.getInt(ALL_GAMES, 0) // Всего сыграно игр
    val lastGames = mainStatistic.getInt(LAST_GAMES, 10) // Кол-во оставшихся игр

    editor.putInt(CORRECT_ANSWERS, correctAnswers + correct)
    editor.putInt(WRONG_ANSWERS, wrongAnswers + wrong)
    editor.putInt(ALL_GAMES, allGames + 1)
    editor.putInt(LAST_GAMES, lastGames - 1)

    editor.apply()
}

// Обнуление статистики:
fun restartStatistic(context: Context) {
    val mainStatistic = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    val editor = mainStatistic.edit()

    editor.putInt(CORRECT_ANSWERS, 0)
    editor.putInt(WRONG_ANSWERS, 0)
    editor.putInt(ALL_GAMES, 0)

    editor.apply()
}

// Обнуление количества оставшихся игр (каждые 24 часа):
fun restartLastGamesFromStatistic(context: Context) {
    val mainStatistic = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    val editor = mainStatistic.edit()

    editor.putInt(LAST_GAMES, 80)
    editor.apply()
}

// Получение 10 дополнительных игр, после просмотра рекламы:
fun addRewardGames(context: Context) {
    val mainStatistic = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    val editor = mainStatistic.edit()

    val lastGames = mainStatistic.getInt(LAST_GAMES, 80)

    if (lastGames >= 70) editor.putInt(LAST_GAMES, 80)
    else editor.putInt(LAST_GAMES, lastGames + 10)

    editor.apply()
}

// Получение количества оставшихся игр:
fun getLastGamesFromStatistic(context: Context): Int {
    val mainStatistic = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    return mainStatistic.getInt(LAST_GAMES, 80)
}

// Получение количество всех сыграных игр:
fun getAllGamesFromStatistic(context: Context): Int {
    val mainStatistic = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    return mainStatistic.getInt(ALL_GAMES, 0)
}
