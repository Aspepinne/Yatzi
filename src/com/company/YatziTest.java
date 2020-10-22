package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {

    @DisplayName("Test if all dice have same value")
    @Test
    void isYatzi() {
        Die[] dice = new Die[5];
        YatziMain.createDice(dice);
        for (Die die : dice) {
            die.value = 5;
        }
        assertTrue(com.company.YatziMain.checkIfYatzi(dice));
    }

    @DisplayName("Test if all dice do not have same value")
    @Test
    void isNotYatzi() {
        Die[] dice = new Die[5];
        YatziMain.createDice(dice);
        for (Die die : dice) {
            die.value = 5;
        }
        dice[1].value = 1;
        assertFalse(com.company.YatziMain.checkIfYatzi(dice));
    }

}
