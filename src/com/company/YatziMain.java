package com.company;

import java.util.Scanner;

public class YatziMain {

    private static int turn;
    private static final Die[] dice = new Die[5];

    YatziMain(){
        startGame();
    }

    protected static void createDice(Die[] dice) {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }

    private void startGame() {
        boolean gameIsOn = true;
        createDice(dice);
        while (gameIsOn && turn < 3) {
            System.out.println("Starting turn " + (turn + 1) + " of 3, rolling dice.");
            for (int i = 0; i < dice.length; i++) {
                dice[i].roll();
                System.out.println(i + ": " + "Dice Shows " + dice[i].value);
            }
            gameIsOn = false;
        }
    }

    protected static boolean checkIfYatzi(Die[] dice) {
        boolean yatzi = true;
        for (int i = 1; i < dice.length; i++) {
            if (dice[i].value != dice[i - 1].value) {
                yatzi = false;
                break;
            }
        }
        return yatzi;
    }

    private static void notYatzi() {
        if (turn != 2 && !checkIfYatzi(dice)) {
            System.out.println("Want to throw again? (y for yes, anything else for no)");
            checkInput();
        }
        else {
            gameOver();
        }
    }

    private static void gameOver() {
        System.out.println("Game over! Want to play again?");
        checkInput();
    }

    private static String getInput() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    private static void checkInput() {
        if (getInput().equals("y")) {
            if (turn == 2) {
                turn = 0;
            } else {
                ++turn;
            }
            new YatziMain();
        } else {
            exitProgram();
        }
    }

    private static void exitProgram() {
        System.exit(0);
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Yatzi!");
        while (true) {
            new YatziMain();

            if (checkIfYatzi(dice)) {
                System.out.println("You got YATZI! in " + dice[0].value + "'s");
                exitProgram();
            } else {
                while (!checkIfYatzi(dice) && turn < 3) {
                    notYatzi();
                }
                if (checkIfYatzi(dice)) {
                    System.out.println("You got YATZI! in " + dice[0].value + "'s");
                    exitProgram();
                }
            }

            gameOver();
        }
    }
}