/*
* File: MainController.java
* Author: Bodnár Bence
* Copyright: 2023, Bodnár Bence 
* Date: 2023-12-04
* Licenc: MIT
*
*/

package controllers;

import java.util.Random;
import views.MainWindow;

public class MainController {
    Random random = new Random();
    String[] cardSuits = { "♠", "♥", "♦", "♣" };


    MainWindow mainWindow;
    String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A" };

    enum Round {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }

    private int getRandom() {
        return random.nextInt(13);
    }

    private String getRandomSuit() {
        return cardSuits[random.nextInt(4)];
    }

    public void initEvent() {
        this.mainWindow.startBtn.addActionListener(
                event -> {
                    int humanCard1 = getRandom();
                    int humanCard2 = getRandom();
                    int computerCard1 = getRandom();
                    int computerCard2 = getRandom();
                    String humanCard1Str = cards[humanCard1];
                    String humanCard2Str = cards[humanCard2];
                    this.mainWindow.humanCard1Btn.setText(getRandomSuit() + humanCard1Str);
                    this.mainWindow.humanCard2Btn.setText(getRandomSuit() + humanCard2Str);
                    this.mainWindow.humanCard1Btn.setVisible(true);
                    this.mainWindow.humanCard2Btn.setVisible(true);
                });

        this.mainWindow.stopBtn.addActionListener(
                event -> {
                    System.out.println("Következő kör:");
                    this.round = Round.PREFLOP;
                    this.mainWindow.flop1Btn.setVisible(false);
                    this.mainWindow.flop2Btn.setVisible(false);
                    this.mainWindow.flop3Btn.setVisible(false);
                    this.mainWindow.turnButton.setVisible(false);
                    this.mainWindow.riverButton.setVisible(false);
                    this.mainWindow.humanCard1Btn.setVisible(false);
                    this.mainWindow.humanCard2Btn.setVisible(false);
                });

        this.mainWindow.nextBtn.addActionListener(
                event -> {
                    if (this.round == Round.PREFLOP) {
                        int flop1 = getRandom();
                        int flop2 = getRandom();
                        int flop3 = getRandom();

                        String flop1Str = cards[flop1];
                        String flop2Str = cards[flop2];
                        String flop3Str = cards[flop3];

                        this.mainWindow.flop1Btn.setText(getRandomSuit() + flop1Str);
                        this.mainWindow.flop2Btn.setText(getRandomSuit() + flop2Str);
                        this.mainWindow.flop3Btn.setText(getRandomSuit() + flop3Str);
                        this.mainWindow.flop1Btn.setVisible(true);
                        this.mainWindow.flop2Btn.setVisible(true);
                        this.mainWindow.flop3Btn.setVisible(true);
                        this.round = Round.FLOP;
                        return;
                    }

                    if (this.round == Round.FLOP) {
                        int turn = getRandom();
                        this.mainWindow.turnButton.setText(getRandomSuit() + cards[turn]);
                        this.mainWindow.turnButton.setVisible(true);
                        this.round = Round.TURN;
                        return;
                    }

                    if (this.round == Round.TURN) {
                        int river = getRandom();
                        this.mainWindow.riverButton.setText(getRandomSuit() + cards[river]);
                        this.mainWindow.riverButton.setVisible(true);
                        this.round = Round.RIVER;
                        return;
                    }
                });
            }

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.initEvent();
    }

    Round round = Round.PREFLOP;
}