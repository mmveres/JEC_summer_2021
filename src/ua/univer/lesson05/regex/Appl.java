package ua.univer.lesson05.regex;
import java.util.regex.*;
public class Appl {
    public static void main(String[] args) {
        String pattern = "[a-z]+";
        String text = "Now is the time";
        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.print(text
                    .substring(m.start(), m.end()) + "*");
        }
    }
}