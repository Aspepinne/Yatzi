package com.company;

import java.util.Scanner;

import static com.company.Dice.*;
import static com.company.Dice.dice;

class BoardGameMaterial {
    private static int turn;

    static void startGame() {
        createDice();
        while (turn < 3) {
            System.out.println("Starting turn " + (turn + 1) + " of 3, rolling dice.");
            for (int i = 0; i < dice.length; i++) {
                dice[i].roll();
                System.out.println(i + ": " + "Dice Shows " + dice[i].value);
            }
            checkIfYatzi(dice);
        }
    }

    static boolean checkIfYatzi(Dice[] dice) {
        boolean yatzi = true;
        for (int i = 1; i < dice.length; i++) {
            if (dice[i].value != dice[i - 1].value) {
                yatzi = false;
                break;
            }
        }
        if (yatzi) {
            System.out.println("You got YATZI! in " + dice[0].value + "'s");
            YatziMain.exitProgram(); // Comment out while running isYatzi test
        } else {
            notYatzi(); // Comment out while running isNotYatzi test
        }
        return yatzi;
    }

    private static void notYatzi() {
        if (turn != 2) {
            System.out.println("Want to throw again? (y for yes, anything else for no)");
            checkInput();
        } else {
            gameOver();
        }
    }

    static void gameOver() {
        System.out.println("Game over! Want to play again?");
        checkInput();
    }

    private static String getInput() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    private static void checkInput() {
        if (getInput().equals("y")) {
            if (turn == 2){
                turn = 0;
            }else {
                ++turn;
            }
        }
        else {
            YatziMain.exitProgram();
        }
    }
}