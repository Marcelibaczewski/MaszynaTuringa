package com.company;

/**
 * Created by Marceli Baczewski on 2016-01-06.
 */
public class Sign {
    private char sign;
    private boolean current;

    public Sign(char i) {
        current = false;
        sign = i;
    }

    public char getSign() {return sign;}

    public void setSign(char a) {sign = a;}

    public boolean isCurrent() {return current;}

    public void flipCurrent() {current = !current;}

    public String construct() {
        String output = "";
        output += '|';
        if (current) {
            output += "<q";
            output += Main.stateAndPos[0];
            output += ">";
        }
        output += sign;
        output += '|';
        return output;
    }
}
