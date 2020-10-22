package com.company;

class Die {
    int value;

    Die() {
        roll();
    }

    void roll() {
        value = (int) (Math.random() * 6 + 1);
    }
}