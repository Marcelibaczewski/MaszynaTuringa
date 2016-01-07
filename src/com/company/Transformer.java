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
        char sign = 'a';
        for (Sign b : input) {
            if (b.isCurrent()) sign = b.getSign();
        }
        if (sign == '0') {
            return zero;
        } else if (sign == '1') {
            return one;
        } else return b;
    }

    public int[] transform(ArrayList<Sign> signs, int stateAndPos[], BitParser bitParser) {
        int currentState;
        int currentPosition = stateAndPos[1];
        int[] tmp = new int[2];
        System.out.println(bitParser.printBits(signs));
        Triple chosen = choose(signs);
        if (chosen.getSign() == '-') {
            System.out.println("Zatrzymanie automatu");
            System.out.println("Roznica wlasciwa wynosi: " + bitParser.count(signs));
            tmp[0] = 100;
            tmp[1] = 100;
            return tmp;
        }//adding blank sign if reaching the end of input chain
        if (currentPosition == signs.size() - 1 && chosen.getDirection() == 'P') {
            signs.add(new Sign('B'));
        }
        //switching sign
        (signs.get(currentPosition)).setSign(chosen.getSign());
        //going left
        if (chosen.getDirection() == 'L') {
            signs.get(currentPosition).flipCurrent();
            signs.get(currentPosition - 1).flipCurrent();
            currentPosition--;
        }//going right
        if (chosen.getDirection() == 'P') {
            signs.get(currentPosition).flipCurrent();
            signs.get(currentPosition + 1).flipCurrent();
            currentPosition++;
        }//changing a current state
        currentState = chosen.getState();
        tmp[0] = currentState;
        tmp[1] = currentPosition;
        return tmp;
    }
}