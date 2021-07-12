package ua.univer.lesson06;

import java.util.Arrays;
import java.util.Comparator;

class Car implements Comparable<Car>{
    private String name;
    private int age;
    private String number;

    public Car(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.getNumber().compareTo(o.getNumber());
    }
}
class CarCompareByAge implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getAge()-o2.getAge();
    }
}
public class ProgramCompare {
    public static <T extends Comparable<T>> int countGreaterThanT(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    public static <T extends Comparable> int countGreaterThan(T [] anArray, T elem){
        int count = 0;
        for (T e: anArray) {
            if ( e.compareTo(elem)>0 ){
                count++;

                System.out.println(e);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Integer [] mas = {1,2,3,4,5,65,67,32};
        System.out.println("*****");
        System.out.println(countGreaterThan(mas, 7));
        String [] strs = {"aa","bb","cc","dd"};
        System.out.println("*****");
        System.out.println(countGreaterThan(strs, "bb"));

        Car [] cars = {
                new Car("Ford",10,"AA1235BB"),
                new Car("Audi",15,"AA1237BB"),
                new Car("Audi",13,"AA1239BB"),
                new Car("BMW",5,"AA1233BB")
        };
        System.out.println(countGreaterThan(cars, new Car("ZAZ", 12,"AA1234BB")));

        System.out.println(mas.length);
        System.out.println(Arrays.toString(mas));
     //   mas = Arrays.copyOf(mas, mas.length*2);

        Arrays.sort(mas);
        System.out.println(mas.length);
        System.out.println(Arrays.toString(mas));

        Arrays.sort(cars, (o1, o2) -> o1.getName().compareTo(o2.getName())
        );
        System.out.println(Arrays.toString(cars));
    }
}
