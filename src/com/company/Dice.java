package com.company;

class Dice extends com.company.BoardGameMaterial {
    int value;
    static Dice[] dice;

    private Dice() {
        roll();
    }

    void roll() {
        value = (int) (Math.random() * 6 + 1);
    }

    static void createDice() {
        dice = new Dice[5];
        for (int i = 0; i < 5; i++) {
            dice[i] = new Dice();
        }
    }
}