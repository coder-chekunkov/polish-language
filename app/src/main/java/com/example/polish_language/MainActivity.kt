package com.example.polish_language

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.polish_language.cardWorker.CardChanger
import com.example.polish_language.cardWorker.createNewGame
import com.example.polish_language.cardWorker.initCardDescriptionObjects
import com.example.polish_language.cardWorker.initCardGameObjects
import com.example.polish_language.gameWorker.*
import com.example.polish_language.staticActions.initToast
import com.example.polish_language.staticActions.startAnimationButton
import com.example.polish_language.tabsWorker.*


class MainActivity : AppCompatActivity() {

    // Кнопки навигации по приложению:
    private lateinit var buttonStatistic: ImageButton
    private lateinit var buttonSettings: ImageButton
    private lateinit var buttonShop: ImageButton
    private lateinit var buttonInformation: ImageButton
    private lateinit var buttonStart: ImageButton

    private lateinit var rootStringJSON: String // Переменная, хранящяя весь словарь (dictionary.json)
    private lateinit var cardChanger: CardChanger // Объект класса, который меняет карточки
    private lateinit var lDescription: LinearLayout // Layout с карточкой "Описание"
    private lateinit var lGame: LinearLayout // Layout с карточкой "Игра"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootStringJSON = readText(this) // Запись словаря в переменную

        initObjects() // Инициализация всех объектов на данной активности
        initDialogs() // Инициализация всех окон
        initCardDescriptionObjects(lDescription)
        initCardGameObjects(lGame, rootStringJSON)

        val viewFlipper = findViewById<ViewFlipper>(R.id.vf) // Смена карт
        cardChanger = CardChanger(viewFlipper, buttonStart)
    }

    // Обработка нажатий на кнопки навигации:
    private fun createClickNavigationButtons(): View.OnClickListener =
        View.OnClickListener { view ->
            when (view) {
                buttonStatistic -> showStatistic()
                buttonSettings -> showSettings()
                buttonShop -> showShop()
                buttonInformation -> showInformation()
                buttonStart -> firstStartGame()
                lDescription -> firstStartGame()
            }
        }

    // Инициализация всех объектов на данной активности:
    private fun initObjects() {
        // Кнопки навигации по приложению:
        buttonStatistic = findViewById(R.id.buttonStatistic) // Кнопка "Статистика"
        buttonStatistic.setOnClickListener(createClickNavigationButtons())

        buttonSettings = findViewById(R.id.buttonSettings) // Кнопка "Настройки"
        buttonSettings.setOnClickListener(createClickNavigationButtons())

        buttonShop = findViewById(R.id.buttonShop) // Кнопка "Магазин"
        buttonShop.setOnClickListener(createClickNavigationButtons())
        buttonShop.startAnimationButton()

        buttonInformation = findViewById(R.id.buttonInformation) // Кнопка "Информация"
        buttonInformation.setOnClickListener(createClickNavigationButtons())
        buttonInformation.startAnimationButton()

        buttonStart = findViewById(R.id.buttonStart) // Кнопка "Начать игру"
        buttonStart.setOnClickListener(createClickNavigationButtons())
        buttonStart.startAnimationButton()

        lDescription = findViewById(R.id.lDescription) // Карточка "Описание"
        lDescription.setOnClickListener(createClickNavigationButtons())

        lGame = findViewById(R.id.lGame) // Карточка "Игра"
    }

    // Инициализация окон приложения:
    private fun initDialogs() {
        initDialogInformation(this) // Окно "Информация"
        initDialogSettings(this) // Окно "Настройки"
        initDialogStatistic(this) // Окно "Статистика"
        initDialogShop(this) // Окно "Магазин"
        initDialogGameOver(this) // Окно "Конец Игры"
        initToast(this) // Инициализация "Пояснения"
    }

    // Запуск игры после смены карт:
    private fun firstStartGame() {
        createNewGame()
        cardChanger.startChanger()
    }
}
