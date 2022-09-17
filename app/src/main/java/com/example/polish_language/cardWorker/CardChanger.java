package com.example.polish_language.cardWorker;

import android.widget.ImageButton;
import android.widget.ViewFlipper;

import com.example.polish_language.R;

public class CardChanger {
    private final ViewFlipper vf;
    private final ImageButton buttonStart;
    private boolean isGame = false;

    public CardChanger(ViewFlipper vf, ImageButton buttonPlay) {
        this.vf = vf;
        this.buttonStart = buttonPlay;
    }

    // Метод для смены карточек игры:
    public void startChanger() {
        int buffGame;
        if (!isGame) {
            buffGame = 1;
            isGame = true;
        } else {
            buffGame = 2;
            isGame = false;
        }
        changeCard(buffGame);
    }

    // Метод смены карточек "Описание" -> "Игра":
    private void changeCard(int vfNumber) {
        vf.setDisplayedChild(vfNumber);
        if (vfNumber == 1) {
            buttonStart.setImageResource(R.drawable.icon_button_stop);
        } else {
            buttonStart.setImageResource(R.drawable.icon_button_start);
        }
    }
}
