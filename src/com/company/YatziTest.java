package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.company.Dice.dice;

public class YatziTest {

    @DisplayName("Test if all dice have same value")
    @Test
    void isYatzi() {
        com.company.Dice.createDice();
        for (com.company.Dice die : dice) {
            die.value = 5;
        }
        assertTrue(com.company.BoardGameMaterial.checkIfYatzi(dice));
    }

    @DisplayName("Test if all dice do not have same value")
    @Test
    void isNotYatzi() {
        com.company.Dice.createDice();
        for (com.company.Dice die : dice) {
            die.value = 5;
        }
        dice[1].value = 1;
        assertFalse(com.company.BoardGameMaterial.checkIfYatzi(dice));
    }

}
