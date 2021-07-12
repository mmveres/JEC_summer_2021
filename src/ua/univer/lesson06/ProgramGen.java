package ua.univer.lesson06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
class TwoTuple<A,B>{
    public final A first;
    public final B second;
    public TwoTuple(A first, B second){
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first.getClass() +
                ", second=" + second.getClass() +
                '}';
    }
}
class Inspector {
    public <T> void inspect(T t) {
        System.out.println(t.getClass().getName());
    }
}
public class ProgramGen {
    static int count = 0;
    private static int fib(int n) {
        System.out.println(count++);
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
    private static int fibIter(int n) {
        if (n < 2) return 1;
        int x = 1;
        int y = 1;
        int z = 0;
        for (int i = 2; i < n+1; i++) {
            z = y+x;
            x = y;
            y = z;
            System.out.println(count++);
        }
        return z;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(7);
        for (Integer el: list) {
   //         System.out.println(el);
        }

        TwoTuple<String, String> tt = new TwoTuple<>("1","3") ;
        TwoTuple<Integer, String> tt1 = new TwoTuple<>(1,"3") ;

        System.out.println(tt);
        System.out.println(tt1);
        count =0;
  //      System.out.println(fib(15));
        count =0;
 //       System.out.println(fibIter(15));

        new Inspector().inspect("1");
        new Inspector().<String>inspect("1");
        ErasedTypeEquivalence.main(null);
    }

}
class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        Class c3 = new ArrayList().getClass();
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
    }
}
