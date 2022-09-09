package com.example.polish_language

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.polish_language.gameWorker.addWordOnScreen
import com.example.polish_language.gameWorker.*
import com.example.polish_language.tabsWorker.*


class MainActivity : AppCompatActivity() {

    // Кнопки навигации по приложению:
    private lateinit var buttonStatistic: ImageButton
    private lateinit var buttonSettings: ImageButton

    //TODO: тестововые кнопки. Избавиться после создания игрового окна:
    private lateinit var polandWord: TextView
    private lateinit var ruWord: TextView
    private lateinit var buttonNewWord: Button
    private lateinit var buttonCorrect: Button
    private lateinit var buttonWrong: Button
    private lateinit var btStatistic: Button
    private lateinit var btSettings: Button
    private lateinit var btShop: Button
    private lateinit var btInfo: Button
    private lateinit var btGameOver: Button

    private lateinit var rootStringJSON: String // Переменная, хранящяя весь словарь (dictionary.json)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootStringJSON = readText(this) // Запись словаря в переменную

        buttonStatistic = findViewById(R.id.buttonStatistic) // Кнопка "Статистика"
        buttonStatistic.setOnClickListener(createClickNavigationButtons())
        buttonSettings = findViewById(R.id.buttonSettings) // Кнопка "Настройки"
        buttonSettings.setOnClickListener(createClickNavigationButtons())

        polandWord = findViewById(R.id.plWord)
        ruWord = findViewById(R.id.ruWord)
        buttonNewWord = findViewById(R.id.getNewWord)
        buttonCorrect = findViewById(R.id.buttonCorrectly)
        buttonWrong = findViewById(R.id.buttonWrong)
        buttonNewWord.setOnClickListener(createListener())
        buttonCorrect.setOnClickListener(createListener())
        buttonWrong.setOnClickListener(createListener())



        btStatistic = findViewById(R.id.buttonStatisticTab)
        btStatistic.setOnClickListener(createClickTestTabsListener())
        btSettings = findViewById(R.id.buttonSettingsTab)
        btSettings.setOnClickListener(createClickTestTabsListener())
        btShop = findViewById(R.id.buttonShopTab)
        btShop.setOnClickListener(createClickTestTabsListener())
        btInfo = findViewById(R.id.buttonInformationTab)
        btInfo.setOnClickListener(createClickTestTabsListener())
        btGameOver = findViewById(R.id.buttonGameOverTab)
        btGameOver.setOnClickListener(createClickTestTabsListener())


        initDialogInformation(this)
        initDialogSettings(this)
        initDialogStatistic(this)
        initDialogShop(this)
        initDialogGameOver(this)
    }

    // Отработка нажатий на кнопки:
    private fun createListener(): View.OnClickListener = View.OnClickListener { view ->
        when (view) {
            buttonNewWord -> addWordOnScreen(rootStringJSON, polandWord, ruWord)
            buttonCorrect -> {
                checkIsCorrectAns(true)
                addWordOnScreen(rootStringJSON, polandWord, ruWord)
            }
            buttonWrong -> {
                checkIsCorrectAns(false)
                addWordOnScreen(rootStringJSON, polandWord, ruWord)
            }
        }
    }

    // Обработка нажатий на кнопки навигации:
    private fun createClickNavigationButtons(): View.OnClickListener =
        View.OnClickListener { view ->
            when (view) {
                buttonStatistic -> showStatistic()
                buttonSettings -> showSettings()
            }
        }

    // Обработка нажатий на тестовые кнопки:
    private fun createClickTestTabsListener(): View.OnClickListener = View.OnClickListener { view ->
        when (view) {
            btStatistic -> showStatistic()
            btSettings -> showSettings()
            btShop -> showShop()
            btInfo -> showInformation()
            btGameOver -> showGameOver()
        }
    }
}
