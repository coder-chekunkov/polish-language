package com.example.polish_language.gameWorker

import android.content.Context
import com.example.polish_language.R
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

// Класс для хранения слова из словаря (dictionary.json):
class Word(val plWord: String, val ruWordCorrect: String, val ruWordWrong: String)

// Создание объекта с данными из словаря:
fun readDictionaryJSONFile(rootStringJSON: String, idWord: Int): Word {

    val jsonArray = JSONArray(rootStringJSON)
    for (i in 0 until jsonArray.length()) {
        val jsonRoot = jsonArray.getJSONObject(i)
        val id = jsonRoot.getInt("id")

        if (id == idWord) {
            val plWord = jsonRoot.getString("plWord")
            val ruWord = jsonRoot.getString("ruWord")
            val ruWrongWord = jsonRoot.getString("ruWrongWord")

            return Word(plWord, ruWord, ruWrongWord)
        }
    }

    return Word("error", "error", "error")
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