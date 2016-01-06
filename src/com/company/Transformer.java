package com.company;

import java.util.ArrayList;

/**
 * Created by Marceli Baczewski on 2016-01-06.
 */
public class Transformer {
    private Triple zero;
    private Triple one;
    private Triple b;

    public Transformer(Triple q0, Triple q1, Triple qb) {
        zero = q0;
        one = q1;
        b = qb;
    }
    public Triple choose(ArrayList<Sign> input) {
        char sign='a';
        for (Sign b:input) {
            if (b.isCurrent()) sign = b.getSign();
        }
        if (sign == '0') {
            return zero;
        } else if (sign == '1') {
            return one;
        } else return b;
    }
    public void transform(ArrayList<Sign> signs, int currentPosition, int currentState, BitParser bitParser) {
        System.out.println(bitParser.printBits(signs));
        Triple chosen = choose(signs);
        if (chosen.getSign() == '-') {
            System.out.println("Roznica wlasciwa wynosi" + bitParser.count(signs));
            currentState = 100;
            return;
        }
        if (currentPosition == signs.size()) {
            signs.add(new Sign('B'));
        }

        (signs.get(currentPosition)).setSign(chosen.getSign());
        //
        if (chosen.getDirection() == 'L') {
            signs.get(currentPosition).flipCurrent();
            signs.get(currentPosition - 1).flipCurrent();
            currentPosition-=1;
        }
        if (chosen.getDirection() == 'P') {
            signs.get(currentPosition).flipCurrent();
            signs.get(currentPosition + 1).flipCurrent();
            currentPosition+=1;
        }
        currentState = chosen.getState();
        //zmiana stanu
    }
}