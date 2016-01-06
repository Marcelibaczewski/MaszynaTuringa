package com.company;

/**
 * Created by Marceli Baczewski on 2016-01-06.
 */
public class Triple {
    private final int state;
    private final char sign;
    private final char direction;

    public Triple() {
        state = -1;
        sign = '-';
        direction = '-';
    }

    public Triple(int s, char sig, char dir) {
        state = s;
        sign = sig;
        direction = dir;
    }

    public int getState() {
        return state;
    }

    public char getSign() {
        return sign;
    }

    public char getDirection() {
        return direction;
    }
}
