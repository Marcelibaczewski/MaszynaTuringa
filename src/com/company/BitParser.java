package com.company;

import java.util.ArrayList;

/**
 * Created by Barceli Maczewski on 2016-01-06.
 */
public class BitParser {
    public BitParser(){

    }
    public int count(ArrayList<Sign> signs) {
        int count = 0;
        for (Sign b : signs) {
            if (b.getSign() == '0') {
                count += 1;
            }
        }
        return count;
    }

    public String printBits(ArrayList<Sign> signs) {
        String output = new String();
        for (Sign b : signs) {
            output += b.construct();
        }
        return output;
    }

}