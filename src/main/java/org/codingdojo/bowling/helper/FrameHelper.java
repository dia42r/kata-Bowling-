package org.codingdojo.bowling.helper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class FrameHelper {


    public static Boolean isSpike(String s) {
        return s.equals("X");
    }


    public static Boolean  isSpare(String firstThrow, String secondThrow) {
        return isInteger(firstThrow) && secondThrow.equals("/");
    }


    public static Boolean isOpen(String firstThrow, String secondThrow) {
        return (parse(firstThrow) + parse(secondThrow)) < 10;
    }


    public static Boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public static Integer parse(String aThrow) {
        if (aThrow.equals("X"))
            return 10;
        else if (aThrow.equals("-"))
            return 0;
        else if (isInteger(aThrow))
            return Integer.parseInt(aThrow);

        else throw new IllegalArgumentException(" can't parse this entry " + aThrow);
    }
}
