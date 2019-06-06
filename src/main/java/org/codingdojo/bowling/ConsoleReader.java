package org.codingdojo.bowling;

import lombok.extern.slf4j.Slf4j;
import org.codingdojo.bowling.Interface.DataReader;

import java.util.Scanner;


@Slf4j
public class ConsoleReader implements DataReader {

    private Scanner reader;

    public ConsoleReader() {
        this.reader = new Scanner(System.in);
    }


    @Override
    public String read() {
        return  this.reader.nextLine();
    }

}
