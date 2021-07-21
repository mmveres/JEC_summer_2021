package ua.univer.lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class MarkException extends Exception {
    public MarkException(String error_mark) {
        super(error_mark);
    }
}

public class ProgramLogExept {
    private static Logger logger = Logger.getLogger(ProgramLogExept.class.getSimpleName());
    static {
        try {
            FileHandler fh = new FileHandler(ProgramLogExept.class.getSimpleName()+".log",true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.WARNING);

        } catch (IOException e) {
            logger.severe("Error create file");

        }
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] marks = new int[5];
        for (int i = 0; i < 5; i++) {
            int mark = getValidMark(br);
            logger.log(Level.INFO,"marks[" + i + "] = " + mark);

            marks[i] = mark;
        }
        logger.info(Arrays.toString(marks));
    }

    private static int getValidMark(BufferedReader br) {
            while (true) {
                try {
                    int valueInt = getValueInt(br);
                    return getMark(valueInt);

                } catch (MarkException | IOException e) {
                   logger.severe("Not Mark");
                }
            }
    }

    private static int getMark(int valueInt) throws MarkException {
        if (3 < valueInt && valueInt < 13)
            return valueInt;
        else
            throw new MarkException("Error mark");
    }

    private static int getValueInt(BufferedReader br) throws IOException {
        while (true) {
            System.out.println("enter int value");
            String str = br.readLine();
            logger.info("entered value = "+str);
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                logger.severe("Not Int try again");
            }
        }
    }
}
