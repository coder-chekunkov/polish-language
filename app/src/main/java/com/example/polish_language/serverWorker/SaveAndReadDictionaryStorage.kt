package com.example.polish_language.serverWorker

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.polish_language.R
import com.example.polish_language.staticActions.ProgressBarWorker
import com.example.polish_language.staticActions.ToastWorker
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

private const val DICTIONARY_FROM_SERVER_FILE_NAME = "dictionary.json"

class SaveAndReadDictionaryStorage {

    // Метод сохранения словаря с сервера в память устройства:
    fun saveDictionary(context: Context, dictionary: List<ServerWord>?) {
        val data = Gson().toJson(dictionary)

        val writer = context.openFileOutput(DICTIONARY_FROM_SERVER_FILE_NAME, MODE_PRIVATE)
        writer.write(data.toByteArray())
        writer.close()

        ProgressBarWorker().setOfProgressAfterUpdate(context) // Обновление шкал с прогрессом
        ToastWorker().showToastServer(true)
    }

    // Метод проверки на существования словаря с сервера в памяти устройства:
    fun isFilePresent(context: Context): Boolean {
        val path = context.filesDir.absolutePath + "/" + DICTIONARY_FROM_SERVER_FILE_NAME
        val file = File(path)
        return file.exists()
    }

    // Метод чтения словаря с сервера в памяти устройства:
    fun readDictionaryFromStorage(context: Context): String {
        val file = context.openFileInput(DICTIONARY_FROM_SERVER_FILE_NAME)
        val inputStream = InputStreamReader(file)
        val reader = BufferedReader(inputStream)

        val data = StringBuilder()
        var line: String?

        while (reader.readLine().also { line = it } != null) data.append(line)

        return data.toString()
    }

    // Получение данных из словаря (dictionary.json) - ресурсы:
    fun readDictionaryFromRes(context: Context): String {
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
}