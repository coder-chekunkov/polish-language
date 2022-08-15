package com.example.polish_language.gameWorker

import android.content.Context
import com.example.polish_language.R
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

// Класс для хранения слова из словаря (dictionary.json):
class Word(val plWord: String, val ruWordCorrect: String, val ruWordWrong: String)

// Создание объекта с данными из словаря:
fun readDictionaryJSONFile(rootStringJSON: String, idWord: Int): Word {
    val jsonRoot = JSONObject(rootStringJSON)
    val jsonWord = jsonRoot.getJSONObject(idWord.toString())

    val plWord = jsonWord.getString("pl_word")
    val ruWordCorrect = jsonWord.getString("ru_word")
    val ruWordWrong = jsonWord.getString("ru_word_wrong")

    return Word(plWord, ruWordCorrect, ruWordWrong)
}

// Получение данных из словаря (dictionary.json):
fun readText(context: Context): String {
    val inputStream: InputStream = context.resources.openRawResource(R.raw.dictionary)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))

    val file = StringBuilder()
    var value: String?

    while (bufferedReader.readLine().also { value = it } != null) {
        file.append(value)
        file.append("\n")
    }

    return file.toString()
}