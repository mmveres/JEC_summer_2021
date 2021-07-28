package ua.univer.lesson11;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProgramLambda {
    public  static void calculation(BiFunction<Integer,Integer,Integer> op, int x, int y){
        System.out.println(op.apply(x,y));
    }
    public static void main(String[] args) {
        calculation((x, y) ->  x+y, 4,5);
        calculation((x, y) ->  x*y, 4,5);
        calculation((x, y) ->  x-y , 4,5);

        BiFunction<Integer,Integer,Integer> square = (x, y) -> x*y;
        BiFunction<Integer,Integer,Integer> perimetr = (x,y) -> (x+y)*2;

        System.out.println(square.apply(2,5));
        System.out.println(perimetr.apply(2,5));

        Supplier<String> calc = () -> String.valueOf(square.apply(10,10));
        System.out.println(calc.get());
    }
}
