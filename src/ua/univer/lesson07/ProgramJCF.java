package ua.univer.lesson07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ProgramJCF {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(12323);
        list.add(1);
        list.add(23);

        for (Integer el: list) {
            System.out.println(el);
        }

    }
}
