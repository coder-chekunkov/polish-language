package com.example.polish_language

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.polish_language.gameWorker.*
import com.example.polish_language.tabsWorker.*


class MainActivity : AppCompatActivity() {

    // Кнопки навигации по приложению:
    private lateinit var buttonStatistic: ImageButton
    private lateinit var buttonSettings: ImageButton
    private lateinit var buttonShop: ImageButton
    private lateinit var buttonInformation: ImageButton
    private lateinit var buttonStart: ImageButton

    private lateinit var rootStringJSON: String // Переменная, хранящяя весь словарь (dictionary.json)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootStringJSON = readText(this) // Запись словаря в переменную

        // Кнопки навигации по приложению:
        buttonStatistic = findViewById(R.id.buttonStatistic) // Кнопка "Статистика"
        buttonStatistic.setOnClickListener(createClickNavigationButtons())
        buttonSettings = findViewById(R.id.buttonSettings) // Кнопка "Настройки"
        buttonSettings.setOnClickListener(createClickNavigationButtons())
        buttonShop = findViewById(R.id.buttonShop) // Кнопка "Магазин"
        buttonShop.setOnClickListener(createClickNavigationButtons())
        buttonInformation = findViewById(R.id.buttonInformation) // Кнопка "Информация"
        buttonInformation.setOnClickListener(createClickNavigationButtons())
        buttonStart = findViewById(R.id.buttonStart) // Кнопка "Начать игру"
        buttonStart.setOnClickListener(createClickNavigationButtons())

        initDialogInformation(this)
        initDialogSettings(this)
        initDialogStatistic(this)
        initDialogShop(this)
        initDialogGameOver(this)
    }

    // Обработка нажатий на кнопки навигации:
    private fun createClickNavigationButtons(): View.OnClickListener =
        View.OnClickListener { view ->
            when (view) {
                buttonStatistic -> showStatistic()
                buttonSettings -> showSettings()
                buttonShop -> showShop()
                buttonInformation -> showInformation()
            }
        }
}
