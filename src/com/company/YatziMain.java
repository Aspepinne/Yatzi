package com.company;

import static com.company.BoardGameMaterial.startGame;

public class YatziMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Yatzi!");
        startGame();
    }
    static void exitProgram() {
        System.exit(0);
    }
}