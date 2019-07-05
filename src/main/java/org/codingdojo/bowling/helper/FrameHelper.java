package org.codingdojo.bowling.helper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class FrameHelper {

    public static Boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public static Integer parse(String aThrow) {
        if (aThrow.equals("X") || aThrow.equals("/"))
            return 10;
        else if (aThrow.equals("-"))
            return 0;
        else if (isInteger(aThrow))
            return Integer.parseInt(aThrow);

        else throw new IllegalArgumentException(" can't parse this entry " + aThrow);
    }
}
